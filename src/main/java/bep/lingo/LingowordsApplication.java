package bep.lingo;

import bep.lingo.application.WordProcessor;
import bep.lingo.service.TextDeserializer;

import java.io.FileNotFoundException;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
public class LingowordsApplication {

	public static void main(String[] args) throws FileNotFoundException {
		TextDeserializer textconverter = new TextDeserializer();
		WordProcessor wordprocessor = new WordProcessor();
		textconverter.deserialize("src/main/resources/static/basiswoorden-gekeurd.txt");
		wordprocessor.storeWords(textconverter.deserialize("src/main/resources/static/basiswoorden-gekeurd.txt"),"src/main/resources/static/basiswoorden-aangepast.txt");

//		SpringApplication.run(LingowordsApplication.class, args);
	}

}
