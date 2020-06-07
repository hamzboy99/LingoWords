package bep.lingo.service;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author Hamza Kayouhi
 */

public interface FileDeserializerInterface {
    List<String> deserialize(String file) throws FileNotFoundException;
}