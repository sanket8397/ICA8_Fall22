package test.java;

import main.java.Urinals;
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
    public void whenUrinalDatFileNotExistsThenThrowFileNotFoundException(){
        Throwable thrown = assertThrows(RuntimeException.class,() -> urinals.readFile());
        assertEquals("urinal.dat file does not exist", thrown.getMessage());
    }

}