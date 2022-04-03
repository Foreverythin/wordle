package comp1721.cwk1;

import java.util.Scanner;


public class Guess {
  // Use this to get player input in readFromPlayer()
  private static final Scanner INPUT = new Scanner(System.in);

  int guessNumber;
  String chosenWord;

  // TODO: Implement constructor with int parameter
  public Guess (int guessNumber) {
    this.guessNumber = guessNumber;
  }

  // TODO: Implement constructor with int and String parameters
  public Guess (int guessNumber, String chosenWord){
    this.guessNumber = guessNumber;
    this.chosenWord = chosenWord;
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
  }
  // TODO: Implement compareWith(), giving it a String parameter and String return type
  public String compareWith(String targetWord){
    
  }

  // TODO: Implement matches(), giving it a String parameter and boolean return type
  public boolean matches(String targetWord){
    if (chosenWord.toUpperCase().equals(targetWord))
      return true;
    else
      return false;
  }
}
