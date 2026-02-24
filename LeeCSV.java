import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeCSV {
    public static void main(String[] args) {
        int contador90 = 0;
        int sumaEdad = 0;
        int total = 0;
        String rutaArchivo = "datos.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // ignorar cabecera
            if ((linea = br.readLine()) != null) {
                // cabecera
            }
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 3) {
                    try {
                        int edad = Integer.parseInt(columnas[1].trim());
                        int nota = Integer.parseInt(columnas[2].trim());
                        total++;
                        sumaEdad += edad;
                        if (nota >= 90) {
                            contador90++;
                        }
                    } catch (NumberFormatException e) {
                        // ignorar
                    }
                }
            }

            System.out.println("Estudiantes con nota >= 90: " + contador90);
            if (total > 0) {
                double promedioEdad = (double) sumaEdad / total;
                System.out.println("Promedio de edad: " + promedioEdad);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
