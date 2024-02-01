package gestion;

import local.inventario.Stock;
import productos.Producto;

import java.util.ArrayList;

import static gestion.GestorTiendas.*;

public class GestorProductos {

    private ArrayList<Stock> stocks;

    public GestorProductos() {
        this.stocks = new ArrayList<>();
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

    public Stock buscarProductoSecuencial(String nombreProductoBusqueda) {
        for (Stock stock : stocks) {
            if (stock.getProducto().getNombre().equals(nombreProductoBusqueda)) {
                return stock;
            }
        }
        return null;
    }

    public Stock buscarProductoBinario(String nombreProductoBusqueda) {
        // Ordenar la lista de stocks alfabéticamente por el nombre del producto
        stocks.sort((stock1, stock2) -> stock1.getProducto().getNombre().compareTo(stock2.getProducto().getNombre()));

        int low = 0;
        int high = stocks.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Stock midStock = stocks.get(mid);
            int comparison = midStock.getProducto().getNombre().compareTo(nombreProductoBusqueda);

            if (comparison < 0) {
                low = mid + 1;
            } else if (comparison > 0) {
                high = mid - 1;
            } else {
                return midStock; // nombre encontrado
            }
        }
        return null; // nombre no encontrado
    }

    // ordenar con el algoritmo de la burbuja
    public void ordenarBurbuja() {
        long inicio = System.nanoTime();
        for (int i = 0; i < stocks.size() - 1; i++) {
            for (int j = 0; j < stocks.size() - i - 1; j++) {
                if (stocks.get(j).getCantidad() > stocks.get(j + 1).getCantidad()) {
                    Stock temp = stocks.get(j);
                    stocks.set(j, stocks.get(j + 1));
                    stocks.set(j + 1, temp);
                }
            }
        }
        long fin = System.nanoTime();
        // mostrar todos los stocks ordenados segun burbuja
        for (Stock stock : stocks) {
            System.out.println(ANSI_GREEN+stock.getProducto().getNombre() +ANSI_RESET+ " ▸ " +ANSI_ITALIC+ stock.getCantidad()+ANSI_RESET);
        }

        System.out.println(ANSI_BLUE+"Tiempo de ejecución del algoritmo de burbuja: "+ANSI_RESET +ANSI_ITALIC+ANSI_CYAN+ (fin - inicio)+ANSI_RESET + ANSI_BLUE+" nanosegundos."+ANSI_RESET);
    }

    // ordenar con otro algoritmo a elegir (comparación)
    public void ordenarComparacion() {
        long inicio = System.nanoTime();
        stocks.sort((stock1, stock2) -> stock1.getCantidad() - stock2.getCantidad());
        long fin = System.nanoTime();
        // mostrar todos los stocks ordenados
        for (Stock stock : stocks) {
            System.out.println(ANSI_GREEN + stock.getProducto().getNombre() + ANSI_RESET + " ▸ " + ANSI_ITALIC + stock.getCantidad() + ANSI_RESET);
        }
        System.out.println(ANSI_BLUE+"Tiempo de ejecución del algoritmo de comparación: "+ANSI_RESET +ANSI_ITALIC+ANSI_CYAN+ (fin - inicio)+ANSI_RESET + ANSI_BLUE+" nanosegundos."+ANSI_RESET);
    }


}