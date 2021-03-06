package bep.lingo.integration;


import bep.lingo.application.WordProcessor;
import bep.lingo.service.WordRefiner;
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
    private final transient List<String> actualWords = Arrays.asList("manco", "mandir", "mandala");
    private static String storeLocation = "src/test/resources/storewords.txt";

    public IntegrationTest() {
    }

    public static Stream<Arguments> files() {
        return Stream.of(Arguments.of(textFileLocation),
                Arguments.of(csvFileLocation));
    }

    @ParameterizedTest
    @MethodSource("files")
    @DisplayName("Deserialize")
    public void testApplication(final String fileLocation) throws IOException {
        final WordRefiner wordRefiner = new WordRefiner();
        final WordProcessor wordProcessor = new WordProcessor();

        final List<String> deserializedText = wordRefiner.refine(fileLocation);
        final List<String> checkedWords = wordProcessor.refineWords(deserializedText);
        wordProcessor.saveWords(checkedWords, storeLocation);
        assertEquals(actualWords, checkedWords);
    }
}
