package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sanketkapse
 */
public class Urinals {

    /**
     * Reads data from file
     * @param fileName Read from file fileName
     */
    public void readFile(String fileName){
        if (fileName.equals("")){
            fileName = "src/main/resources/urinal.dat";
        }
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("File does not exist");
        }
    }

    /**
     * @param s input string
     * @return True for valid string, False for invalid string
     */
    public boolean verifyValidString(String s){
        Pattern pattern1 = Pattern.compile("^[0-1]{1,20}$");
        Pattern pattern2 = Pattern.compile("11{1}");
        Matcher matcher1 = pattern1.matcher(s);
        Matcher matcher2 = pattern2.matcher(s);
        return matcher1.find() & !matcher2.find();
    }

    public static void main(String[] args) {

    }
}