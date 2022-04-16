package comp1721.cwk1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Guess {
    // Use this to get player input in readFromPlayer()
    private static final Scanner INPUT = new Scanner(System.in);

    private final int guessNumber;
    private String chosenWord;
    private final int[] flag = {0, 0, 0, 0, 0};

    public int[] getFlag() {
        return flag;
    }

    // TODO: Implement constructor with int parameter
    public Guess(int guessNumberTmp) {
        if (guessNumberTmp <= 0 || guessNumberTmp >= 7){
            throw new GameException("Invalid guess number!");
        }
        this.guessNumber = guessNumberTmp;
    }

    // TODO: Implement constructor with int and String parameters
    public Guess(int guessNumberTmp, String chosenWordTmp){
        if (chosenWordTmp.length() != 5){
            throw new GameException("The word must have the length 5!");
        }
        if (!chosenWordTmp.matches("[a-zA-Z]+")){
            throw new GameException("Invalid word!");
        }
        this.guessNumber = guessNumberTmp;
        this.chosenWord = chosenWordTmp.toUpperCase();
    }

    // TODO: Implement getGuessNumber(), returning an int
    public int getGuessNumber() {
        return guessNumber;
    }

    // TODO: Implement getChosenWord(), returning a String
    public String getChosenWord() {
        return chosenWord;
    }

    // TODO: Implement readFromPlayer()
    public void readFromPlayer() throws IOException {
        chosenWord = INPUT.next();
        chosenWord = chosenWord.toUpperCase();
        WordList wordList = new WordList("data/words.txt");
        if (!chosenWord.matches("[a-zA-Z]+")){
            throw new GameException("Invalid word!");
        }
        if (chosenWord.length() != 5) {
            throw new GameException("The word must have the length 5!");
        }
        if (wordList.getList().indexOf(chosenWord) == -1) {
            throw new GameException("The word you entered is not in the word list!");
        }
    }

    // TODO: Implement compareWith(), giving it a String parameter and String return type
    public String compareWith(String targetWord) {
        ArrayList<Integer> correctPosition = new ArrayList<Integer>();
        String tmp;
        for (int i = 0; i < 5; i++) {
            if (targetWord.charAt(i) == chosenWord.charAt(i)) {
                correctPosition.add(i);
                flag[i] = 2;
            }
        }
        ArrayList<String> tmpTargetWord = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            if (correctPosition.indexOf(i) == -1) {
                tmp = Character.toString(targetWord.charAt(i));
                tmpTargetWord.add(tmp);
            }
        }
        for (int i = 0; i < 5; i++) {
            if (correctPosition.indexOf(i) == -1) {
                if (tmpTargetWord.indexOf(Character.toString(chosenWord.charAt(i))) != -1) {
                    flag[i] = 1;
                    tmpTargetWord.remove(Character.toString(chosenWord.charAt(i)));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (flag[i] == 2){
                result.append("\033[30;102m ").append(chosenWord.charAt(i)).append(" \033[0m");
            }
            else if (flag[i] == 1){
                result.append("\033[30;103m ").append(chosenWord.charAt(i)).append(" \033[0m");
            }
            else{
                result.append("\033[30;107m ").append(chosenWord.charAt(i)).append(" \033[0m");
            }
        }

        return result.toString();
    }

    // TODO: Implement matches(), giving it a String parameter and boolean return type
    public boolean matches(String targetWord) {
        return chosenWord.equals(targetWord);
    }
}
