package main.java;

public class Main {
    public static void main(String[] args) throws EmptyInputFileException, BadFileNameException {
        Urinals urinals = new Urinals();
        urinals.readFile("");
        urinals.getSolution();
        urinals.writetoOutput("");
    }
}
