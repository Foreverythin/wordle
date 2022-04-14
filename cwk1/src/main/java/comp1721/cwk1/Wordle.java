// Main program for COMP1721 Coursework 1
// DO NOT CHANGE THIS!

package comp1721.cwk1;

import java.io.IOException;


public class Wordle {
    public static void main(String[] args) throws IOException {
        Game game = null;
        History history;

        try {
            history = new History("build/history.txt");
        } catch (Exception e){
            history = new History();
        }

        if (args.length == 2) {
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
        } else if (args.length == 1) {
            if (args[0].equals("-a")) {
                // Play today's game
                game = new Game("data/words.txt");
            } else {
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
        } else {
            // Play today's game
            game = new Game("data/words.txt");
        }

        if (args.length == 2) {
            game.playMode2();
        } else if (args.length == 1) {
            if (args[0].equals("-a")) {
                game.playMode2();
            } else {
                game.play();
            }
        } else {
            game.play();
        }

        game.save("build/lastgame.txt");
        history.save("build/history.txt", game.gameNumber, game.tag, game.guessNumber);
    }
}
