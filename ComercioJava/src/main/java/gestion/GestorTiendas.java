package gestion;

import local.inventario.Stock;
import local.manejo.Tienda;
import productos.Producto;

import java.util.ArrayList;

public class GestorTiendas {

    // Colores
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_ITALIC = "\u001B[3m";

    // Atributos
    private ArrayList<Tienda> tiendas;
    private GestorProductos gestorProductos;

    // Constructor
    public GestorTiendas(GestorProductos gestorProductos) {
        this.tiendas = new ArrayList<>();
        this.gestorProductos = gestorProductos;
    }

    // Getters y Setters
    public ArrayList<Tienda> getTiendas() {
        return tiendas;
    }

    // Métodos

    /**
     * Añade una tienda al gestor.
     * @param tienda Tienda a añadir.
     */
    public void addTienda(Tienda tienda) {
        tiendas.add(tienda);
    }


    /**
     * Muestra el nombre de todas las tiendas.
     */
    public void mostrarNombreTiendas() {
        for (int i = 0; i < tiendas.size(); i++) {

            System.out.println(ANSI_YELLOW+ANSI_BOLD+" ✧ "+ANSI_RESET+tiendas.get(i).getNombre()+ANSI_RESET);
        }
    }

    /**
     * Busca una tienda por su nombre.
     * @param nombre Nombre de la tienda a buscar.
     * @return Tienda buscada, o null si no se encuentra.
     */
    public Tienda buscarTienda(String nombre) {
        for (Tienda tienda : tiendas) {
            if (tienda.getNombre().equals(nombre)) {
                return tienda;
            }
        }
        return null;
    }

    /**
     * Busca un producto en todas las tiendas.
     * @param nombre Nombre del producto a buscar.
     * @return Producto buscado, o null si no se encuentra.
     */
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

}
