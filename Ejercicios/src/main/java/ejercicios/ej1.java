package ejercicios;

public class ej1<T> {
        private T primero;
        private T segundo;

        public ej1(T primero, T segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }

        public T obtenerPrimero() {
            return primero;
        }

        public T obtenerSegundo() {
            return segundo;
        }

        public void establecerPrimero(T nuevoPrimero) {
            this.primero = nuevoPrimero;
        }

        public void establecerSegundo(T nuevoSegundo) {
            this.segundo = nuevoSegundo;
        }

        public void imprimirPareja() {
            System.out.println("Primero: " + primero.toString() + ", Segundo: " + segundo.toString());
        }
    }
