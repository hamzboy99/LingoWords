package bep.lingo.application;

import java.io.IOException;
import java.util.List;

/**
 *
 *
 * @author Hamza Kayouhi
 */

public interface WordProcessorInterface {
    void storeWords(List<String> content, String file) throws IOException;
    List<String> filterWords(List<String> content);

}
