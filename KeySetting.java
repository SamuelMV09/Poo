import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Clase que maneja la configuración de teclas para el juego 2048.
 */
public class KeySetting extends KeyAdapter {

    private static final HashMap<Integer, Method> keyMapping = new HashMap<>();

    private static Integer[] KEYS = { KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_R };

    private static Integer[] VI_KEY = { KeyEvent.VK_K, KeyEvent.VK_J, KeyEvent.VK_H, KeyEvent.VK_L };

    private static String[] methodName = { "up", "down", "left", "right", "initTiles" };

    private static Board board;

    private static final KeySetting INSTANCE = new KeySetting();

    /**
     * Obtiene una instancia única de KeySetting asociada a un tablero específico.
     * 
     * @param b El tablero asociado a esta instancia de KeySetting.
     * @return La instancia única de KeySetting.
     */
    public static KeySetting getkeySetting(Board b) {
        board = b;
        return INSTANCE;
    }

    private KeySetting() {
        initKey(KEYS);
        initKey(VI_KEY);
    }

    /**
     * Inicializa el mapeo de teclas con sus correspondientes métodos en la clase Board.
     * 
     * @param kcs Arreglo de códigos de tecla.
     */
    void initKey(Integer[] kcs) {
        for (int i = 0; i < kcs.length; i++) {
            try {
                keyMapping.put(kcs[i], Board.class.getMethod(methodName[i]));
            } catch (NoSuchMethodException | SecurityException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Maneja el evento de tecla presionada.
     * 
     * @param k Evento de tecla presionada.
     */
    @Override
    public void keyPressed(KeyEvent k) {
        super.keyPressed(k);
        Method action = keyMapping.get(k.getKeyCode());
        if (action == null) {
            System.gc();
            return;
        }
        try {
            action.invoke(board);
            board.repaint();
        } catch (InvocationTargetException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (!board.canMove()) {
            board.host.lose();
        }
    }
}