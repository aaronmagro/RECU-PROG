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
    public static void main(String[] args) {
        // Crear instancias de gestores y tiendas
        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Tienda> tiendas = new ArrayList<>();
        ArrayList<Producto> productos = new ArrayList<>();

        //GestorClientes gestorClientes = new GestorClientes();
        GestorProductos gestorProductos = new GestorProductos();
        GestorTiendas gestorTiendas = new GestorTiendas();

        // Cargar datos desde el archivo CSV
        GestorFicheros.leerDatosDesdeCSV("datosAplicacion.csv", productos, tiendas, clientes);

        // Menú principal
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("----------- Menú Principal -----------");
            System.out.println("1. Añadir un producto a una tienda.");
            System.out.println("2. Eliminar producto de una tienda.");
            System.out.println("3. Buscar un producto en una tienda (mostrará el stock disponible).");
            System.out.println("4. Mostrar el producto con mayor stock de una tienda.");
            System.out.println("5. Mostrar la tienda con mayor valor. (Q x €)");
            System.out.println("6. Mostrar información de productos de una tienda ordenada por stock.");
            System.out.println("7. Ejecutar simulación de venta.");
            System.out.println("8. Salir.");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea después de leer el número

            switch (opcion) {
                case 1:
                    // Implementar lógica para añadir un producto a una tienda
                    // Mostrar las tiendas disponibles

                    gestorTiendas.mostrarTiendas();
                    System.out.println("Escriba el nombre de la tienda: ");
                    String nombreTienda = scanner.nextLine();

                    // Seleccionar el producto por su nombre con un numero
                    System.out.println("Seleccione un producto: ");
                    gestorProductos.mostrarProductos();
                    String nombreProducto = scanner.nextLine();

                    // Introducir la cantidad
                    System.out.println("Introduzca la cantidad: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    //gestorTiendas.addStockATienda(nombreTienda, new Stock(, cantidad));

                    break;
                case 2:
                    // Implementar lógica para eliminar un producto de una tienda
                    //gestorProductos.eliminarProducto();
                    break;
                case 3:
                    // Implementar lógica para buscar un producto en una tienda

                    break;
                case 4:
                    // Implementar lógica para mostrar el producto con mayor stock de una tienda

                    break;
                case 5:
                    // Implementar lógica para mostrar la tienda con mayor valor

                    break;
                case 6:
                    // Implementar lógica para mostrar información de productos de una tienda ordenada por stock

                    break;
                case 7:
                    // Implementar lógica para ejecutar la simulación de venta

                    break;
                case 8:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }

        //mostrar los datos del csv leido



    }






}
