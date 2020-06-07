package bep.lingo.application;

import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Hamza Kayouhi
 */

@Service
public class WordProcessor implements WordProcessorInterface {
    private static Pattern pattern = Pattern.compile("([a-z]{5,7})");

    @Override
    public List<String> filterWords(final List<String> content) {
        final ArrayList<String> checkedWords = new ArrayList<>();
        for (final String data : content) {
            final Matcher matcher = pattern.matcher(data);
            if (matcher.matches()) {
                checkedWords.add(data);
            }
        }
        return checkedWords;
    }

    @Override
    public final void storeWords(final List<String> content, final String file) throws IOException {
        final java.io.File myObj = new java.io.File(file);
        myObj.createNewFile();
        final BufferedWriter myWriter = Files.newBufferedWriter(Paths.get(file), StandardCharsets.UTF_8);
        try {
            myWriter.write(String.valueOf(content));
        } finally {
            myWriter.close();
        }
    }
}