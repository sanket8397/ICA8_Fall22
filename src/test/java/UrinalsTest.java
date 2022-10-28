package test.java;

import main.java.Urinals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test cases for Urinals Class
 * @author sanketkapse
 */
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
        System.out.println("====== Sanket Surendra Kapse == TEST ONE EXECUTED =======");
    }

    @Test
    public void verifyUrinalDatFileExists(){
        Assertions.assertDoesNotThrow(() -> urinals.readFile("src/test/resources/urinal.dat"));
        System.out.println("====== Sanket Surendra Kapse == TEST TWO EXECUTED =======");
    }

    @Test
    public void verifyValidInputString(){
        assertFalse(urinals.verifyValidString("1111"));
        assertTrue(urinals.verifyValidString("10101"));
        assertTrue(urinals.verifyValidString("1"));
        assertTrue(urinals.verifyValidString("01010010100101001010"));
        assertFalse(urinals.verifyValidString("010100101001010010101"));
        assertFalse(urinals.verifyValidString("10101101011010110101"));
        assertFalse(urinals.verifyValidString("q101b"));
        assertFalse(urinals.verifyValidString("12345"));
        System.out.println("====== Sanket Surendra Kapse == TEST THREE EXECUTED =======");
    }

}