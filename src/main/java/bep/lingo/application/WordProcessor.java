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

@Service
public class WordProcessor implements WordProcessorInterface {
    private static Pattern pattern = Pattern.compile("([a-z]{5,7})");

    public WordProcessor() {
    }

    @Override
    public List<String> refineWords(final List<String> words) {
        final ArrayList<String> refinedWords = new ArrayList<>();
        for (final String data : words) {
            final Matcher matcher = pattern.matcher(data);
            if (matcher.matches()) {
                refinedWords.add(data);
            }
        }
        return refinedWords;
    }

    @Override
    public final void saveWords(final List<String> content, final String file) throws IOException {
        final java.io.File myObj = new java.io.File(file);
        myObj.createNewFile();
        final BufferedWriter myWriter = Files.newBufferedWriter(Paths.get(file), StandardCharsets.UTF_8);
        try {
            for (final String data : content) {
                myWriter.write(String.valueOf(data));
                myWriter.newLine();
            }
        } finally {
            myWriter.close();
        }
    }
}