package bep.lingo.service;

import bep.lingo.application.WordProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CommandLine implements CommandLineInterface, CommandLineRunner {
    private final transient WordRefiner wordRefiner;
    private final transient WordProcessor wordProcessor;
    private static String file = "src/main/resources/static/basiswoorden-gekeurd.txt";
    private static String newFile = "src/main/resources/static/basiswoorden-aangepast.txt";

    public CommandLine(final WordRefiner wordRefiner, final WordProcessor wordProcessor) {
        this.wordRefiner = wordRefiner;
        this.wordProcessor = wordProcessor;
    }

    @Override
    public void run(final String... args) throws IOException {
        final List<String> refineWords = wordRefiner.refine(file);
        final List<String> refinedWords = wordProcessor.refineWords(refineWords);
        wordProcessor.saveWords(refinedWords, newFile);
    }
}
