package gestion;

import local.inventario.Stock;
import local.manejo.Tienda;
import productos.Producto;

import java.util.ArrayList;
import java.util.Random;

public class GestorProductos {

    private ArrayList<Stock> stocks;
    private ArrayList<Producto> productos;

    public GestorProductos() {
        this.productos = new ArrayList<>();
        this.stocks = new ArrayList<>();
    }

    public void addProducto(Producto producto) {
        productos.add(producto);
    }

    public void delProducto(Producto producto) {
        productos.remove(producto);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
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

    public void mostrarProductosTienda(String nombreTienda) {
        for (Stock stock : stocks) {
            if (stock.getProducto().getNombre().equals(nombreTienda)) {
                System.out.println(stock.getProducto().getNombre());
            }
        }
    }


}
