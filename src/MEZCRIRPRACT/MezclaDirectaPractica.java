package MEZCRIRPRACT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class MezclaDirectaPractica {
    /**
     * Este metodo agarra dos archivos auxiliares (F1 y F2) que ya traen bloques
     * ordenados de tamano L, los va comparando frente a frente y los guarda
     * ya mezclados y ordenados en un archivo de salida.
     */
    public static void intercalarBloques(String archivoF1, String archivoF2, String archivoSalida, int L) {

        try (
                BufferedReader lector1 = new BufferedReader(new FileReader(archivoF1));
                BufferedReader lector2 = new BufferedReader(new FileReader(archivoF2));
                PrintWriter escritor = new PrintWriter(new FileWriter(archivoSalida))
        ) {
            String linea1 = lector1.readLine();
            String linea2 = lector2.readLine();

            int elementosEscritos1 = 0;
            int elementosEscritos2 = 0;

            while (linea1 != null && linea2 != null) {
                // NUEVO: Si f2 se terminó primero, vaciamos lo que quede en el bloque de f1
                while (linea1 != null && elementosEscritos1 < L) {
                    escritor.println(linea1);
                    linea1 = lector1.readLine();
                    elementosEscritos1++;
                }

                // NUEVO: Si f1 se terminó primero, vaciamos lo que quede en el bloque de f2
                while (linea2 != null && elementosEscritos2 < L) {
                    escritor.println(linea2);
                    linea2 = lector2.readLine();
                    elementosEscritos2++;
                }

                // CASO 1: Todavia quedan elementos por comparar en AMBOS bloques de tamano L
                if (elementosEscritos1 < L && elementosEscritos2 < L) {

                    int val1 = Integer.parseInt(linea1);
                    int val2 = Integer.parseInt(linea2);

                    // TODO 1: Condicion para saber si el numero de F1 es menor o igual al de F2
                    if (val1 <= val2) {
                        escritor.println(val1);
                        linea1 = lector1.readLine();
                        elementosEscritos1++;
                    } else {
                        // TODO 2: Si el menor fue el de F2, escribimos val2, leemos linea2 y sumamos 1
                        escritor.println(val2);
                        linea2 = lector2.readLine();
                        elementosEscritos2++;
                    }
                }
                // CASO 2: El bloque de F2 ya se acabo (llego a L), asi que vaciamos lo que sobro de F1
                else if (elementosEscritos1 < L) {
                    escritor.println(linea1);
                    linea1 = lector1.readLine();
                    elementosEscritos1++;
                }
                // CASO 3: El bloque de F1 ya se acabo primero, asi que vaciamos lo que sobro de F2
                else {
                    // TODO 3: Las 3 lineas para vaciar el elemento restante de F2
                    escritor.println(linea2);
                    linea2 = lector2.readLine();
                    elementosEscritos2++;
                }
            }

            System.out.println("Bloque intercalado con exito!");

        } catch (IOException e) {
            System.out.println("Error en E/S de archivos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        intercalarBloques("f1.txt", "f2.txt", "f3.txt", 3);
        System.out.println(System.getProperty("user.dir"));
    }
}
