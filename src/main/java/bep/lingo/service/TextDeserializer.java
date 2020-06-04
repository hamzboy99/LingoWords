package bep.lingo.service;

import bep.lingo.domain.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextDeserializer implements FileDeserializerInterface {

    public ArrayList<String> deserialize(String file) throws FileNotFoundException {
        ArrayList<String> words = new ArrayList<>();

        Pattern r = Pattern.compile("([a-z]{5,7})");
        File myObj = new File(file);
        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Matcher matcher = r.matcher(data);

                if (data.length() >= 5 & data.length() <= 7 & matcher.matches()) {
                    words.add(new Word(data).getWord());
                }
            }
            myReader.close();
        }
        return words;
    }
}