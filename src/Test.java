/**
 * Clase que solicita al usuario que ingrese diferentes palabras
 * No están permitas las palabras prohibidas definidas en el array {@code tpalabros}
 * Si se introduce una de estas palabras, se ejecuta una excepción personalizada {@code BurradasNOException}
 */
import java.util.Scanner;

public class Test {
    /**
     * Muestra del array de palabras prohibidas que no pueden aparecer en las palabras introducidas por el usuario
     */
    static String tpalabros[] = { "caca", "culo", "pedo", "pis" };

    /**
     * Método principal que gestiona la entrada del usuario
     * 
     * @param argv Argumentos de la línea de comandos
     */
    public static void main(String argv[]) {
        String cadena = "";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduce tus mensajes, o pulsa . Para terminar:");
            try {
                cadena = leerLineaOK(sc);
                System.out.println("OK");
            } catch (BurradasNOException e) {
                System.out.println(e.getMessage());
            }
        } while (!cadena.contentEquals("."));

        System.out.println("Fin del programa");
    }

    /**
     * Lee las palabras de entrada del usuario y comprueba que no es ninguna de las palabras prohibidas definidas en el array
     * 
     * @param sc Scanner utilizado para leer la entrada del usuario
     * @return La línea ingresada por el usuario si no contiene palabras prohibidas
     * @throws BurradasNOException lo devuelve si la las palabras escritas por el usuario contiene alguna palabra prohibida
     */
    public static String leerLineaOK(Scanner sc) throws BurradasNOException {
        String cadenaLeida = sc.nextLine();
        for (int i = 0; i < tpalabros.length; i++) {
            if (cadenaLeida.contains(tpalabros[i])) {
                throw new BurradasNOException();
            }
        }
        return cadenaLeida;
    }
}
