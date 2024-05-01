package timbezhdev.ru.giscalculator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public Graph graph() {return new Graph("Position", "FF0000FF");}
}
