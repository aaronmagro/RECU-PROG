package local.manejo;

import productos.Producto;

import java.util.ArrayList;

public class Cliente {

    // Atributos
    private String nombre;
    private Producto productoFavorito;
    private ArrayList<Producto> listaCompra;

    // Constructor
    public Cliente(String nombre, Producto productoFavorito, ArrayList<Producto> listaCompra) {
        this.nombre = nombre;
        this.productoFavorito = productoFavorito;
        this.listaCompra = listaCompra;
    }

    // Getters y Setters
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

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", productoFavorito=" + productoFavorito +
                ", listaCompra=" + listaCompra +
                '}';
    }

}

