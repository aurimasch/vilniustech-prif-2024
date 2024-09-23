import java.io.IOException;

public class Main {

    class Map {
        int[][] model = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1,},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
        } ;
    }

    class Pacman {
        int x = 1;
        int y = 1;
    }

    class Ghost {
        int x = 5;
        int y = 5;
        int dx = 1;
        int dy = 0;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.execute();
    }

    private void execute() throws IOException {
        Map map = new Map();
        Pacman pacman = new Pacman();
        Ghost ghost = new Ghost();


        while (true) {
            int n = System.in.read();
            if (n == 10)
                continue;

            processUserInput(n, map, pacman);

            if (map.model[ghost.x +ghost.y][ghost.y +ghost.dy] !=1) {
                moveGhost(ghost);
            } else {
                changeDirection(ghost);
            }

            if (pacman.x == ghost.x && pacman.y ==ghost.y)
                System.exit(0);

            renderMap(map, pacman, ghost);
        }
    }



    private static void renderMap(Map map, Pacman pacman, Ghost ghost) {
        for (int i=0; i<map.model.length; i++) {
            for (int j=0; j<map.model[i].length; j++)  {
                if (map.model[i][j] == 1)
                    System.out.print("#");
                if (i == pacman.x && j == pacman.y)
                    System.out.print("C");
                if (i == ghost.x && j == ghost.y)
                    System.out.print("G");

                else if (map.model[i][j] == 0)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void changeDirection(Ghost ghost) {
        int tmp = ghost.dx;
        ghost.dx = -1*ghost.dy;
        ghost.dy = tmp;
    }

    private static void moveGhost(Ghost ghost) {
        ghost.x =  ghost.x  +ghost.dx;
        ghost.y = ghost.y + ghost.dy;
    }

    private static void processUserInput(int n, Map map, Pacman pacman) {
        if (n == 'a')
            if (map.model[pacman.x][pacman.y-1] != 1)
                pacman.y--;
        if (n == 'd')
            if (map.model[pacman.x][pacman.y+1] != 1)
                pacman.y++;
        if (n == 'w')
            if (map.model[pacman.x-1][pacman.y] != 1)
                pacman.x--;
        if (n == 's')
            if (map.model[pacman.x+1][pacman.y] != 1)
                pacman.x++;
    }
}
