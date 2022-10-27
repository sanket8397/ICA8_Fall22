package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author sanketkapse
 */
public class Urinals {

    public void readFile(){
        File file = new File("resources/urinal.dat");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("urinal.dat file does not exist");
        }
    }
    public static void main(String[] args) {
    }
}