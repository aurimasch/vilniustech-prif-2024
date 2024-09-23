import java.io.IOException;

public class Main {

    static int[][] map = {
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

    static int pacmanX = 1;
    static int pacmanY = 1;

    static int ghostX = 5;
    static int ghostY = 5;

    static int ghostDx = 1;
    static int ghostDy = 0;


    public static void main(String[] args) throws IOException {

        while (true) {
            int n = System.in.read();
            if (n == 10)
                continue;


            if (n == 'a')
                if (map[pacmanX][pacmanY-1] != 1)
                    pacmanY--;
            if (n == 'd')
                if (map[pacmanX][pacmanY+1] != 1)
                    pacmanY++;
            if (n == 'w')
                if (map[pacmanX-1][pacmanY] != 1)
                    pacmanX--;
            if (n == 's')
                if (map[pacmanX+1][pacmanY] != 1)
                    pacmanX++;

            if (map[ghostX +ghostDx][ghostY +ghostDy] !=1) {
                ghostX = ghostX +ghostDx;
                ghostY = ghostY +ghostDy;
            } else {
                int tmp = ghostDx;
                ghostDx = -1*ghostDy;
                ghostDy = tmp;
            }

            if (pacmanX == ghostX && pacmanY ==ghostY)
                System.exit(0);

            for (int i=0; i<map.length; i++) {
                for (int j=0; j<map[i].length; j++)  {
                    if (map[i][j] == 1)
                        System.out.print("#");
                    if (i == pacmanX && j == pacmanY)
                        System.out.print("C");
                    if (i == ghostX && j == ghostY)
                        System.out.print("G");

                    else if (map[i][j] == 0)
                        System.out.print(" ");


                }
                System.out.println();
            }
        }


    }
}
