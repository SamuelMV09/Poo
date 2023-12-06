import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Clase principal (Main) para leer y mostrar jugadores desde un archivo.
 */
public class Main2 {

    /**
     * Punto de entrada principal para la aplicación.
     *
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        // Lee la lista de jugadores desde el archivo "puntajes.txt"
        List<Jugador> jugadores = leerJugadoresDesdeArchivo("puntajes.txt");

        // Imprime la información de cada jugador en la consola
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }

    /**
     * Lee la lista de jugadores desde un archivo.
     *
     * @param archivo Nombre del archivo desde el cual leer los jugadores.
     * @return Lista de jugadores leída desde el archivo.
     */
    @SuppressWarnings("unchecked")
    private static List<Jugador> leerJugadoresDesdeArchivo(String archivo) {
        List<Jugador> jugadores = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            // Intenta leer la lista de jugadores desde el archivo
            jugadores = (List<Jugador>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Maneja excepciones de E/S y de clases no encontradas
            e.printStackTrace();
        }
        return jugadores;
    }
}