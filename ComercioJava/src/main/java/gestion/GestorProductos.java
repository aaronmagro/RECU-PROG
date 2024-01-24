package gestion;

import local.inventario.Stock;
import local.manejo.Tienda;
import productos.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorProductos {
    private ArrayList<Stock> stocks;

    public GestorProductos() {
        this.stocks = new ArrayList<>();
    }

    public GestorProductos (ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

}
