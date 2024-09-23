import java.util.Random;

public class Ghost {
    private int x = 5;
    private int y = 5;
    private int dx = 1;
    private int dy = 0;
    private final Random random = new Random();

    public void advance() {
        x += dx;
        y += dy;
    }

    public void changeDirection() {
        // previous implementation was incorrect, the Ghost was going in circles
        int direction = random.nextInt(4);
        switch (direction) {
            case 0:
                dx = 0;
                dy = -1;
                break;
            case 1:
                dx = 0;
                dy = 1;
                break;
            case 2:
                dx = -1;
                dy = 0;
                break;
            case 3:
                dx = 1;
                dy = 0;
                break;
        }
    }

    public int getNextX() {
        return x + dx;
    }

    public int getNextY() {
        return y + dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
