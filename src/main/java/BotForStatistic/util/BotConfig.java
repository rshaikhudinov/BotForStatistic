package BotForStatistic.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfig {
    @Value("${telegram.bot.username}")
    String botName;
    @Value("${telegram.bot.token}")
    String token;
}