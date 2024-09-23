import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

public class WindowsMain extends JFrame {

    private static final int TILE_SIZE = 32;
    public static final String PACMAN_GAME_MESSAGE = "Pacman Game";

    private final Map map = new Map();
    private final Ghost ghost = new Ghost();
    private final Pacman pacman = new Pacman();
    private final GameRules gameRules = new GameRules(map, ghost, pacman);
    private final WindowsRenderer windowsRenderer;
    private final JPanel renderPanel;

    public WindowsMain() throws Exception {
        super(PACMAN_GAME_MESSAGE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        windowsRenderer = new WindowsRenderer(map, ghost, pacman);

        renderPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                windowsRenderer.render(g);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(map.getWidth() * TILE_SIZE, map.getHeight() * TILE_SIZE);
            }
        };

        // Fix flickering issue
        renderPanel.setDoubleBuffered(true);

        getContentPane().add(renderPanel);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char userInput = e.getKeyChar();
                gameRules.processUserInput(userInput);
                renderPanel.repaint();
            }
        });

        new Timer(300, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameRules.progressFrame();
                renderPanel.repaint();
            }
        }).start();

        pack();
        setVisible(true);
    }

    public static void main(String[] s) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                try {
                    new WindowsMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}