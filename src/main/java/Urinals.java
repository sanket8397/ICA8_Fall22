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
            System.out.println("Not yet implemented");

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

    public int getMaximumFreeUrinals(String string){
        if (!verifyValidString(string)){
            return -1;
        }
        StringBuilder s = new StringBuilder(string);
        int count = 0;
        if(s.length() == 1) {
            if (s.charAt(0) == '0') {
                return 1;
            }
        }
        if(s.length() == 2) {
            if ((s.charAt(0) == '0') & (s.charAt(1) == '0')) {
                return 1;
            }
        }
        if (s.charAt(0) == '0'){
            if (s.charAt(1) == '0'){
                s.setCharAt(0, '1');
                count++;
            }
        }
        int i;
        for (i = 1; i < s.length() - 1; i++){
            if (s.charAt(i) == '0'){
                if ((s.charAt(i-1) == '0') & (s.charAt(i+1) == '0')){
                    count = count+1;
                    s.setCharAt(i, '1');
                }
            }
        }
        if (s.charAt(s.length() - 1) == '0'){
            if (s.charAt(s.length() - 2) == '0'){
                count++;
                s.setCharAt(i, '1');
            }
        }
//        System.out.println(s);
//        System.out.println("-----");
        return count;
    }

    public static void main(String[] args) {

    }
}