package local.manejo;

import gestion.GestorClientes;
import gestion.GestorFicheros;
import gestion.GestorProductos;
import productos.Producto;

import java.util.ArrayList;

public class Tienda {
    private String nombre;
    private String direccion;
    private GestorProductos gestorProductos;

    // Constructor
    public Tienda(String nombre, String direccion, GestorProductos gestorProductos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.gestorProductos = gestorProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public GestorProductos getGestorProductos() {
        return gestorProductos;
    }

    public void setGestorProductos(GestorProductos gestorProductos) {
        this.gestorProductos = gestorProductos;
    }

    @Override
    public String toString() {
        return "Tienda{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", gestorProductos=" + gestorProductos +
                '}';
    }

}
