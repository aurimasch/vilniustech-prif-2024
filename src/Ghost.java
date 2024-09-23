public class Ghost {
    private int x = 5;
    private int y = 5;
    private int dx = 1;
    private int dy = 0;

    public void advance() {
        x += dx;
        y += dy;
    }

    public void changeDirection() {
        int tmp = dx;
        dx = -dy;
        dy = tmp;
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
