package ejercicios;

import java.time.LocalDate;

public class Venta implements Comparable<Venta> {
    private String nombreProducto;
    private String nombreCliente;
    private double precioTransaccion;
    private LocalDate fechaTransaccion;

    public Venta(String nombreProducto, String nombreCliente, double precioTransaccion, LocalDate fechaTransaccion) {
        this.nombreProducto = nombreProducto;
        this.nombreCliente = nombreCliente;
        this.precioTransaccion = precioTransaccion;
        this.fechaTransaccion = fechaTransaccion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public double getPrecioTransaccion() {
        return precioTransaccion;
    }

    public LocalDate getFechaTransaccion() {
        return fechaTransaccion;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setPrecioTransaccion(double precioTransaccion) {
        this.precioTransaccion = precioTransaccion;
    }

    public void setFechaTransaccion(LocalDate fechaTransaccion) {
        this.fechaTransaccion = fechaTransaccion;
    }

    @Override
    public int compareTo(Venta other) {
        int compareByDate = this.fechaTransaccion.compareTo(other.fechaTransaccion);
        if (compareByDate != 0) {
            return compareByDate;
        }

        int compareByName = this.nombreCliente.compareTo(other.nombreCliente);
        if (compareByName != 0) {
            return compareByName;
        }

        return Double.compare(this.precioTransaccion, other.precioTransaccion);
    }

    @Override
    public String toString() {
        return "Producto: " + nombreProducto + ", Cliente: " + nombreCliente + ", Precio: " + precioTransaccion + ", Fecha: " + fechaTransaccion;
    }
}

