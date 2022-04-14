package comp1721.cwk1;

import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class History {
    private final String[] gameNumbers;
    private final String[] correctNumbers;
    private final String[] allNumbers;
    private final String gameNumbersString;
    private final String correctNumbersString;
    private final String allNumbersString;
    private int currentStreak;
    private int longestStreak;

    public String getGameNumbersString() {
        return gameNumbersString;
    }

    public String getCorrectNumbersString() {
        return correctNumbersString;
    }

    public String getAllNumbersString() {
        return allNumbersString;
    }

    public String[] getGameNumbers() {
        return gameNumbers;
    }

    public String[] getCorrectNumbers() {
        return correctNumbers;
    }

    public String[] getAllNumbers() {
        return allNumbers;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public void setCurrentStreak(int currentStreak) {
        this.currentStreak = currentStreak;
    }

    public void setLongestStreak(int longestStreak) {
        this.longestStreak = longestStreak;
    }

    public History(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader br = new BufferedReader(file);
        gameNumbersString = br.readLine();
        gameNumbers = gameNumbersString.split(",");
        correctNumbersString = br.readLine();
        correctNumbers = correctNumbersString.split(",");
        allNumbersString = br.readLine();
        allNumbers = allNumbersString.split(",");
        currentStreak = Integer.parseInt(br.readLine());
        longestStreak = Integer.parseInt(br.readLine());
        br.close();
    }

    public void save(String fileName, int newGameNumber, int newCorrectNumber, int newAllNumber) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        fw.write(gameNumbersString + "," + String.valueOf(newGameNumber)+"\n");
        fw.write(correctNumbersString + "," + String.valueOf(newCorrectNumber)+"\n");
        fw.write(allNumbersString + "," + String.valueOf(newAllNumber)+"\n");
        fw.write(String.valueOf(currentStreak)+"\n");
        fw.write(String.valueOf(longestStreak));
        fw.close();
        System.out.println("Successfully save the history.txt as well!");
    }
}
