package bep.lingo.application;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordProcessor implements WordProcessorInterface{
    public List<String> words = new ArrayList<String>();

    public void storeWords(ArrayList<String> content, String file){
        try{
            java.io.File myObj = new java.io.File(file);
            if (myObj.createNewFile()){
                System.out.println("File created"+ myObj.getName());
            }else {
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.out.println("Could not create file");
            e.printStackTrace();
        }
        try{
            FileWriter myWriter = new FileWriter(file,true);
            myWriter.write(String.valueOf(content));
            myWriter.close();
            System.out.println("Succesfully wrote to file");
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        }
    }
}