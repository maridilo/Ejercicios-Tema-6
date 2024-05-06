package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

    public class ej2 {
        public static void ejecutarEjemplo2() {
            // Crear una lista de datos reales
            List<Double> lista = new ArrayList<>();
            Random random = new Random();

            // Introducir 100 valores aleatorios en la lista
            for (int i = 0; i < 100; i++) {
                lista.add(random.nextDouble());
            }

            // Mostrar los valores por pantalla
            for (Double valor : lista) {
                System.out.println(valor);
            }
        }
    }