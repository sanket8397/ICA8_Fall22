package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author sanketkapse
 */
public class Urinals {

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
    public static void main(String[] args) {

    }
}