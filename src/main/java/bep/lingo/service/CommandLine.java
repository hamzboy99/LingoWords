package bep.lingo.service;

import bep.lingo.application.WordProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CommandLine implements CommandLineRunner, CommandLineInterface {
    private final transient TextDeserializer textDeserializer;
    private final transient WordProcessor wordProcessor;
    private static String fileLocation = "src/main/resources/static/basiswoorden-gekeurd.txt";
    private static String newFileLocation = "src/main/resources/static/basiswoorden-aangepast.txt";


    public CommandLine(final TextDeserializer textDeserializer, final WordProcessor wordProcessor) {
        this.textDeserializer = textDeserializer;
        this.wordProcessor = wordProcessor;
    }

    @Override
    public void run(final String... args) throws IOException {
        final List<String> deserializeWords = textDeserializer.deserialize(fileLocation);
        final List<String> filterWords = wordProcessor.filterWords(deserializeWords);
        wordProcessor.storeWords(filterWords, newFileLocation);
    }
}
