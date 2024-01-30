package gestion;

import local.inventario.Stock;
import productos.Producto;

import java.util.ArrayList;

public class GestorProductos {

    private ArrayList<Stock> stocks;

    public GestorProductos() {
        this.stocks = new ArrayList<>();
    }

    public GestorProductos (ArrayList<Stock> stocks) {
        this.stocks = stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void delStock(Stock stock) {
        stocks.remove(stock);
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public Producto buscarProducto(String nombre) {
        for (Stock stock : stocks) {
            if (stock.getProducto().getNombre().equals(nombre)) {
                return stock.getProducto();
            }
        }
        return null;
    }

    public void mostrarProductos() {
        int i = 1;
        for (Stock stock : stocks) {
            System.out.println(i + ". " + stock.getProducto().getNombre());
            i++;
        }
    }

}
