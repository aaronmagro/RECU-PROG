package gestion;

import local.inventario.Stock;
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

    public void agregarProducto() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione un producto de la lista: ");
        ArrayList<Producto> productos = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + ". " + productos.get(i).getNombre());
        }
        int seleccion = scanner.nextInt();
        Producto productoSeleccionado = productos.get(seleccion - 1);

        System.out.println("Ingrese la cantidad de productos a agregar: ");
        int cantidad = scanner.nextInt();
        Stock stock = new Stock(productoSeleccionado, cantidad);
        stocks.add(stock);
    }

}
