package comp1721.cwk1;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  int guessNumber;
  String chosenWord;

  // TODO: Implement constructor with int parameter
  public Guess (int guessNumber) {
    if (guessNumber<=0 || guessNumber>=7)
      throw new GameException("Invalid guess number!");
    this.guessNumber = guessNumber;
  }

  // TODO: Implement constructor with int and String parameters
  public Guess (int guessNumber, String chosenWord) {
    if (chosenWord.length() != 5)
      throw new GameException("Invalid word!");
    if (!chosenWord.matches("[a-zA-Z]+"))
      throw new GameException("Invalid word!");
    this.guessNumber = guessNumber;
    this.chosenWord = chosenWord.toUpperCase();
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
  public void readFromPlayer(){
    chosenWord = INPUT.next();
    chosenWord = chosenWord.toUpperCase();
  }
  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String targetWord){
    ArrayList<Integer> correctPosition = new ArrayList<Integer>();
    int[] flag = {0, 0, 0, 0, 0};
    String tmp;
    for (int i = 0; i < 5; i++){
      if (targetWord.charAt(i) == chosenWord.charAt(i)){
        correctPosition.add(i);
        flag[i] = 2;
      }
    }
    ArrayList<String> tmpTargetWord = new ArrayList<String>();
    for (int i = 0; i < 5; i ++){
      if (correctPosition.indexOf(i) == -1){
        tmp = Character.toString(targetWord.charAt(i));
        tmpTargetWord.add(tmp);
      }
    }
    for (int i = 0; i < 5; i++){
      if (correctPosition.indexOf(i) == -1){
        if (tmpTargetWord.indexOf(Character.toString(chosenWord.charAt(i))) != -1){
          flag[i] = 1;
          tmpTargetWord.remove(Character.toString(chosenWord.charAt(i)));
        }
      }
    }
    String result = "";
    for (int i = 0; i < 5; i++){
      if (flag[i] == 2)
        result += "\033[30;102m " + chosenWord.charAt(i) + " \033[0m";
      else if (flag[i] == 1)
        result += "\033[30;103m " + chosenWord.charAt(i) + " \033[0m";
      else
        result += "\033[30;107m " + chosenWord.charAt(i) + " \033[0m";
    }

    return result;
  }

  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String targetWord){
    if (chosenWord.equals(targetWord))
      return true;
    else
      return false;
  }
}
