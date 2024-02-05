package BotForStatistic.service;

import BotForStatistic.model.DivisionMNHLInf;
import BotForStatistic.model.MatchMNHL;
import BotForStatistic.model.NotHaveDataException;
import BotForStatistic.model.generated.MatchInfo;
import BotForStatistic.repository.DivisionMNHLInfRepository;
import BotForStatistic.repository.MatchMNHLRepository;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

@Service
public class MyService {
    @Autowired
    DivisionMNHLInfRepository DivisionMNHLInfRepository;
    @Autowired
    MatchMNHLRepository MatchMNHLRepository;
    /**
     * @param liga лига
     * @param dateCheck дата
     * @return Возвращает массив с id матчей в группе по дате
     * @throws Exception исключения
     */
    public List<String> getMatchMNHLesId(int liga, LocalDate dateCheck) throws Exception {
        List<String> MatchMNHLsId = new ArrayList<>();
        DateTimeFormatter formatterNow = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = dateCheck.format(formatterNow);
        String jsonUrl =
                "https://api.bigsports.ru/api/mass_media/?league=" + liga + "&date=" + date + "&status=4&apikey=NXbK9dDSoGlGx2TiNFh6po9evLh2iWk9";
        URL urlObject = new URL(jsonUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlObject.openStream()));
        // Читаем JSON-строку из входного потока
        StringBuilder jsonContent = new StringBuilder();
        String inputLine;
        while ((inputLine = reader.readLine()) != null) {
            jsonContent.append(inputLine);
        }
        reader.close();
        if (jsonContent.toString().length() < 3) throw new NotHaveDataException("Нет данных по дате " + date);
        // Парсим JSON-строку
        JsonObject jsonObject = JsonParser.parseString(jsonContent.toString()).getAsJsonObject();
        //получаем первый объект, это все матчи группы
        JsonObject firstObject = jsonObject.entrySet().iterator().next().getValue().getAsJsonObject();
        //перебираем все матчи группы
        for (Map.Entry<String, JsonElement> entry : firstObject.entrySet()) {
            //получаем id каждого матча в группе
            MatchMNHLsId.add(entry.getKey());
        }
        return MatchMNHLsId;
    }
    /**
     * Обновляем данные по лигам
     */
    public String insertInf() {
        DivisionMNHLInf DivisionMNHLInf = new DivisionMNHLInf();
        //вносим новые данные по ACL лигам
        int[] divisionIdMNHL = {17910,17911,17912,17913,17914,19276,19277,19278,19279};
        String[] divisionNameACL = {"MNHL A","MNHL B","MNHL C","MNHL D","MNHL E","MNHL F","MNHL G","MNHL H","MNHL I"};
        IntStream.range(0, divisionIdMNHL.length)
                .forEach(i -> {
                    DivisionMNHLInf.setDivisionId(divisionIdMNHL[i]);
                    DivisionMNHLInf.setDivisionName(divisionNameACL[i]);
                    DivisionMNHLInf.setDateLastCheck(LocalDate.of(2023, 9, 11));
                    DivisionMNHLInfRepository.save(DivisionMNHLInf);
                });
        return ("Данные обновлены");
    }
    /**
     * Возвращает дату последней проверки
     * @param liga id лиги
     * @return дата
     */
    public LocalDate getLastCheckDate(int liga) {
        DivisionMNHLInf DivisionMNHLInf = DivisionMNHLInfRepository.findByDivisionId(liga);
        return DivisionMNHLInf.getDateLastCheck();
    }
    /**
     * Проверяем есть матч в БД
     * @param MatchMNHLId id матча
     * @return true если матч есть, false если матча нет
     */
    public boolean checkMatchMNHLOnBD(String MatchMNHLId) {
        return MatchMNHLRepository.findById(MatchMNHLId) != null;
    }
    /**
     * Сохраняем завершенный матч в БД
     * @param MatchMNHLId id матча
     * @param MatchInfo обьект с данными матча
     */
    public void saveMatchMNHL(String MatchMNHLId, MatchInfo MatchInfo) {
        DateTimeFormatter formatterForBase = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        MatchMNHLRepository.save(new MatchMNHL(
                MatchMNHLId,
                MatchInfo.getData().getGameInfo().getDivisionId(),
                LocalDateTime.parse(MatchInfo.getData().getGameInfo().getDate(), formatterForBase),
                MatchInfo.getData().getGameInfo().getTeams().getHome().getName(),
                MatchInfo.getData().getGameInfo().getTeams().getAway().getName(),
                MatchInfo.getData().getGameInfo().getScore().getHome(),
                MatchInfo.getData().getGameInfo().getScore().getAway(),
                MatchInfo.getData().getGameInfo().getScore().getScorePeriod(),
                //сохраняем события матча в json
                new Gson().toJson(MatchInfo.getData().getEvents())
        ));
    }
    /**
     *
     * @param MatchMNHLId id матча
     * @return возвращает матч
     */
    public MatchMNHL getMatchMNHLById(String MatchMNHLId){
        return MatchMNHLRepository.findById(MatchMNHLId);
    }

    /**
     * Обновляем дату последней проверки, добавляем 1 день
     * @return текст сообщения
     */
    public String updateDateLastCheck() {
        int[] divisionIdMNHL = {17910,17911,17912,17913,17914,19276,19277,19278,19279};
        Arrays.stream(divisionIdMNHL).forEach(item -> {
            DivisionMNHLInf DivisionMNHLInf = DivisionMNHLInfRepository.findByDivisionId(item);
            DivisionMNHLInf.setDateLastCheck(DivisionMNHLInf.getDateLastCheck().plusDays(1));
            DivisionMNHLInfRepository.save(DivisionMNHLInf);
        });

        return "Обновили дату для анализа, теперь " + DivisionMNHLInfRepository.findByDivisionId(divisionIdMNHL[0]).getDateLastCheck();
    }
    public List<MatchMNHL> getMatchMNHLesIdFromRepository(int liga, LocalDate dateStart) {
        Sort sort = Sort.by(Sort.Direction.ASC, "date"); // Сортировка по убыванию даты
        return MatchMNHLRepository.findAllByDivisionIdAndDateBetween(
                liga,
                dateStart.atStartOfDay(),
                dateStart.atTime(LocalTime.MAX),
                sort);
    }
}
