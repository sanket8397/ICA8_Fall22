package test.java;

import main.java.EmptyInputFileException;
import main.java.Urinals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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
    public void verifyEmptyUrinalDatFile(){
        try {
            urinals.readFile("src/test/resources/emptyUrinal.dat");
        } catch (EmptyInputFileException e) {
            assertTrue(true);
        }
        System.out.println("====== Sanket Surendra Kapse == TEST FIVE EXECUTED =======");
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

    @Test
    public void verifyGetMaximumFreeUrinals(){

        assertEquals(-1, urinals.getMaximumFreeUrinals("abc"));
        assertEquals(-1, urinals.getMaximumFreeUrinals("1111"));
        assertEquals(-1, urinals.getMaximumFreeUrinals("010100101001010010101"));
        assertEquals(-1, urinals.getMaximumFreeUrinals("12345"));
        assertEquals(0, urinals.getMaximumFreeUrinals("10101"));
        assertEquals(1, urinals.getMaximumFreeUrinals("10001"));
        assertEquals(3, urinals.getMaximumFreeUrinals("00000"));
        assertEquals(2, urinals.getMaximumFreeUrinals("10000"));
        assertEquals(1, urinals.getMaximumFreeUrinals("01000"));
        assertEquals(1, urinals.getMaximumFreeUrinals("100010"));
        System.out.println("====== Sanket Surendra Kapse == TEST FOUR EXECUTED =======");
    }

    @Test
    public void verifyGetSolutionWorksCorrectly(){
        try {
            urinals.readFile("src/test/resources/urinalForTestGetSolution.dat");
        } catch (EmptyInputFileException e) {
            throw new RuntimeException(e);
        }
        urinals.getSolution();
        Integer[] expected = {0,3,-1,2,-1,1};
        Integer[] actual = urinals.solution.toArray(new Integer[0]);
        assertArrayEquals(expected, actual);
        System.out.println("====== Sanket Surendra Kapse == TEST SIX EXECUTED =======");
    }

    @Test
    public void whenFileNotExistsThenCreateNewFile() throws IOException {
        File file = new File("src/test/Output/rule.txt");
        Files.deleteIfExists(file.toPath());
        assertDoesNotThrow(() -> urinals.writetoOutput("src/test/Output/rule.txt"));
        System.out.println("====== Sanket Surendra Kapse == TEST SEVEN EXECUTED =======");
    }

    @Test
    public void verifyFileIsDuplicate(){
        urinals.writetoOutput("src/test/Output/rule.txt");
        assertTrue(new File("src/test/Output/rule.txt").exists());
        System.out.println("====== Sanket Surendra Kapse == TEST EIGHT EXECUTED =======");
    }

    @Test
    public void whenFileExistsThenCreateNewFileWithNewName() throws IOException {
        File outputFile = new File("src/test/Output/rule.txt");
        urinals.outputInitialString = "src/test/Output/rule";
        int count = 1;
        while (outputFile.exists()) {
            outputFile = new File(urinals.outputInitialString + count + ".txt");
            Files.deleteIfExists(outputFile.toPath());
            count++;
        }
        urinals.writetoOutput("src/test/Output/rule.txt");
        assertTrue(new File("src/test/Output/rule1.txt").exists());
        System.out.println("====== Sanket Surendra Kapse == TEST NINE EXECUTED =======");
    }

    @Test
    public void verifyFinalOutput(){
        try {
            File file = new File("src/test/Output/rule.txt");
            Files.deleteIfExists(file.toPath());
            urinals.readFile("src/test/resources/urinal.dat");
        } catch (EmptyInputFileException | IOException e) {
            throw new RuntimeException(e);
        }
        urinals.getSolution();
        urinals.outputInitialString = "src/test/Output/rule";
        urinals.writetoOutput("src/test/Output/rule.txt");
    }

}