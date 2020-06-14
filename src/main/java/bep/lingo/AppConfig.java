package bep.lingo;

import bep.lingo.application.WordProcessor;
import bep.lingo.service.CommandLine;
import bep.lingo.service.WordRefiner;
import org.springframework.context.annotation.*;

@Configuration
public class AppConfig {

    public AppConfig() {
    }

    @Bean
    public WordRefiner textDeserializer() {
        return new WordRefiner();
    }

    @Bean
    public WordProcessor wordprocessor() {
        return new WordProcessor();
    }

    @Bean
    public CommandLine commandline(){
        final WordRefiner wordRefiner = new WordRefiner();
        final WordProcessor wordProcessor =  new WordProcessor();
        return new CommandLine(wordRefiner,wordProcessor);
    }
}