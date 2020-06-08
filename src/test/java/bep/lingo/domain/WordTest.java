package bep.lingo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Word domain")
public class WordTest {

    @Test
    @DisplayName("getWord")
    public void testGetForeignWord() {
        final Word word = new Word("Test");
        assertEquals("Test", word.getWord());
    }
}