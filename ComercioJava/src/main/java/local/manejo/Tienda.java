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
    private GestorClientes gestorClientes;
    private static GestorFicheros gestorFicheros;

    public Tienda(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.gestorProductos = new GestorProductos();
        this.gestorClientes = new GestorClientes(this);
    }

    public GestorClientes getGestorClientes() {
        return gestorClientes;
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
                '}';
    }

}
