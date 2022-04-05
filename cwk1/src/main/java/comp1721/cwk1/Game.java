package comp1721.cwk1;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;


public class Game {
    String targetWord;
    WordList wordList = new WordList("data/words.txt");
    String outText = "";
  // TODO: Implement constructor with String parameter
    public Game(String file) throws IOException {
      WordList wordlist = new WordList(file);
      LocalDate firstDay = LocalDate.of(2021, 6, 19);
      LocalDate today = LocalDate.now();
      int days = (int)(today.toEpochDay() - firstDay.toEpochDay());
      targetWord = wordlist.getWord(days);
    }
  // TODO: Implement constructor with int and String parameters
    public Game(int i, String file) throws IOException {
      WordList wordlist = new WordList(file);
      targetWord = wordlist.getWord(i);
    }
  // TODO: Implement play() method
    public void play() {
      Scanner input = new Scanner(System.in);
      Guess guess;
      int guessNumber = 1;
      String chosenWord;
      while (guessNumber != 7){
        System.out.printf("Enter guess (%d/6): ", guessNumber);
        guess = new Guess(guessNumber);
        guess.readFromPlayer();
        if (wordList.list.indexOf(guess.chosenWord) != -1){
          System.out.println(guess.compareWith(targetWord));
          outText += guess.compareWith(targetWord) + "\n";
          if (guess.matches(targetWord)){
            System.out.println("Well done!");
            break;
          }
          guessNumber++;
        }else{
          throw new GameException("The word you entered is not in the word list!");
        }
      }

    }
  // TODO: Implement save() method, with a String parameter
    public void save(String file) throws IOException {
      FileWriter fw = new FileWriter(file);
      fw.write(outText);
      fw.close();
      System.out.println("successfully save!");
    }
}
