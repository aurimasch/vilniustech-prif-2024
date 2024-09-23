import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.execute();
    }

    private void execute() throws IOException {
        Map map = new Map();
        Pacman pacman = new Pacman();
        Ghost ghost = new Ghost();

        GameRules gameRules = new GameRules(map, ghost, pacman);
        GameRenderer gameRenderer = new GameRenderer(map, ghost, pacman);


        while (true) {
            int n = System.in.read();
            if (n == 10)
                continue;

            gameRules.processUserInput(n);

            gameRules.progressFrame();

            gameRenderer.renderMap();
        }
    }






}
