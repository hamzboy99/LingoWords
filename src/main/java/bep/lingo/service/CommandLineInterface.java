package bep.lingo.service;

import java.io.IOException;

public interface CommandLineInterface {
    void run(String... args) throws IOException;
}
