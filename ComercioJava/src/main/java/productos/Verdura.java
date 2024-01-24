package productos;

import java.time.LocalDate;

public class Verdura extends Producto {
    private LocalDate fechaRecoleccion;
    private int caducidad;
    private LocalDate fechaExpiracion;

    public Verdura(String nombre, String nombreCientifico, double kcalorias, double precio, LocalDate fechaRecoleccion, int caducidad) {
        super(nombre, nombreCientifico, kcalorias, precio);
        this.fechaRecoleccion = fechaRecoleccion;
        setCaducidad(caducidad);
    }

    public LocalDate getFechaRecoleccion() {
        return fechaRecoleccion;
    }

    public void setFechaRecoleccion(LocalDate fechaRecoleccion) {
        this.fechaRecoleccion = fechaRecoleccion;
    }

    public int getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.caducidad = caducidad;
        calcularFechaExpiracion();
    }

    private void calcularFechaExpiracion() {
        fechaExpiracion = fechaRecoleccion.plusDays(caducidad);
    }

    @Override
    public String toString() {
        return "Verdura{" +
                "nombre='" + getNombre() + '\'' +
                ", nombreCientifico='" + getNombreCientifico() + '\'' +
                ", kcalorias=" + getKcalorias() +
                ", precio=" + getPrecio() +
                ", fechaRecoleccion=" + fechaRecoleccion +
                ", caducidad=" + caducidad +
                ", fechaExpiracion=" + fechaExpiracion +
                '}';
    }

    public static void main(String[] args) {
        Verdura verdura = new Verdura("Tomate", "Solanum lycopersicum", 18, 1.5, LocalDate.of(2024, 10, 15), 7);
        System.out.println(verdura);
    }

}
