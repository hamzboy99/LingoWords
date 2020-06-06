package bep.lingo.application;

import bep.lingo.service.TextDeserializer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *
 * @author Hamza Kayouhi
 */

public class WordProcessor implements WordProcessorInterface {
    private static String fileLocation = "src/main/resources/static/basiswoorden-gekeurd.txt";
    private static String newFileLocation = "src/main/resources/static/basiswoorden-aangepast.txt";
    private static Pattern pattern = Pattern.compile("([a-z]{5,7})");

    public WordProcessor(final TextDeserializer textDeserializer) throws IOException {
        storeWords(filterWords(textDeserializer.deserialize(fileLocation)), newFileLocation);
    }

    @Override
    public ArrayList<String> filterWords(final ArrayList<String> content) {
        final ArrayList<String> checkedWords = new ArrayList<>();
        for (final String data : content) {
            final Matcher matcher = pattern.matcher(data);
            if ((data.length() >= 5) & (data.length() <= 7) & matcher.matches()) {
                checkedWords.add(data);
            }
        }
        return checkedWords;
    }

    @Override
    public final void storeWords(final ArrayList<String> content, final String file) throws IOException {
        final java.io.File myObj = new java.io.File(file);
        if (myObj.createNewFile()) {
            System.out.println("File created" + myObj.getName());
        } else {
            System.out.println("File already exists");
        }
        final BufferedWriter myWriter =  Files.newBufferedWriter(Paths.get(file), StandardCharsets.UTF_8);
        try {
            myWriter.write(String.valueOf(content));
        } finally {
            myWriter.close();
        }
        System.out.println("Succesfully wrote to file");
    }
}