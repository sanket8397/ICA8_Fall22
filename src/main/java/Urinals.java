package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sanketkapse
 */
public class Urinals {

    public ArrayList<String> inputs = new ArrayList<>();
    public ArrayList<Integer> solution = new ArrayList<>();

    public String outputInitialString;
    /**
     * Reads data from file
     * @param fileName Read from file fileName
     */
    public void readFile(String fileName) throws EmptyInputFileException {
        if (fileName.equals("")){
            fileName = "src/main/resources/urinal.dat";
        }
        File file = new File(fileName);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                inputs.add(line.strip());
            }
            if (inputs.size() == 0)
                throw new EmptyInputFileException(fileName + " is Empty");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File does not exist");
        } catch (EmptyInputFileException e) {
            throw e;
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

    /**
     * @param string Input String
     * @return number of maximum free urinals
     */
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
        return count;
    }

    /**
     * Generate solution list for all inputs
     */
    public void getSolution(){
        for(String input: inputs){
            int temp = getMaximumFreeUrinals(input);
            solution.add(temp);
        }
    }

    public void writetoOutput(String fileName){
        if (fileName.equals("")){
            fileName = "src/main/Output/rule.txt";
        }
        File outputFile = new File(fileName);
        try {
            FileWriter writer = new FileWriter(outputFile);
            for (int i : solution) {
                writer.write(String.valueOf(i));
                writer.write("\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("File does not exist");
        }

    }

    public static void main(String[] args) {

    }
}