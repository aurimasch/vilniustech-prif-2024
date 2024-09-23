public class Pacman {
    private int x = 1;
    private int y = 1;

    public void moveUp() {
        this.x--;
    }

    public void moveDown() {
        this.x++;
    }

    public void moveLeft() {
        this.y--;
    }

    public void moveRight() {
        this.y++;
    }

    public boolean isCollide(Ghost ghost) {
        return x == ghost.getX() && y ==ghost.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
