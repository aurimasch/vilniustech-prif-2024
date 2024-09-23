public class GameRules {

    private Map map;
    private Ghost ghost;
    private Pacman pacman;

    public GameRules(Map map, Ghost ghost, Pacman pacman) {
        this.map = map;
        this.ghost = ghost;
        this.pacman = pacman;
    }

    public void processUserInput(int n) {
        if (n == 'a')
            if (!map.isWall(pacman.getX(), pacman.getY()-1))
                pacman.moveLeft();
        if (n == 'd')
            if (!map.isWall(pacman.getX(), pacman.getY()+1))
                pacman.moveRight();
        if (n == 'w')
            if (!map.isWall(pacman.getX()-1, pacman.getY()))
                pacman.moveUp();
        if (n == 's')
            if (!map.isWall(pacman.getX()+1, pacman.getY()))
                pacman.moveDown();
    }

    public void progressFrame() {
        if (!map.isWall(ghost.getNextX(), ghost.getNextY())) {
            ghost.advance();
        } else {
            ghost.changeDirection();
        }

        if (pacman.isCollide(ghost))
            System.exit(0);
    }
}
