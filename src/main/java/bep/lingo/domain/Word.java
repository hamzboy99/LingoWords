package bep.lingo.domain;

public class Word {
    private final transient String lingoword;

    public Word(final String lingoword) {
        this.lingoword = lingoword;
    }

    public String getWord(){
        return lingoword;
    }

}