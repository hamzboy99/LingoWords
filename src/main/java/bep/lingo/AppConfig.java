package bep.lingo;

import bep.lingo.application.WordProcessor;
import bep.lingo.service.CommandLine;
import bep.lingo.service.TextDeserializer;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    @Bean
    public TextDeserializer textDeserializer() {
        return new TextDeserializer();
    }

    @Bean
    public WordProcessor wordprocessor() {
        return new WordProcessor();
    }

    @Bean
    public CommandLine commandline(){
        final TextDeserializer textDeserializer = new TextDeserializer();
        final WordProcessor wordProcessor =  new WordProcessor();
        return new CommandLine(textDeserializer,wordProcessor);
    }
}