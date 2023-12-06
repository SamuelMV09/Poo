import java.io.Serializable;

/**
 * Clase que representa a un jugador en el juego.
 */
public class Jugador implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nickname;
    private int maxNumeroArmado;
    private int numeroDePasos;

    /**
     * Constructor de la clase Jugador.
     * 
     * @param nickname         El nombre del jugador.
     * @param maxNumeroArmado  La puntuación máxima alcanzada por el jugador.
     * @param numeroDePasos    El número de pasos realizados por el jugador.
     */
    public Jugador(String nickname, int maxNumeroArmado, int numeroDePasos) {
        this.nickname = nickname;
        this.maxNumeroArmado = maxNumeroArmado;
        this.numeroDePasos = numeroDePasos;
    }

    /**
     * Obtiene el nombre del jugador.
     * 
     * @return El nombre del jugador.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Obtiene la puntuación máxima alcanzada por el jugador.
     * 
     * @return La puntuación máxima del jugador.
     */
    public int getMaxNumeroArmado() {
        return maxNumeroArmado;
    }

    /**
     * Obtiene el número de pasos realizados por el jugador.
     * 
     * @return El número de pasos del jugador.
     */
    public int getNumeroDePasos() {
        return numeroDePasos;
    }

    /**
     * Devuelve una representación en cadena del jugador.
     */
    @Override
    public String toString() {
        return "Jugador [nickname=" + nickname + ", maxNumeroArmado=" + maxNumeroArmado + ", numeroDePasos=" + numeroDePasos + "]";
    }
}