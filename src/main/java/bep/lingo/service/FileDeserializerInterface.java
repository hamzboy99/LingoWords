package bep.lingo.service;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface FileDeserializerInterface {
    ArrayList<String> deserialize(String file) throws FileNotFoundException;
}