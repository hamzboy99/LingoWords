package bep.lingo.domain;

/**
 *
 *
 * @author Hamza Kayouhi
 */

public class Word {
    private final transient String words;

    public Word(final String word) {
        this.words = word;
    }

    public String getWord(){
        return words;
    }


}