package bep.lingo.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 *
 *
 * @author Hamza Kayouhi
 */

public interface FileDeserializerInterface {
    ArrayList<String> deserialize(String file) throws FileNotFoundException;
}