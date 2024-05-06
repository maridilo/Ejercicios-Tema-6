package ejercicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ej3 {
    public static String ejecutarEjercicio3() {
        // Crear una lista de 100 parejas de enteros
        List<ej1<Integer>> listaParejas = new ArrayList<>();
        Random random = new Random();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < 100; i++) {
            // Generar valores aleatorios para las parejas
            int primerEntero = random.nextInt(100); // Número aleatorio entre 0 y 99
            int segundoEntero = random.nextInt(100); // Número aleatorio entre 0 y 99

            // Crear la pareja y agregarla a la lista
            ej1<Integer> pareja = new ej1<>(primerEntero, segundoEntero);
            listaParejas.add(pareja);
        }

        // Mostrar las parejas por pantalla
        for (ej1<Integer> pareja : listaParejas) {
            resultado.append("Primero: ").append(pareja.obtenerPrimero()).append(", Segundo: ").append(pareja.obtenerSegundo()).append("\n");
        }

        return resultado.toString();
    }
}







