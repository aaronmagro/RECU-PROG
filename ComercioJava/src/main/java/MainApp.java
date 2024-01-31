import gestion.GestorClientes;
import gestion.GestorFicheros;
import gestion.GestorProductos;
import gestion.GestorTiendas;
import local.inventario.Stock;
import local.manejo.Cliente;
import local.manejo.Tienda;
import productos.Producto;
import productos.Verdura;
import productos.Carne;
import productos.Pescado;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

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

    public static void main(String[] args) {
        // Crear instancias de gestores y tiendas
        ArrayList<Producto> productos = new ArrayList<>();

        GestorProductos gestorProductos = new GestorProductos();
        GestorTiendas gestorTiendas = new GestorTiendas(gestorProductos);
        GestorClientes gestorClientes = new GestorClientes();

        // Cargar datos desde el archivo CSV
        GestorFicheros.leerDatosDesdeCSV("datosAplicacion.csv", productos, gestorTiendas, gestorClientes);

        // Menú principal
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n");
            System.out.println(ANSI_PURPLE+"░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░█████╗░░█████╗░███╗░░░███╗███████╗██████╗░░█████╗░██╗░█████╗░░░░░░░░░░░░░██╗░█████╗░██╗░░░██╗░█████╗░░");
            System.out.println("░██╔══██╗██╔══██╗████╗░████║██╔════╝██╔══██╗██╔══██╗██║██╔══██╗░░░░░░░░░░░░██║██╔══██╗██║░░░██║██╔══██╗░");
            System.out.println("░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░██████╔╝██║░░╚═╝██║██║░░██║░░░░░░░░░░░░██║███████║╚██╗░██╔╝███████║░");
            System.out.println("░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░██╔══██╗██║░░██╗██║██║░░██║░░░░░░░██╗░░██║██╔══██║░╚████╔╝░██╔══██║░");
            System.out.println("░╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗██║░░██║╚█████╔╝██║╚█████╔╝░░░░░░░╚█████╔╝██║░░██║░░╚██╔╝░░██║░░██║░");
            System.out.println("░░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚═╝░╚════╝░╚═╝░╚════╝░░░░░░░░░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╔═════════════════════════════════════════════════════════╗"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║                      "+ANSI_BOLD+"MENÚ PRINCIPAL"+ANSI_RESET+ANSI_CYAN+"                     ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╠═════════════════════════════════════════════════════════╣"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"1."+ANSI_RESET+" Añadir stock de un producto a una tienda.           "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"2."+ANSI_RESET+" Eliminar stock de un producto de una tienda.        "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"3."+ANSI_RESET+" Buscar un producto en una tienda (mostrará el stock)."+ANSI_CYAN+"║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"4."+ANSI_RESET+" Mostrar el producto con mayor stock de una tienda.  "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"5."+ANSI_RESET+" Mostrar la tienda con mayor valor. (Q x €)          "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"6."+ANSI_RESET+" Mostrar información de productos ordenada por stock."+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"7."+ANSI_RESET+" Ejecutar simulación de venta.                       "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"8."+ANSI_RESET+" Salir.                                              "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╠═════════════════════════════════════════════════════════╣"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ Seleccione una opción:                                  ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╚═════════════════════════════════════════════════════════╝"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el número
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╔═════════════════════════════════════════════════════════╗"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_YELLOW+ANSI_BOLD+"Opción seleccionada: "+ANSI_RESET+ANSI_ITALIC+ANSI_YELLOW+opcion+ANSI_CYAN+"                                  ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╚═════════════════════════════════════════════════════════╝"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_RESET);


            switch (opcion) {
                case 1:
                    // Implementar lógica para añadir un stock de un producto a una tienda
                    System.out.println("Seleccione una tienda para añadir un producto: ");
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print("Escriba el nombre de la tienda: ");
                    String nombreTienda = scanner.nextLine();
                    Tienda tienda = gestorTiendas.buscarTienda(nombreTienda);
                    // mostrar los productos de la tienda con su stock
                    if (tienda != null) {
                        tienda.getGestorProductos().getStocks().sort((stock1, stock2) -> stock1.getCantidad() - stock2.getCantidad());
                        for (Stock stock : tienda.getGestorProductos().getStocks()) {
                            System.out.println(stock.getProducto().getNombre() + " - " + stock.getCantidad());
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    if (tienda != null) {
                        System.out.print("Escriba el nombre del producto al que quiere añadir stock: ");
                        String nombreProducto = scanner.nextLine();
                        Producto producto = gestorTiendas.buscarProductoEnTienda(nombreProducto);
                        if (producto != null) {
                            System.out.print("Escriba la cantidad del producto que quiere añadir: ");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea después de leer el número

                            Stock stockExistente = tienda.getGestorProductos().buscarProductoSecuencial(nombreProducto);
                            stockExistente.setCantidad(stockExistente.getCantidad() + cantidad);

                        } else {
                            System.out.println("No se ha encontrado el producto.");
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }
                    break;

                case 2:
                    // Implementar lógica para eliminar stock de un producto de una tienda
                    System.out.println("Seleccione una tienda para añadir un producto: ");
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print("Escriba el nombre de la tienda: ");
                    String nombreTiendaEliminar = scanner.nextLine();
                    Tienda tiendaEliminar = gestorTiendas.buscarTienda(nombreTiendaEliminar);
                    // mostrar los productos de la tienda con su stock
                    if (tiendaEliminar != null) {
                        tiendaEliminar.getGestorProductos().getStocks().sort((stock1, stock2) -> stock1.getCantidad() - stock2.getCantidad());
                        for (Stock stock2 : tiendaEliminar.getGestorProductos().getStocks()) {
                            System.out.println(stock2.getProducto().getNombre() + " - " + stock2.getCantidad());
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }
                    if (tiendaEliminar != null) {
                        System.out.print("Escriba el nombre del producto al que quiere eliminar stock: ");
                        String nombreProductoEliminar = scanner.nextLine();
                        Producto productoEliminar = gestorTiendas.buscarProductoEnTienda(nombreProductoEliminar);
                        if (productoEliminar != null) {
                            System.out.print("Escriba la cantidad del producto que quiere eliminar: ");
                            int cantidadEliminar = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea después de leer el número

                            Stock stockExistente = tiendaEliminar.getGestorProductos().buscarProductoSecuencial(nombreProductoEliminar);
                            stockExistente.setCantidad(stockExistente.getCantidad() - cantidadEliminar);
                            // controlar si el stock queda en negativo ponerlo en 0
                            if (stockExistente.getCantidad() < 0) {
                                stockExistente.setCantidad(0);
                            }
                        } else {
                            System.out.println("No se ha encontrado el producto.");
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }
                    break;

                case 3:
                    // Implementar lógica para buscar un producto en una tienda (mostrará el stock disponible)
                    System.out.println("Seleccione una tienda para buscar un producto: ");
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print("Escriba el nombre de la tienda: ");
                    String nombreTiendaBusqueda = scanner.nextLine();
                    System.out.print("Escriba el nombre del producto: ");
                    String nombreProductoBusqueda = scanner.nextLine();

                    // Buscar la tienda
                    Tienda tiendaBusqueda = gestorTiendas.buscarTienda(nombreTiendaBusqueda);
                    if (tiendaBusqueda != null) {
                        // Realizar la búsqueda secuencial
                        long inicioSecuencial = System.nanoTime();
                        Stock stockSecuencial = tiendaBusqueda.getGestorProductos().buscarProductoSecuencial(nombreProductoBusqueda);
                        long finSecuencial = System.nanoTime();

                        // Realizar la búsqueda binaria
                        long inicioBinaria = System.nanoTime();
                        Stock stockBinaria = tiendaBusqueda.getGestorProductos().buscarProductoBinario(nombreProductoBusqueda);
                        long finBinaria = System.nanoTime();

                        // Mostrar los resultados
                        if (stockSecuencial != null) {
                            System.out.println("Búsqueda secuencial: El producto " + nombreProductoBusqueda + " tiene un stock de " + stockSecuencial.getCantidad() + ". Tiempo de búsqueda: " + (finSecuencial - inicioSecuencial) + " nanosegundos.");
                        } else {
                            System.out.println("Búsqueda secuencial: El producto " + nombreProductoBusqueda + " no se encontró. Tiempo de búsqueda: " + (finSecuencial - inicioSecuencial) + " nanosegundos.");
                        }

                        if (stockBinaria != null) {
                            System.out.println("Búsqueda binaria: El producto " + nombreProductoBusqueda + " tiene un stock de " + stockBinaria.getCantidad() + ". Tiempo de búsqueda: " + (finBinaria - inicioBinaria) + " nanosegundos.");
                        } else {
                            System.out.println("Búsqueda binaria: El producto " + nombreProductoBusqueda + " no se encontró. Tiempo de búsqueda: " + (finBinaria - inicioBinaria) + " nanosegundos.");
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }
                    break;

                case 4:
                    // Implementar lógica para mostrar el producto con mayor stock de una tienda
                    System.out.println("Seleccione una tienda para ver su producto con mayor stock: ");
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print("Escriba el nombre de la tienda: ");
                    String nombreTienda1 = scanner.nextLine();
                    Tienda tienda1 = gestorTiendas.buscarTienda(nombreTienda1);
                    if (tienda1 != null) {
                        tienda1.getGestorProductos().getStocks().sort((stock1, stock2) -> stock1.getCantidad() - stock2.getCantidad());
                        System.out.println("El producto con mayor stock es: " + tienda1.getGestorProductos().getStocks().get(tienda1.getGestorProductos().getStocks().size() - 1).getProducto().getNombre() + " con " + tienda1.getGestorProductos().getStocks().get(tienda1.getGestorProductos().getStocks().size() - 1).getCantidad() + " unidades.");
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    break;

                case 5:
                    // Implementar lógica para mostrar la tienda con mayor valor
                    double mayorValor = 0;
                    Tienda tiendaMayorValor = null;
                    for (Tienda tienda2 : gestorTiendas.getTiendas()) {
                        double valorTienda = 0;
                        for (Stock stock2 : tienda2.getGestorProductos().getStocks()) {
                            valorTienda += stock2.getProducto().getPrecio() * stock2.getCantidad();
                        }
                        if (valorTienda > mayorValor) {
                            mayorValor = valorTienda;
                            tiendaMayorValor = tienda2;
                        }
                        System.out.println(tienda2.getNombre() + " - " + valorTienda + " €");
                    }
                    assert tiendaMayorValor != null;

                    System.out.println("\nLa tienda con mayor valor es: " + tiendaMayorValor.getNombre() + " con " + mayorValor + " €.");

                    break;

                case 6:
                    // Mostrar toda la información de los productos de una tienda ordenada por stock. Para
                    //ello se deberá implementar el algoritmo de la burbuja y otro algoritmo a elegir. Se
                    //deberá mostrar el tiempo que tarda la aplicación en devolver la información.
                    System.out.println("Seleccione una tienda para ver sus productos ordenados por stock: ");
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print("Escriba el nombre de la tienda: ");
                    String nombreTienda3 = scanner.nextLine();
                    Tienda tienda3 = gestorTiendas.buscarTienda(nombreTienda3);
                    if (tienda3 != null) {
                        tienda3.getGestorProductos().ordenarBurbuja();
                        tienda3.getGestorProductos().ordenarOtro();
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    break;

                case 7:
                    // Implementar lógica para ejecutar la simulación de venta


                    break;
                case 8:
                    // Implementar lógica para salir de la aplicación
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

    }






}
