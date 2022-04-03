package comp1721.cwk1;


import java.io.IOException;
import java.util.Scanner;

public class Game {
    String targetWord;
  // TODO: Implement constructor with String parameter
    public Game(String file) throws IOException {
      WordList wordlist = new WordList(file);
      targetWord = wordlist.getWord(0);
    }
  // TODO: Implement constructor with int and String parameters
    public Game(int i, String file) throws IOException {
      WordList wordlist = new WordList(file);
      targetWord = wordlist.getWord(i);
    }
  // TODO: Implement play() method
    public void play(){
      Scanner input = new Scanner(System.in);
      Guess guess;
      int guessNumber = 0;
      String chosenWord;
      while (guessNumber != 6){
        System.out.printf("Enter guess: (%d/6) ", guessNumber+1);
        chosenWord = input.next();
        guess = new Guess(guessNumber, chosenWord);
        System.out.printf(guess.compareWith(targetWord), Character.toUpperCase(chosenWord.charAt(0)), Character.toUpperCase(chosenWord.charAt(1)), Character.toUpperCase(chosenWord.charAt(2)), Character.toUpperCase(chosenWord.charAt(3)), Character.toUpperCase(chosenWord.charAt(4)));
        System.out.printf("\n");
        if (guess.matches(targetWord)){
          System.out.println("Well done!");
          break;
        }
        guessNumber++;
      }

    }
  // TODO: Implement save() method, with a String parameter
    public void save(String file){
      System.out.println("successfully save!");
    }
}
