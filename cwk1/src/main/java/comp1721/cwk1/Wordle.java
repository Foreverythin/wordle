// Main program for COMP1721 Coursework 1
// DO NOT CHANGE THIS!

package comp1721.cwk1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class Wordle {
    public static void main(String[] args) throws IOException {
        Game game = null;
        History history = null;

        try {
            history = new History("build/history.txt");
        }catch (Exception e){

        }

        if (args.length == 2){
            // Player wants to specify the game
            boolean valid = false;
            while (!valid) {
                try {
                    game = new Game(Integer.parseInt(args[1]), "data/words.txt");
                    valid = true;
                } catch (GameException e) {
                    System.out.println(e.getMessage());
                }
            }
        }else if (args.length == 1){
            if (args[0].equals("-a")){
                // Play today's game
                game = new Game("data/words.txt");
            }
            else{
                // Player wants to specify the game
                boolean valid = false;
                while (!valid) {
                    try {
                        game = new Game(Integer.parseInt(args[0]), "data/words.txt");
                        valid = true;
                    } catch (GameException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }else{
            // Play today's game
            game = new Game("data/words.txt");
        }

        if (args.length == 2){
            game.playMode2();
        }else if (args.length == 1){
            if (args[0].equals("-a")){
                game.playMode2();
            }
            else{
                game.play();
            }
        }else{
            game.play();
        }

        game.save("build/lastgame.txt");

        history.setCurrentStreak(100);
        history.setLongestStreak(100);
        if (history == null){
            history.save("build/history.txt", 100, 100, 100);
        }else{
            history.save("build/history.txt", 100, 100, 100);
        }
    }
}
