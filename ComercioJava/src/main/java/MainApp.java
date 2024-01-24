import gestion.GestorClientes;
import gestion.GestorFicheros;
import gestion.GestorProductos;
import local.inventario.Stock;
import local.manejo.Cliente;
import local.manejo.Tienda;
import productos.Producto;
import productos.Verdura;
import productos.Carne;
import productos.Pescado;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        // Crear instancias de gestores y tiendas
        GestorProductos gestorProductos = new GestorProductos();
        ArrayList<Tienda> tiendas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        // Cargar datos desde el archivo CSV
        GestorFicheros.leerDatosDesdeCSV("datosAplicacion.csv", gestorProductos, tiendas, clientes);

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

                    gestorProductos.agregarProducto();
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
