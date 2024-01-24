package productos;

public class Producto {
    private String nombre;
    private String nombreCientifico;
    private double kcalorias;
    private double precio;

    public Producto(String nombre, String nombreCientifico, double kcalorias, double precio) {
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.kcalorias = kcalorias;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public double getKcalorias() {
        return kcalorias;
    }

    public void setKcalorias(int kcalorias) {
        this.kcalorias = kcalorias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}


