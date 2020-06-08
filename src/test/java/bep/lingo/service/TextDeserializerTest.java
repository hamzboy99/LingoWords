package bep.lingo.service;

import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@VisibleForTesting
@DisplayName("TextDeserializer")
public class TextDeserializerTest {
    private static String textFileLocation = "src/test/resources/deserializetext.txt";
    private static List<String> words = Arrays.asList("mand", "manco", "mandir", "mandala", "mandfles", "tussenin", "bedrijfsgoed", "tussenjaar", "tussenkop", "tussen-n", "bedrijfs-pc-netwerk");

    @Test
    @DisplayName("Deserialize")
    public void testDeserialize() throws FileNotFoundException {
        final TextDeserializer textDeserializer = new TextDeserializer();
        final List<String> deserializedText = textDeserializer.deserialize(textFileLocation);
        assertEquals(words, deserializedText);
    }

    @Test
    @DisplayName("File not Found")
    public void testFileNotFoundException() {
        final TextDeserializer textDeserializer = new TextDeserializer();
        assertThrows(FileNotFoundException.class, () -> textDeserializer.deserialize("text.txt"));
    }
}