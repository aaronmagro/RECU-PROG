package gestion;

import local.inventario.Stock;
import local.manejo.Tienda;
import productos.Producto;

import java.util.ArrayList;

public class GestorTiendas {

    private ArrayList<Tienda> tiendas;
    private GestorProductos gestorProductos;
    private GestorFicheros gestorFicheros;

    public GestorTiendas() {
        this.tiendas = gestorFicheros.tiendas;
        this.gestorProductos = new GestorProductos();
    }

    public void addTienda(Tienda tienda) {
        tiendas.add(tienda);
    }

    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    public void mostrarTiendas() {
        for (Tienda tienda : tiendas) {
            System.out.println(tienda);
        }
    }

    public Tienda buscarTienda(String nombre) {
        for (Tienda tienda : tiendas) {
            if (tienda.getNombre().equals(nombre)) {
                return tienda;
            }
        }
        return null;
    }

    public Producto buscarProductoEnTienda(String nombre) {
        for (Tienda tienda : tiendas) {
            for (Stock stock : tienda.getGestorProductos().getStocks()) {
                if (stock.getProducto().getNombre().equals(nombre)) {
                    return stock.getProducto();
                }
            }
        }
        return null;
    }

    public Stock addStockATienda(String nombreTienda, Stock stock) {
        Tienda tienda = buscarTienda(nombreTienda);
        if (tienda != null) {
            tienda.getGestorProductos().addStock(stock);
            return stock;
        }
        return null;
    }

}
