




    public class ej1<T> {
        private T primero;
        private T segundo;

        // Constructor
        public ej1(T primero, T segundo) {
            this.primero = primero;
            this.segundo = segundo;
        }

        // Métodos para acceder a cada uno de los datos
        public T obtenerPrimero() {
            return primero;
        }

        public T obtenerSegundo() {
            return segundo;
        }

        // Métodos para establecer nuevos valores a los datos
        public void establecerPrimero(T nuevoPrimero) {
            this.primero = nuevoPrimero;
        }

        public void establecerSegundo(T nuevoSegundo) {
            this.segundo = nuevoSegundo;
        }

        // Método para imprimir los datos de la pareja
        public void imprimirPareja() {
            System.out.println("Primero: " + primero.toString() + ", Segundo: " + segundo.toString());
        }
}
