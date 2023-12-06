import java.util.HashMap;

/**
 * Clase que representa una pieza del juego 2048.
 */
public class Tile {

    // Valor asociado a la pieza
    private final Value val;

    // Caché para reutilizar instancias de Tile con el mismo valor
    private final static HashMap<Integer, Tile> cache = new HashMap<>();

    // Instancias predefinidas para algunos valores específicos
    public final static Tile ZERO = new Tile(Value._0);
    public final static Tile TWO = new Tile(Value._2);
    public final static Tile FOUR = new Tile(Value._4);

    // Inicialización estática del caché
    static {
        for (Value v : Value.values()) {
            switch (v) {
                case _0:
                    cache.put(v.score(), ZERO);
                    break;
                case _2:
                    cache.put(v.score(), TWO);
                    break;
                case _4:
                    cache.put(v.score(), FOUR);
                    break;
                default:
                    cache.put(v.score(), new Tile(v));
                    break;
            }
        }
    }

    /**
     * Constructor que crea una nueva instancia de Tile con el valor dado.
     *
     * @param v Valor asociado a la pieza.
     */
    public Tile(Value v) {
        val = v;
    }

    /**
     * Obtiene una instancia de Tile para un valor específico.
     *
     * @param num Valor de la pieza.
     * @return Instancia de Tile para el valor dado.
     */
    public static Tile valueOf(int num) {
        return cache.get(num);
    }

    /**
     * Obtiene el valor asociado a la pieza.
     *
     * @return Valor de la pieza.
     */
    Value value() {
        return val;
    }

    /**
     * Duplica el valor de la pieza y devuelve una nueva instancia de Tile.
     *
     * @return Nueva instancia de Tile con el doble del valor.
     */
    public Tile getDouble() {
        return valueOf(val.score() << 1);
    }

    /**
     * Verifica si la pieza está vacía (con valor 0).
     *
     * @return true si la pieza está vacía, false de lo contrario.
     */
    boolean empty() {
        return val == Value._0;
    }

    @Override
    public String toString() {
        return String.format("%1$4d", val.score());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((val == null) ? 0 : val.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Tile))
            return false;
        Tile other = (Tile) obj;
        if (val != other.val)
            return false;
        return true;
    }

    /**
     * Genera una pieza aleatoria con probabilidad de 15% para el valor 4 y 85% para el valor 2.
     *
     * @return Pieza aleatoria generada.
     */
    static Tile randomTile() {
        return Math.random() < 0.15 ? FOUR : TWO;
    }
}