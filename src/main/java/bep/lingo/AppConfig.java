package bep.lingo;

import bep.lingo.application.WordProcessor;
import bep.lingo.service.TextDeserializer;
import org.springframework.context.annotation.*;

import java.io.IOException;

/**
 *
 *
 * @author Hamza Kayouhi
 */

@Configuration
public class AppConfig {

    @Bean
    public WordProcessor wordProcessor() throws IOException {
        final TextDeserializer textDeserializer = new TextDeserializer();
        return new WordProcessor(textDeserializer);
    }

    @Bean
    public TextDeserializer textDeserializer() {
        return new TextDeserializer();
    }
}
