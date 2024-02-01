package gestion;

import local.inventario.Stock;
import local.manejo.Tienda;
import productos.Producto;

import java.util.ArrayList;

public class GestorTiendas {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_ITALIC = "\u001B[3m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    public static final String ANSI_BLINK = "\u001B[5m";
    public static final String ANSI_INVERSE = "\u001b[7m";

    private ArrayList<Tienda> tiendas;
    private GestorProductos gestorProductos;

    public GestorTiendas(GestorProductos gestorProductos) {
        this.tiendas = new ArrayList<>();
        this.gestorProductos = gestorProductos;
    }

    public void addTienda(Tienda tienda) {
        tiendas.add(tienda);
    }

    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }


    public void mostrarNombreTiendas() {
        for (int i = 0; i < tiendas.size(); i++) {

            System.out.println(ANSI_YELLOW+" ✧ "+ANSI_RESET+tiendas.get(i).getNombre()+ANSI_RESET);
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

    public void addStockATienda(String nombreTienda, Stock stock) {
        Tienda tienda = buscarTienda(nombreTienda);
        if (tienda != null) {
            gestorProductos.addStock(stock);
        }
    }

    public void mostrarProductosTienda(String nombreTienda) {
        Tienda tienda = buscarTienda(nombreTienda);
        if (tienda != null) {
            for (Stock stock : tienda.getGestorProductos().getStocks()) {
                System.out.println(stock.getProducto().getNombre());
            }
        }
    }

}
