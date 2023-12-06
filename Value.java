import java.awt.Color;

/**
 * Enumeración que representa los posibles valores de las fichas en el juego 2048.
 */
public enum Value {

    _0(0, 0x776e65, 0xcdc0b4),
    _2(2, 0x776e65, 0xeee4da),
    _4(4, 0x776e65, 0xede0c8),
    _8(8, 0xf9f6f2, 0xf2b179),
    _16(16, 0xf9f6f2, 0xf59563),
    _32(32, 0xf9f6f2, 0xf67c5f),
    _64(64, 0xf9f6f2, 0xf65e3b),
    _128(128, 0xf9f6f2, 0xedcf72),
    _256(256, 0xf9f6f2, 0xedcc61),
    _512(512, 0xf9f6f2, 0xedc850),
    _1024(1024, 0xf9f6f2, 0xedc53f),
    _2048(2048, 0xf9f6f2, 0xedc22e);

    // Puntaje asociado al valor de la ficha
    private final int score;

    // Color de fondo de la ficha
    private final Color color;

    // Color de la fuente (número) en la ficha
    private final Color fontColor;

    /**
     * Constructor privado para crear instancias de Value con valores específicos.
     *
     * @param n Puntaje asociado al valor de la ficha.
     * @param f Color de la fuente en la ficha.
     * @param c Color de fondo de la ficha.
     */
    private Value(int n, int f, int c) {
        score = n;
        color = new Color(c);
        fontColor = new Color(f);
    }

    /**
     * Obtiene una instancia de Value para un número específico.
     *
     * @param num Número asociado al valor de la ficha.
     * @return Instancia de Value correspondiente al número dado.
     */
    static Value of(int num) {
        return Value.valueOf("_" + num);
    }

    /**
     * Obtiene el color de la fuente (número) en la ficha.
     *
     * @return Color de la fuente en la ficha.
     */
    public Color fontColor() {
        return fontColor;
    }

    /**
     * Obtiene el color de fondo de la ficha.
     *
     * @return Color de fondo de la ficha.
     */
    public Color color() {
        return color;
    }

    /**
     * Obtiene el puntaje asociado al valor de la ficha.
     *
     * @return Puntaje asociado al valor de la ficha.
     */
    public int score() {
        return score;
    }
}