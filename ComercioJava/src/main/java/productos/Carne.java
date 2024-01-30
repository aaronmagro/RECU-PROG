package productos;

public class Carne extends Producto {
    private String subgrupo;

    public Carne(String nombre, String nombreCientifico, double kcalorias, double precio, String subgrupo) {
        super(nombre, nombreCientifico, kcalorias, precio);
        this.subgrupo = subgrupo;
    }

    public String getSubgrupo() {
        return subgrupo;
    }

    public void setSubgrupo(String subgrupo) {
        this.subgrupo = subgrupo;
    }

    @Override
    public String toString() {
        return "Carne{" +
                "nombre='" + getNombre() + '\'' +
                ", nombreCientifico='" + getNombreCientifico() + '\'' +
                ", kcalorias=" + getKcalorias() +
                ", precio=" + getPrecio() +
                ", subgrupo='" + subgrupo + '\'' +
                '}';
    }

}
