package BotForStatistic.component;

import BotForStatistic.model.NotHaveDataException;
import BotForStatistic.model.generated.Event;
import BotForStatistic.model.generated.MatchInfo;
import BotForStatistic.service.MyService;
import BotForStatistic.util.BotConfig;
import BotForStatistic.util.MyUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private Thread myThread;
    private final BotConfig botConfig;
    private final MyService myService;
    private volatile boolean isRunning = false;

    public TelegramBot(BotConfig botConfig, MyService myService) {
        this.botConfig = botConfig;
        this.myService = myService;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            switch (messageText) {
                case "/start" -> startCommandReceived(chatId);
                case "/check" -> {sendMessage(chatId, "Твой id = " + String.valueOf(chatId));System.out.println(chatId);}
                case "/home" -> sendMessage(chatId, "Приветик домашний");
                case "/generate" -> generateClass(chatId);
                case "/startCheckOnline" -> startCheckOnline(chatId);
                case "/insertInf" -> insertInf(chatId);
                case "/stop" -> stopCheckOnline(chatId);
                //case "/checkThirdMatchMNHLStrategy" -> CheckThirdMatchMNHLStrategy(chatId);
                default -> sendMessage(chatId, "Куда пойти?!");
            }
        }
    }

    private void stopCheckOnline(long chatId) {
        stopThread(chatId);
        sendMessage(chatId, "Остановили анализ");
    }

    private void insertInf(long chatId) {
        sendMessage(chatId, myService.insertInf());
    }

    private void startCheckOnline(long chatId) {
        try {
            startThread(chatId);
            //sendMessage(chatId, "Запущен онлайн анализ");
            System.out.println("Запущен онлайн анализ");
        } catch (Exception e) {
            sendMessage(chatId, "Косяк с запуском анализа");
            throw new RuntimeException(e);
        }
    }

    private void generateClass(long chatId) {
        sendMessage(chatId, new MyUtil().generateClassFromJsonMatchMNHL());
    }

    private void startCommandReceived(Long chatId) {
        if (chatId==918053666) {
            sendMessage(chatId, "/home");
            sendMessage(chatId, "/check");
            sendMessage(chatId, "/generate");
            sendMessage(chatId, "/startCheckOnline");
            sendMessage(chatId, "/insertInf");
            sendMessage(chatId, "/stop");
            sendMessage(chatId, "/checkThirdMatchMNHLStrategy");
        }else{
            sendMessage(chatId, "Дратути");
        }
    }

    public void sendMessage(Long chatId, String textToSend){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(textToSend);
        //sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setChatId(chatId);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Не могу отправить сообщение себе");
            System.out.println(e.getMessage());
        }
    }

    private void startThread(long chatId) {
        myThread = new Thread(() -> {
            isRunning = true;
            DateTimeFormatter formatterForBase = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
            sendMessage(chatId, "Запущен онлайн анализ");
            while (isRunning) {
                //запускаем циклом группы
                //дергаем по списку лиги для списка матчей
                int[] divisionIdMNHL = {17910,17911,17912,17913,17914,19276,19277,19278,19279};
                int[] divisionIdMNHL2 = {24006,24007,24008,24009,24010,24011,24012,24013,24014};
                for (int liga : divisionIdMNHL) {
                    //получили дату последней проверки
                    LocalDate dateLastCheck = myService.getLastCheckDate(liga);
                    //получаем список матчей по лиге
                    List<String> MatchMNHLsId;
                    try {
                        MatchMNHLsId = myService.getMatchMNHLesId(liga,dateLastCheck);
                        //проверяем есть ли такой матч в БД, записаны только законченные матчи
                        for (String MatchMNHLId : MatchMNHLsId) {
                            if (myService.checkMatchMNHLOnBD(MatchMNHLId)) {
                                //тут дергаем стратегию для принятия решения о уведомлении
                                //MatchMNHL MatchMNHL = myService.getMatchMNHLById(MatchMNHLId);
                                System.out.println("Матч есть в БД");
                            } else {
                                //матча в БД нет, так что надо дождаться пока он закончится и записать
                                MatchInfo MatchInfo;
                                //дергаем матч пока не будет событие матч завершен
                                boolean isMatchMNHLEnd = false;
                                //int sec = 0;
                                while (!isMatchMNHLEnd) {
                                    RestTemplate restTemplate = new RestTemplate();
                                    String url =
                                            "https://bigsports.ru/matchvnew/assets/api/?endpoint=match/info&match_id=" + MatchMNHLId + "&site=b&lang=ru";
                                    String jsonResponse = restTemplate.getForObject(url, String.class);
                                    ObjectMapper objectMapper = new ObjectMapper();
                                    try {
                                        MatchInfo = objectMapper.readValue(jsonResponse, MatchInfo.class);
                                    } catch (JsonProcessingException e) {
                                        sendMessage(chatId, "Ошибка сериализации json, лига " + liga + " id матча " + MatchMNHLId);
                                        throw new RuntimeException(e);
                                    }
                                    List<Event> events = MatchInfo.getData().getEvents();
                                    for (Event event : events) {
                                        if (event.getEventId() != null) {
                                            // id события конец матча 25
                                            if (event.getEventId() == 25) {
                                                myService.saveMatchMNHL(MatchMNHLId, MatchInfo);
                                                //sendMessage(chatId, "Внесли матч  " + MatchMNHLId + " в лиге " + liga + " по дате " + dateLastCheck);
                                                System.out.println("Внесли матч  " + MatchMNHLId + " в лиге " + liga + " по дате " + dateLastCheck);
                                                isMatchMNHLEnd = true;
                                            }
                                        }
                                    }
                                    try {
                                        Thread.sleep(500);
                                        //sendMessage(chatId, "Жду в онлайне ");
                                    } catch (InterruptedException e) {
                                        sendMessage(chatId, "Не могу сделать паузу в онлайн матче");
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        }
                        //сообщаем об окончании матчей лиги
                        sendMessage(chatId, "закончились матчи лиги, переходим к следующей");
                    } catch (NotHaveDataException e) {
                        sendMessage(chatId, e.getMessage());
                    } catch (Exception e) {
                        sendMessage(chatId, e.getMessage());
                        throw new RuntimeException(e);
                    }
                }
                //тут нужно обновить дату для анализа
                sendMessage(chatId, myService.updateDateLastCheck());
            }
        });
        myThread.start();
    }

    private void stopThread(long chatId) {
        System.out.println("пробую остановить поток");
        isRunning = false;
        myThread.interrupt();
        sendMessage(chatId, "Остановлен");
    }
}