package ejercicios;

public class Persona implements Comparable<Persona>{

    private String nombre;
    private String apellido;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public int compareTo(Persona other) {
        return this.apellido.compareTo(other.apellido);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Persona)) {
            return false;
        }

        Persona persona = (Persona) obj;
        return persona.nombre.equals(nombre) && persona.apellido.equals(apellido);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode() + apellido.hashCode();
    }
}
