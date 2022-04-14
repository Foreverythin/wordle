package comp1721.cwk1;


import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class Game {
    private final String targetWord;
    private String outText = "";

    public String getTargetWord() {
        return targetWord;
    }

    public String getOutText() {
        return outText;
    }

    // TODO: Implement constructor with String parameter
    public Game(String file) throws IOException {
        WordList wordlist = new WordList(file);
        LocalDate firstDay = LocalDate.of(2021, 6, 19);
        LocalDate today = LocalDate.now();
        int days = (int) (today.toEpochDay() - firstDay.toEpochDay());
        targetWord = wordlist.getWord(days);
    }

    // TODO: Implement constructor with int and String parameters
    public Game(int i, String file) throws IOException {
        WordList wordlist = new WordList(file);
        targetWord = wordlist.getWord(i);
    }

    // TODO: Implement play() method
    public void play() throws IOException {
        int tag = 0;
        Guess guess = null;
        int guessNumber = 1;
        boolean valid;
        while (guessNumber != 7) {
            valid = false;
            while (!valid) {
                while (!valid) {
                    try {
                        guess = new Guess(guessNumber);
                        valid = true;
                    } catch (GameException e) {
                        System.out.println(e.getMessage());
                    }
                }
                valid = false;
                while (!valid) {
                    try {
                        System.out.printf("Enter guess (%d/6): ", guessNumber);
                        guess.readFromPlayer();
                        valid = true;
                    } catch (GameException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            System.out.println(guess.compareWith(targetWord));
            outText += guess.compareWith(targetWord) + "\n";
            if (guess.matches(targetWord)) {
                tag += 1;
                break;
            }
            guessNumber++;
        }
        if (tag == 1) {
            if (guessNumber == 1) {
                System.out.println("Superb - Got it in one!");
            } else if (guessNumber >= 2 && guessNumber <= 5) {
                System.out.println("Well done!");
            } else if (guessNumber == 6) {
                System.out.println("That was a close call!");
            }
        } else {
            System.out.println("Nope - Better luck next time! ");
        }
    }

    // TODO: Implement playMode2() method
    // This method is used for people who have impaired colour vision, or
    // people who rely on screen readers.
    public void playMode2() throws IOException {
        int tag = 0;
        int[] flag;
        int num2;
        int num1;
        String out1 = "";
        String out2 = "";
        ArrayList<Integer> positionOf2;
        ArrayList<Integer> positionOf1;
        HashMap<Integer, String> position = new HashMap<Integer, String>();
        position.put(1, "1st");
        position.put(2, "2nd");
        position.put(3, "3rd");
        position.put(4, "4th");
        position.put(5, "5th");
        Guess guess = null;
        int guessNumber = 1;
        boolean valid;
        while (guessNumber != 7) {
            valid = false;
            while (!valid) {
                while (!valid) {
                    try {
                        guess = new Guess(guessNumber);
                        valid = true;
                    } catch (GameException e) {
                        System.out.println(e.getMessage());
                    }
                }
                valid = false;
                while (!valid) {
                    try {
                        System.out.printf("Enter guess (%d/6): ", guessNumber);
                        guess.readFromPlayer();
                        valid = true;
                    } catch (GameException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            outText += guess.compareWith(targetWord) + "\n";
            flag = guess.getFlag();
            num1 = 0;
            num2 = 0;
            for (int element : flag) {
                if (element == 2) {
                    num2 += 1;
                } else if (element == 1) {
                    num1 += 1;
                }
            }
            if (num1 == 0 && num2 == 0) {
                System.out.println("The 5 letters you entered are not in the target word");
            } else {
                positionOf2 = new ArrayList<Integer>();
                positionOf1 = new ArrayList<Integer>();
                for (int i = 0; i < 5; i++) {
                    if (flag[i] == 2) {
                        positionOf2.add(i + 1);
                    } else if (flag[i] == 1) {
                        positionOf1.add(i + 1);
                    }
                }
                if (num1 == 1) {
                    out1 = String.format("%s correct but in wrong place",
                            position.get(positionOf1.get(0)));
                } else if (num1 == 2) {
                    out1 = String.format("%s and %s correct but in wrong place",
                            position.get(positionOf1.get(0)), position.get(positionOf1.get(1)));
                } else if (num1 == 3) {
                    out1 = String.format("%s, %s and %s correct but in wrong place",
                            position.get(positionOf1.get(0)),
                            position.get(positionOf1.get(1)), position.get(positionOf1.get(2)));
                } else if (num1 == 4) {
                    out1 = String.format("%s, %s, %s and %s correct but in wrong place",
                            position.get(positionOf1.get(0)), position.get(positionOf1.get(1)),
                            position.get(positionOf1.get(2)), position.get(positionOf1.get(3)));
                } else if (num1 == 5) {
                    out1 = "All letters are correct but in wrong place";
                }
                if (num2 == 1) {
                    out2 = String.format("%s perfect", position.get(positionOf2.get(0)));
                } else if (num2 == 2) {
                    out2 = String.format("%s and %s perfect", position.get(positionOf2.get(0)),
                            position.get(positionOf2.get(1)));
                } else if (num2 == 3) {
                    out2 = String.format("%s, %s and %s perfect", position.get(positionOf2.get(0)),
                            position.get(positionOf2.get(1)), position.get(positionOf2.get(2)));
                } else if (num2 == 4) {
                    out2 = String.format("%s, %s, %s and %s perfect",
                            position.get(positionOf2.get(0)),
                            position.get(positionOf2.get(1)), position.get(positionOf2.get(2)),
                            position.get(positionOf2.get(3)));
                } else if (num2 == 5) {
                    out2 = "All letters perfert";
                }
                if (num1 == 0) {
                    System.out.println(out2);
                } else if (num2 == 0) {
                    System.out.println(out1);
                } else {
                    System.out.println(out1 + ", " + out2);
                }
            }
            if (guess.matches(targetWord)) {
                tag += 1;
                break;
            }
            guessNumber++;
        }
        if (tag == 1) {
            if (guessNumber == 1) {
                System.out.println("Superb - Got it in one!");
            } else if (guessNumber >= 2 && guessNumber <= 5) {
                System.out.println("Well done!");
            } else if (guessNumber == 6) {
                System.out.println("That was a close call!");
            }
        } else {
            System.out.println("Nope - Better luck next time! ");
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
