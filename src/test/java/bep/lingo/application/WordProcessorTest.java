package bep.lingo.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("WordProcessor")
public class WordProcessorTest {
    private final transient List<String> words = Arrays.asList("mand", "manco", "mandir", "mandala", "mandfles", "tussenin", "bedrijfsgoed", "tussenjaar", "tussenkop", "tussen-n", "bedrijfs-pc-netwerk");
    private final transient List<String> actualWords = Arrays.asList("manco", "mandir", "mandala");
    private static String file = "src/test/resources/storewords.txt";

    public WordProcessorTest() {
    }

    @Test
    @DisplayName("Filter")
    public void testFilterWords() {
        final WordProcessor wordProcessor = new WordProcessor();
        final List<String> checkedWords = wordProcessor.refineWords(words);
        assertEquals(actualWords, checkedWords);
    }

    @Test
    @DisplayName("Store")
    public void testStoreWords() throws IOException {
        final WordProcessor wordProcessor = new WordProcessor();
        final List<String> checkedWords = wordProcessor.refineWords(words);
        wordProcessor.saveWords(actualWords, file);
        assertEquals(actualWords, checkedWords);
    }
}