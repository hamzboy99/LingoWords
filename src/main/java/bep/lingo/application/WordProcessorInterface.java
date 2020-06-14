package bep.lingo.application;

import java.io.IOException;
import java.util.List;

public interface WordProcessorInterface {
    void saveWords(List<String> content, String file) throws IOException;
    List<String> refineWords(List<String> content);
}
