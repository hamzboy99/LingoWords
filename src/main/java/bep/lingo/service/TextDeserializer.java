package bep.lingo.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 *
 * @author Hamza Kayouhi
 */

public class TextDeserializer implements FileDeserializerInterface {

    @Override
    public final ArrayList<String> deserialize(final String file) throws FileNotFoundException {
        final ArrayList<String> words = new ArrayList<>();

        final File myObj = new File(file);
        final Scanner myReader = new Scanner(myObj);
        try {
            while (myReader.hasNextLine()) {
                final String data = myReader.nextLine();
                words.add(data);
            }
        } finally {
            myReader.close();

        }
        return words;
    }
}