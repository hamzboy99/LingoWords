package bep.lingo.application;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 *
 * @author Hamza Kayouhi
 */

public interface WordProcessorInterface {
    void storeWords(ArrayList<String> content, String file) throws IOException;
    ArrayList<String> filterWords(ArrayList<String> content);

}
