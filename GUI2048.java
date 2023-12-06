import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Clase que representa la interfaz gráfica del juego 2048.
 */
public class GUI2048 extends JFrame {

    private static final long serialVersionUID = 1L;

    JLabel statusBar;
    private String nickname;
    private int score;
    private int numberOfMoves;

    private static final String TITLE = "2048 in Java";

    public static final String WIN_MSG = "You already win, but you can continue";

    public static final String LOSE_MSG = "You lose, press 'r' to try again!";

    /**
     * Método principal para iniciar el juego.
     * 
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {

        GUI2048 game = new GUI2048();
        Board board = new Board(game);
        if (args.length != 0 && args[0].matches("[0-9]*")) {
            Board.GOAL = Value.of(Integer.parseInt(args[0]));
        }
        KeySetting kb = KeySetting.getkeySetting(board);
        board.addKeyListener(kb);
        game.add(board);

        // Pedir el nickname al inicio
        game.setNickname();

        game.setLocationRelativeTo(null);
        game.setVisible(true);
    }

    /**
     * Constructor de la clase GUI2048.
     */
    public GUI2048() {
        setTitle(TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(340, 400);
        setResizable(false);

        statusBar = new JLabel("");
        add(statusBar, BorderLayout.SOUTH);
    }

    /**
     * Método que se llama cuando el jugador gana el juego.
     */
    public void win() {
        statusBar.setText(WIN_MSG);
    }

    /**
     * Método que se llama cuando el jugador pierde el juego.
     */
    public void lose() {
        statusBar.setText(LOSE_MSG);
    }

    /**
     * Establece el puntaje actual del juego.
     * 
     * @param score Puntaje actual.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Establece el número de movimientos realizados en el juego.
     * 
     * @param numberOfMoves Número de movimientos.
     */
    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }

    /**
     * Obtiene el nickname del jugador.
     * 
     * @return El nickname del jugador.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Establece el nickname del jugador al iniciar el juego.
     */
    private void setNickname() {
        this.nickname = JOptionPane.showInputDialog(this, "Enter your nickname:");
    }
}