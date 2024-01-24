package productos;

public class Pescado extends Producto {
    private String subgrupo;

    public Pescado(String nombre, String nombreCientifico, double kcalorias, double precio, String subgrupo) {
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
        return "Pescado{" +
                "nombre='" + getNombre() + '\'' +
                ", nombreCientifico='" + getNombreCientifico() + '\'' +
                ", kcalorias=" + getKcalorias() +
                ", precio=" + getPrecio() +
                ", subgrupo='" + subgrupo + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Pescado pescado = new Pescado("Salmón", "Salmo salar", 208, 3.5, "Fishes");
        System.out.println(pescado);
    }

}
