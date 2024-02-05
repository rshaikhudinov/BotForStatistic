package BotForStatistic.util;

import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MyUtil {
    /**
     * Дернуть для генерации классов из Json для данных по матчам
     */
    public String generateClassFromJsonMatchMNHL(){
        JCodeModel codeModel = new JCodeModel();
        URL source = null;
        try {
            source = new URL("https://bigsports.ru/MatchMNHLvnew/assets/api/?endpoint=MatchMNHL/info&MatchMNHL_id=699008&site=b&lang=ru");
        } catch (MalformedURLException e) {
            //throw new RuntimeException(e);
            return "Проблемы с url при генерации java классов из json";
        }
        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }
            @Override
            public SourceType getSourceType() {
                return SourceType.JSON;
            }
        };
        SchemaMapper mapper = new SchemaMapper(
                new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, "MatchMNHLInfo", "MyBot.model.generated", source);
        File file = new File("./src/main/java/");
        try {
            codeModel.build(file);
        } catch (IOException e) {
            //throw new RuntimeException(e);
            return "Проблемы с созданием сгенерированных файлов";
        }
        return "Файлы сгенерированы";
    }
}
