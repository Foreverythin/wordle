package comp1721.cwk1;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class History {
    // TODO: The gameNumbers
    private final String[] gameNumbers;
    // TODO: The numbers to judge whether win or not. 1 -- win; 0 -- lose.
    private final String[] correctNumbers;
    // TODO: numbers to play the game
    private final String[] allNumbers;
    private final String gameNumbersString;
    private final String correctNumbersString;
    private final String allNumbersString;
    // TODO: the current Streak
    private int currentStreak;
    // TODO: the longest Streak
    private int longestStreak;


    // TODO: Getter of current streak
    public int getCurrentStreak() {
        return currentStreak;
    }

    // TODO: Getter of longest streak
    public int getLongestStreak() {
        return longestStreak;
    }

    // TODO: Setter of current streak
    public void setCurrentStreak(int currentStreakTmp) {
        this.currentStreak = currentStreakTmp;
    }

    // TODO: Setter of longest streak
    public void setLongestStreak(int longestStreakTmp) {
        this.longestStreak = longestStreakTmp;
    }

    // TODO: Constructor, when there is no history.txt in the build directory
    public History() {
        gameNumbers = new String[]{};
        correctNumbers = new String[]{};
        allNumbers = new String[]{};
        gameNumbersString = "";
        correctNumbersString = "";
        allNumbersString = "";
    }

    // TODO: Constructor, when there is the history.txt in the build directory
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

    // TODO: Save the information in the history.txt in the build directory
    public void save(String fileName, int newGameNumber, int newCorrectNumber,
                     int newAllNumber) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        if (!Objects.equals(gameNumbersString, "")) {
            fw.write(gameNumbersString + "," + newGameNumber + "\n");
            fw.write(correctNumbersString + "," + newCorrectNumber + "\n");
            fw.write(allNumbersString + "," + newAllNumber + "\n");
        } else {
            fw.write(newGameNumber + "\n");
            fw.write(newCorrectNumber + "\n");
            fw.write(newAllNumber + "\n");
        }
        fw.write(currentStreak + "\n");
        fw.write(String.valueOf(longestStreak));
        fw.close();
        System.out.println("Successfully save the history.txt as well!");
    }

    // TODO: Show the information of the Number of games played, Percentage of games that were wins,
    //  Length of the current winning streak, Longest winning streak and
    //  Histogram of guess distribution
    public void show(int tag, int lastGuessNumber) throws IOException {
        float win = tag;
        int num1Win = 0;
        int num2Win = 0;
        int num3Win = 0;
        int num4Win = 0;
        int num5Win = 0;
        int num6Win = 0;
        if (win == 1) {
            switch (lastGuessNumber) {
                case 1:
                    num1Win++;
                    break;
                case 2:
                    num2Win++;
                    break;
                case 3:
                    num3Win++;
                    break;
                case 4:
                    num4Win++;
                    break;
                case 5:
                    num5Win++;
                    break;
                case 6:
                    num6Win++;
                    break;
            }
        }

        for (int i = 0; i < correctNumbers.length; i++) {
            if (correctNumbers[i].equals("1")) {
                win++;
            }
        }

        System.out.println("\n------------------------------------------------");
        System.out.println("->Number of games played: " + (gameNumbers.length + 1));
        System.out.printf("->Percentage of games that were wins: %.2f\n",
                win / (correctNumbers.length + 1));
        System.out.println("->Length of the current winning streak: " + currentStreak);
        System.out.println("->Longest winning streak: " + longestStreak);

        for (int i = 0; i < gameNumbers.length; i++) {
            if (correctNumbers[i].equals("1")) {
                if (allNumbers[i].equals("1")) {
                    num1Win++;
                } else if (allNumbers[i].equals("2")) {
                    num2Win++;
                } else if (allNumbers[i].equals("3")) {
                    num3Win++;
                } else if (allNumbers[i].equals("4")) {
                    num4Win++;
                } else if (allNumbers[i].equals("5")) {
                    num5Win++;
                } else if (allNumbers[i].equals("6")) {
                    num6Win++;
                }
            }
        }
        float numWin1 = num1Win / win;
        float numWin2 = num2Win / win;
        float numWin3 = num3Win / win;
        float numWin4 = num4Win / win;
        float numWin5 = num5Win / win;
        float numWin6 = num6Win / win;
        System.out.println("->Histogram of guess distribution: \n");
        System.out.println("nums|                                                               " +
                "                 Probability");
        System.out.println("    ----------------------------------------------------------" +
                "----------------------------------");
        System.out.print("  1 | ");
        for (int i = 0; i < ((int) num1Win / 0.1); i++) {
            System.out.print("???");
        }
        System.out.println(" " + numWin1);
        System.out.println("    | ");
        System.out.print("  2 | ");
        for (int i = 0; i < ((int) num2Win / 0.1); i++) {
            System.out.print("???");
        }
        System.out.println(" " + numWin2);
        System.out.println("    | ");
        System.out.print("  3 | ");
        for (int i = 0; i < ((int) num3Win / 0.1); i++) {
            System.out.print("???");
        }
        System.out.println(" " + numWin3);
        System.out.println("    | ");
        System.out.print("  4 | ");
        for (int i = 0; i < ((int) num4Win / 0.1); i++) {
            System.out.print("???");
        }
        System.out.println(" " + numWin4);
        System.out.println("    | ");
        System.out.print("  5 | ");
        for (int i = 0; i < ((int) num5Win / 0.1); i++) {
            System.out.print("???");
        }
        System.out.println(" " + numWin5);
        System.out.println("    | ");
        System.out.print("  6 | ");
        for (int i = 0; i < ((int) num6Win / 0.1); i++) {
            System.out.print("???");
        }
        System.out.println(" " + numWin6);
    }
}
