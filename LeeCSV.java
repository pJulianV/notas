import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeCSV {
    public static void main(String[] args) {
        int pivot = 0;
        String rutaArchivo = "datos.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");

                if (columnas.length > 0) {
                    try {

                        int score = Integer.parseInt(columnas[0].trim());
                        if (score >= 90) {
                            pivot++;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping line due to invalid score format: " + linea);
                    }
                }
                for (String celda : columnas) {
                    System.out.print(celda + "\t");
                }

            }
            System.out.println("El numero de estudiantes con 90 o mas es: " + pivot);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
