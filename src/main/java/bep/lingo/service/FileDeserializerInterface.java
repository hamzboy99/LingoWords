package bep.lingo.service;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileDeserializerInterface {
    List<String> refine(String file) throws FileNotFoundException;
}