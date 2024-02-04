package productos;

import java.time.LocalDate;

public class Verdura extends Producto {

    // Atributos
    private LocalDate fechaRecoleccion;
    private int caducidad;
    private LocalDate fechaExpiracion;

    // Constructor
    public Verdura(String nombre, String nombreCientifico, double kcalorias, double precio, LocalDate fechaRecoleccion, int caducidad) {
        super(nombre, nombreCientifico, kcalorias, precio);
        this.fechaRecoleccion = fechaRecoleccion;
        setCaducidad(caducidad);
    }

    // Getters y Setters
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

    /**
     * Calcula la fecha de expiración a partir de la fecha de recolección y la caducidad.
     */
    private void calcularFechaExpiracion() {
        fechaExpiracion = fechaRecoleccion.plusDays(caducidad);
    }

    /**
     * Comprueba si la verdura está caducada.
     * @return true si la verdura está caducada, false en caso contrario.
     */
    public boolean estaCaducada() {
        return LocalDate.now().isAfter(fechaExpiracion);
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

}
