package local.inventario;

import gestion.GestorFicheros;
import productos.Producto;

import java.util.ArrayList;
import java.util.Random;

public class Stock {

    private Producto producto;
    private int cantidad;

    public Stock(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}