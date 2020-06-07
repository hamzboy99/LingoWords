package bep.lingo.integration;


import bep.lingo.application.WordProcessor;
import bep.lingo.service.TextDeserializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("integration")
@DisplayName("Integration test")
public class IntegrationTest {
    private static String textFileLocation = "src/test/resources/deserializetext.txt";
    private static String csvFileLocation = "src/test/resources/deserializetext.csv";
    private final transient List<String> actualWords = Arrays.asList("kwijl", "hijgen", "hipheid");
    private static String storeLocation = "src/test/resources/storewords.txt";

    public static Stream<Arguments> files() {
        return Stream.of(Arguments.of(textFileLocation),
                Arguments.of(csvFileLocation));
    }

    @ParameterizedTest
    @MethodSource("files")
    @DisplayName("Deserialize")
    public void testApplication(final String fileLocation) throws IOException {
        final TextDeserializer textDeserializer = new TextDeserializer();
        final WordProcessor wordProcessor = new WordProcessor();

        final List<String> deserializedText = textDeserializer.deserialize(fileLocation);
        final List<String> checkedWords = wordProcessor.filterWords(deserializedText);
        wordProcessor.storeWords(checkedWords, storeLocation);
        assertEquals(actualWords, checkedWords);
    }
}
