package local.manejo;

import productos.Producto;

import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private Producto productoFavorito;
    private ArrayList<Producto> listaCompra;

    public Cliente(String nombre, Producto productoFavorito) {
        this.nombre = nombre;
        this.productoFavorito = productoFavorito;
        this.listaCompra = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto getProductoFavorito() {
        return productoFavorito;
    }

    public void setProductoFavorito(Producto productoFavorito) {
        this.productoFavorito = productoFavorito;
    }

    public ArrayList<Producto> getListaCompra() {
        return listaCompra;
    }

    public void agregarProductoListaCompra(Producto producto) {
        listaCompra.add(producto);
    }

    public void limpiarListaCompra() {
        listaCompra.clear();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", productoFavorito=" + productoFavorito +
                ", listaCompra=" + listaCompra +
                '}';
    }

}

