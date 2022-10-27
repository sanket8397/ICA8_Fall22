package test.java;

import main.java.Urinals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    Urinals urinals;

    @BeforeEach
    void setup(){
        urinals = new Urinals();
    }

    @Test
    public void whenFileNotExistsThenThrowFileNotFoundException(){
        Throwable thrown = assertThrows(RuntimeException.class,() -> urinals.readFile("resources/dummy.dat"));
        assertEquals("File does not exist", thrown.getMessage());
    }

    @Test
    public void verifyUrinalDatFileExists(){
        Assertions.assertDoesNotThrow(() -> urinals.readFile("src/test/resources/urinal.dat"));
    }


}