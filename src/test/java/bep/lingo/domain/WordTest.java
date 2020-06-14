package bep.lingo.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Domain Word")
public class WordTest {

    public WordTest() {
    }

    @Test
    @DisplayName("getTheWord")
    public void testGetForeignWord() {
        final Word word = new Word("Test");
        assertEquals("Test", word.getWord());
    }
}