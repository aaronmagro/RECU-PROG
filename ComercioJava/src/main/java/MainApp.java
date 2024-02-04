import gestion.GestorClientes;
import gestion.GestorFicheros;
import gestion.GestorProductos;
import gestion.GestorTiendas;
import local.inventario.Stock;
import local.manejo.Tienda;
import productos.Producto;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {

    // Atributos de colores
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_ORANGE = "\u001B[38;5;208m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_ITALIC = "\u001B[3m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    public static final String ANSI_LIGHTGREEN = "\u001b[92m";
    public static final String ANSI_LIGHTPINK = "\u001b[95m";
    public static final String ANSI_LIGHTYELLOW = "\u001b[93m";
    public static final String ANSI_PINK = "\u001b[38;5;206m";

    /**
     * Ejecuta la aplicación.
     */
    public static void main(String[] args) {
        // Crear instancias de gestores y tiendas
        ArrayList<Producto> productos = new ArrayList<>();
        GestorProductos gestorProductos = new GestorProductos();
        GestorTiendas gestorTiendas = new GestorTiendas(gestorProductos);
        GestorClientes gestorClientes = new GestorClientes();
        GestorFicheros gestorFicheros = new GestorFicheros();

        // Cargar datos desde el archivo CSV
        GestorFicheros.leerDatosDesdeCSV("datosAplicacion.csv", productos, gestorTiendas, gestorClientes);

        // Menú principal
        Scanner scanner = new Scanner(System.in);
        System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        while (true) {
            menuPrincipal();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el número
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╔═════════════════════════════════════════════════════════╗"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_YELLOW+ANSI_BOLD+"Opción seleccionada: "+ANSI_RESET+ANSI_ITALIC+ANSI_YELLOW+opcion+ANSI_CYAN+"                                  ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╚═════════════════════════════════════════════════════════╝"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
            System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_RESET);

            switch (opcion) {
                case 1:
                    // Implementar lógica para añadir un stock de un producto a una tienda
                    tituloTiendas();
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print("\nEscriba el nombre de la tienda: ");
                    String nombreTienda = scanner.nextLine();
                    Tienda tienda = gestorTiendas.buscarTienda(nombreTienda);
                    if (tienda != null) {
                        System.out.println(ANSI_BOLD+ANSI_LIGHTGREEN+ANSI_UNDERLINE+"\n\uD83C\uDF3D  "+tienda.getNombre().toUpperCase()+"  \uD83C\uDF57"+ANSI_RESET);
                        tienda.getGestorProductos().getStocks().sort((stock1, stock2) -> stock1.getCantidad() - stock2.getCantidad());
                        for (Stock stock : tienda.getGestorProductos().getStocks()) {
                            System.out.println(ANSI_BOLD+ANSI_GREEN+stock.getProducto().getNombre() +ANSI_RESET+ " ▸ " +ANSI_ITALIC+ stock.getCantidad()+ANSI_RESET);
                        }
                        System.out.print("\nEscriba el nombre del producto al que quiere añadir stock: ");
                        String nombreProducto = scanner.nextLine();
                        Producto producto = gestorTiendas.buscarProductoEnTienda(nombreProducto);
                        if (producto != null) {
                            System.out.print("\nEscriba la cantidad del producto que quiere añadir: ");
                            int cantidad = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea después de leer el número

                            Stock stockExistente = tienda.getGestorProductos().buscarProductoSecuencial(nombreProducto);
                            stockExistente.setCantidad(stockExistente.getCantidad() + cantidad);
                            System.out.println(ANSI_ORANGE+"\nSe ha añadido el stock del producto "+ANSI_GREEN+stockExistente.getProducto().getNombre()+ANSI_RESET+ANSI_ORANGE+", ahora tiene "+ANSI_RESET+ANSI_ITALIC+stockExistente.getCantidad()+ANSI_RESET+ANSI_ORANGE+" unidades restantes."+ANSI_RESET);
                        } else {
                            System.out.println("No se ha encontrado el producto.");
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    break;

                case 2:
                    // Implementar lógica para eliminar stock de un producto de una tienda
                    tituloTiendas();
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print(ANSI_RESET+"\nEscriba el nombre de la tienda: ");
                    String nombreTiendaEliminar = scanner.nextLine();
                    Tienda tiendaEliminar = gestorTiendas.buscarTienda(nombreTiendaEliminar);
                    // mostrar los productos de la tienda con su stock
                    if (tiendaEliminar != null) {
                        System.out.println(ANSI_BOLD+ANSI_LIGHTGREEN+ANSI_UNDERLINE+"\n\uD83C\uDF3D  "+tiendaEliminar.getNombre().toUpperCase()+"  \uD83C\uDF57"+ANSI_RESET);
                        tiendaEliminar.getGestorProductos().getStocks().sort((stock1, stock2) -> stock1.getCantidad() - stock2.getCantidad());
                        for (Stock stock2 : tiendaEliminar.getGestorProductos().getStocks()) {
                            System.out.println(ANSI_GREEN+stock2.getProducto().getNombre() +ANSI_RESET+ " ▸ " +ANSI_ITALIC+ stock2.getCantidad()+ANSI_RESET);
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }
                    if (tiendaEliminar != null) {
                        System.out.print("\nEscriba el nombre del producto al que quiere eliminar stock: ");
                        String nombreProductoEliminar = scanner.nextLine();
                        Producto productoEliminar = gestorTiendas.buscarProductoEnTienda(nombreProductoEliminar);
                        if (productoEliminar != null) {
                            System.out.print("\nEscriba la cantidad del producto que quiere eliminar: ");
                            int cantidadEliminar = scanner.nextInt();
                            scanner.nextLine(); // Consumir la nueva línea después de leer el número

                            Stock stockExistente = tiendaEliminar.getGestorProductos().buscarProductoSecuencial(nombreProductoEliminar);
                            stockExistente.setCantidad(stockExistente.getCantidad() - cantidadEliminar);
                            // controlar si el stock queda en negativo ponerlo en 0
                            if (stockExistente.getCantidad() < 0) {
                                stockExistente.setCantidad(0);
                            }
                            System.out.println(ANSI_ORANGE+"\nSe ha eliminado el stock del producto "+ANSI_GREEN+stockExistente.getProducto().getNombre()+ANSI_RESET+ANSI_ORANGE+", ahora tiene "+ANSI_RESET+ANSI_ITALIC+stockExistente.getCantidad()+ANSI_RESET+ANSI_ORANGE+" unidades restantes."+ANSI_RESET);
                        } else {
                            System.out.println("No se ha encontrado el producto.");
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    break;

                case 3:
                    // Implementar lógica para buscar un producto en una tienda (mostrará el stock disponible)
                    tituloTiendas();
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print(ANSI_RESET+"\nEscriba el nombre de la tienda para buscar el producto: ");
                    String nombreTiendaBusqueda = scanner.nextLine();
                    System.out.print("\nEscriba el nombre del producto: ");
                    String nombreProductoBusqueda = scanner.nextLine();

                    // Buscar la tienda
                    Tienda tiendaBusqueda = gestorTiendas.buscarTienda(nombreTiendaBusqueda);
                    if (tiendaBusqueda != null) {
                        System.out.println(ANSI_BOLD+ANSI_LIGHTGREEN+ANSI_UNDERLINE+"\n\uD83C\uDF3D  "+tiendaBusqueda.getNombre().toUpperCase()+"  \uD83C\uDF57"+ANSI_RESET);
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
                            System.out.println(ANSI_YELLOW+ANSI_BOLD+"Búsqueda secuencial:"+ANSI_RESET+ANSI_ORANGE+" El producto "+ANSI_GREEN + nombreProductoBusqueda + ANSI_ORANGE+" tiene un stock de "+ANSI_RESET + stockSecuencial.getCantidad() +ANSI_ORANGE+ ". "+ ANSI_BLUE+"Tiempo de búsqueda: " +ANSI_RESET+ ANSI_CYAN+ ANSI_ITALIC + (finSecuencial - inicioSecuencial) +ANSI_RESET+ ANSI_BLUE+" nanosegundos.");
                        } else {
                            System.out.println(ANSI_YELLOW+ANSI_BOLD+"Búsqueda secuencial:"+ANSI_RESET+ANSI_ORANGE+" El producto "+ANSI_GREEN + nombreProductoBusqueda + ANSI_ORANGE+" no se encontró. "+ANSI_BLUE+"Tiempo de búsqueda: "+ANSI_RESET + ANSI_CYAN+ ANSI_ITALIC+ (finSecuencial - inicioSecuencial) +ANSI_RESET+ ANSI_BLUE+" nanosegundos.");
                        }

                        if (stockBinaria != null) {
                            System.out.println(ANSI_YELLOW+ANSI_BOLD+"Búsqueda binaria:"+ANSI_RESET+ANSI_ORANGE+" El producto "+ANSI_GREEN + nombreProductoBusqueda + ANSI_ORANGE+" tiene un stock de "+ANSI_RESET + stockBinaria.getCantidad() +ANSI_ORANGE+ ". "+ ANSI_BLUE+"Tiempo de búsqueda: " +ANSI_RESET+ ANSI_CYAN+ ANSI_ITALIC + (finBinaria - inicioBinaria) +ANSI_RESET+ ANSI_BLUE+" nanosegundos.");
                        } else {
                            System.out.println(ANSI_YELLOW+ANSI_BOLD+"Búsqueda binaria:"+ANSI_RESET+ANSI_ORANGE+" El producto "+ANSI_GREEN + nombreProductoBusqueda + ANSI_ORANGE+" no se encontró. "+ ANSI_BLUE  +"Tiempo de búsqueda: "+ANSI_RESET+ ANSI_CYAN+ ANSI_ITALIC + (finBinaria - inicioBinaria) +ANSI_RESET+ ANSI_BLUE+" nanosegundos.");
                        }
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    break;

                case 4:
                    // Implementar lógica para mostrar el producto con mayor stock de una tienda
                    tituloTiendas();
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print(ANSI_RESET+"\nEscriba el nombre de la tienda para ver el producto de mayor stock de esta: ");
                    String nombreTienda1 = scanner.nextLine();
                    Tienda tienda1 = gestorTiendas.buscarTienda(nombreTienda1);
                    if (tienda1 != null) {
                        System.out.println(ANSI_BOLD+ANSI_LIGHTGREEN+ANSI_UNDERLINE+"\n\uD83C\uDF3D  "+tienda1.getNombre().toUpperCase()+"  \uD83C\uDF57"+ANSI_RESET);
                        tienda1.getGestorProductos().ordenarComparacion();
                        System.out.println(ANSI_ORANGE+"\nEl producto con mayor stock es "+ANSI_RESET+ANSI_GREEN+ANSI_BOLD + tienda1.getGestorProductos().getStocks().get(tienda1.getGestorProductos().getStocks().size() - 1).getProducto().getNombre() +ANSI_RESET+ANSI_ORANGE+" con " +ANSI_RESET+ tienda1.getGestorProductos().getStocks().get(tienda1.getGestorProductos().getStocks().size() - 1).getCantidad() + ANSI_ORANGE+" unidades.");
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    break;

                case 5:
                    // Implementar lógica para mostrar la tienda con mayor valor
                    double mayorValor = 0;
                    Tienda tiendaMayorValor = null;
                    System.out.println(ANSI_BOLD+ANSI_LIGHTPINK+ANSI_UNDERLINE+"\n\uD83D\uDED2  TIENDAS  \uD83D\uDED2"+ANSI_RESET);
                    for (Tienda tienda2 : gestorTiendas.getTiendas()) {
                        double valorTienda = 0;
                        for (Stock stock2 : tienda2.getGestorProductos().getStocks()) {
                            valorTienda += stock2.getProducto().getPrecio() * stock2.getCantidad();
                        }
                        if (valorTienda > mayorValor) {
                            mayorValor = valorTienda;
                            tiendaMayorValor = tienda2;
                        }
                        System.out.println(ANSI_BOLD+ANSI_LIGHTGREEN+tienda2.getNombre() +ANSI_RESET+ " ▸ " + ANSI_ITALIC+ANSI_LIGHTYELLOW+valorTienda + " €"+ANSI_RESET);
                    }
                    assert tiendaMayorValor != null;
                    System.out.println(ANSI_ORANGE+"\nLa tienda con mayor valor es: " +ANSI_BOLD+ANSI_LIGHTGREEN+ tiendaMayorValor.getNombre() +ANSI_RESET+ANSI_ORANGE+" con "+ANSI_LIGHTYELLOW+ANSI_ITALIC+ mayorValor +" €"+ANSI_RESET+ANSI_ORANGE+"."+ ANSI_RESET);

                    break;

                case 6:
                    // Implementar lógica para mostrar información de productos ordenada por stock (BurbleSort y Comparación)
                    tituloTiendas();
                    gestorTiendas.mostrarNombreTiendas();
                    System.out.print(ANSI_RESET+"\nEscriba el nombre de la tienda para verla ordenada por stock: ");
                    String nombreTienda3 = scanner.nextLine();
                    Tienda tienda3 = gestorTiendas.buscarTienda(nombreTienda3);

                    if (tienda3 != null) {
                        System.out.println(ANSI_BOLD+ANSI_LIGHTGREEN+ANSI_UNDERLINE+"\n\uD83C\uDF3D  "+tienda3.getNombre().toUpperCase()+"  \uD83C\uDF57"+ANSI_RESET);
                        System.out.println("\n\uD83D\uDDEE  ORDENACIÓN POR BURBUJA  \uD83D\uDDEF"+ANSI_RESET);
                        tienda3.getGestorProductos().ordenarBurbuja();
                        System.out.println("\n✖ ❙ ✔  ORDENACIÓN POR COMPARACIÓN  ✔ ❙ ✖"+ANSI_RESET);
                        tienda3.getGestorProductos().ordenarComparacion();
                    } else {
                        System.out.println("No se ha encontrado la tienda.");
                    }

                    break;

                case 7:
                    // Implementar lógica para ejecutar simulación de venta
                    gestorFicheros.exportarSimulacion(gestorTiendas, gestorClientes);
                    System.out.println(ANSI_PINK+"\uD83D\uDCE4 EXPORTANDO SIMULACIÓN... \uD83D\uDCE4"+ANSI_RESET);
                    System.out.println(ANSI_BOLD+ANSI_LIGHTPINK+"\uD83D\uDDF8 SIMULACIÓN EXPORTADA CON ÉXITO \uD83D\uDDF8"+ANSI_RESET);
                    break;
                case 8:
                    // Implementar lógica para salir de la aplicación
                    chao();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }


        }


    }

    /**
     * Muestra el menú de la aplicación en la consola.
     */
    public static void menuPrincipal() {
        System.out.println("\n");
        System.out.println(ANSI_PURPLE+"░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░█████╗░░█████╗░███╗░░░███╗███████╗██████╗░░█████╗░██╗░█████╗░░░░░░░░░░░░░░██╗░█████╗░██╗░░░██╗░█████╗░░░░░");
        System.out.println("░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝██╔══██╗██╔══██╗██║██╔══██╗░░░░░░░░░░░░░██║██╔══██╗██║░░░██║██╔══██╗░░░░");
        System.out.println("░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░██████╔╝██║░░╚═╝██║██║░░██║░░░░░░░░░░░░░██║███████║╚██╗░██╔╝███████║░░░░");
        System.out.println("░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░██╔══██╗██║░░██╗██║██║░░██║░░░░░░░░██╗░░██║██╔══██║░╚████╔╝░██╔══██║░░░░");
        System.out.println("░░░░╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗██║░░██║╚█████╔╝██║╚█████╔╝░░░░░░░░╚█████╔╝██║░░██║░░╚██╔╝░░██║░░██║░░░░");
        System.out.println("░░░░░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝╚═╝░░╚═╝░╚════╝░╚═╝░╚════╝░░░░░░░░░░╚════╝░╚═╝░░╚═╝░░░╚═╝░░░╚═╝░░╚═╝░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╔═════════════════════════════════════════════════════════╗"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║                      "+ANSI_BOLD+"MENÚ PRINCIPAL"+ANSI_RESET+ANSI_CYAN+"                     ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╠═════════════════════════════════════════════════════════╣"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"1."+ANSI_RESET+" Añadir stock de un producto a una tienda.           "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"2."+ANSI_RESET+" Eliminar stock de un producto de una tienda.        "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"3."+ANSI_RESET+" Buscar un producto en una tienda (mostrará el stock)."+ANSI_CYAN+"║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"4."+ANSI_RESET+" Mostrar el producto con mayor stock de una tienda.  "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"5."+ANSI_RESET+" Mostrar la tienda con mayor valor. (Q x €)          "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"6."+ANSI_RESET+" Mostrar información de productos ordenada por stock."+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"7."+ANSI_RESET+" Ejecutar simulación de venta.                       "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ "+ANSI_BOLD+"8."+ANSI_RESET+" Salir.                                              "+ANSI_CYAN+" ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╠═════════════════════════════════════════════════════════╣"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ║ Seleccione una opción:                                  ║"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░"+ANSI_CYAN+" ╚═════════════════════════════════════════════════════════╝"+ANSI_PURPLE+" ░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
    }

    /**
     * Método que imprime el título de las tiendas.
     */
    public static void tituloTiendas(){
        System.out.println(ANSI_YELLOW+ "\n" +
                "8888888 8888888888  8 8888 8 8888888888   b.             8 8 888888888o.            .8.            d888888o.   \n" +
                "      8 8888        8 8888 8 8888         888o.          8 8 8888    `^888.        .888.         .`8888:' `88. \n" +
                "      8 8888        8 8888 8 8888         Y88888o.       8 8 8888        `88.     :88888.        8.`8888.   Y8 \n" +
                "      8 8888        8 8888 8 8888         .`Y888888o.    8 8 8888         `88    . `88888.       `8.`8888.     \n" +
                "      8 8888        8 8888 8 888888888888 8o. `Y888888o. 8 8 8888          88   .8. `88888.       `8.`8888.    \n" +
                "      8 8888        8 8888 8 8888         8`Y8o. `Y88888o8 8 8888          88  .8`8. `88888.       `8.`8888.   \n" +
                "      8 8888        8 8888 8 8888         8   `Y8o. `Y8888 8 8888         ,88 .8' `8. `88888.       `8.`8888.  \n" +
                "      8 8888        8 8888 8 8888         8      `Y8o. `Y8 8 8888        ,88'.8'   `8. `88888.  8b   `8.`8888. \n" +
                "      8 8888        8 8888 8 8888         8         `Y8o.` 8 8888    ,o88P' .888888888. `88888. `8b.  ;8.`8888 \n" +
                "      8 8888        8 8888 8 888888888888 8            `Yo 8 888888888P'   .8'       `8. `88888. `Y8888P ,88P' \n" );
    }

    /**
     * Método que imprime la despedida de la aplicación.
     */
    public static void chao() {
        System.out.println(ANSI_PURPLE+"░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░█████╗░██╗░░██╗░█████╗░░█████╗░██╗░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██╔══██╗██║░░██║██╔══██╗██╔══██╗██║░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██║░░╚═╝███████║███████║██║░░██║██║░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██║░░██╗██╔══██║██╔══██║██║░░██║╚═╝░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░╚█████╔╝██║░░██║██║░░██║╚█████╔╝██╗░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝░╚════╝░╚═╝░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");
        System.out.println("░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░"+ ANSI_RESET);
    }


}
