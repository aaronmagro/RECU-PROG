package gestion;

import local.inventario.Stock;
import local.manejo.Cliente;
import local.manejo.Tienda;
import productos.Carne;
import productos.Pescado;
import productos.Producto;
import productos.Verdura;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GestorFicheros {

    // Métodos
    /**
     * Lee los datos de un fichero CSV y los almacena en las listas de productos, tiendas y clientes.
     * @param absolutePath Ruta absoluta del fichero CSV.
     * @param productos Lista de productos.
     * @param gestorTiendas Gestor de tiendas.
     * @param gestorClientes Gestor de clientes.
     */
    public static void leerDatosDesdeCSV(String absolutePath, ArrayList<Producto> productos, GestorTiendas gestorTiendas, GestorClientes gestorClientes) {
        try (BufferedReader br = new BufferedReader(new FileReader(absolutePath))) {
            String line;
            String currentSection = "";
            boolean isFirstLineOfSection = true;

            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    continue;
                }

                if (line.contains("products") || line.contains("shops") || line.contains("customers")) {
                    currentSection = line.contains("products") ? "products" :
                            line.contains("shops") ? "shops" : "customers";
                    isFirstLineOfSection = true;
                    continue;
                }

                if (isFirstLineOfSection) {
                    isFirstLineOfSection = false;
                    continue;
                }

                String[] parts = customSplit(line, currentSection);
                switch (currentSection) {
                    case "products":
                        if (parts.length >= 7) {
                            String foodName = parts[0];
                            String scientificName = parts[1];
                            String group = parts[2];
                            String subGroup = parts[3];
                            double kcal = Double.parseDouble(parts[4].replace("\"", "").replace(",", "."));
                            double price = Double.parseDouble(parts[5].replace("\"", "").replace(",", "."));
                            int expiration = Integer.parseInt(parts[6].replace("\"", ""));

                            Producto producto = null;
                            switch (group) { // Crear el producto según el grupo
                                case "Animal foods":
                                    producto = new Carne(foodName, scientificName, kcal, price, subGroup);
                                    break;
                                case "Aquatic foods":
                                    producto = new Pescado(foodName, scientificName, kcal, price, subGroup);
                                    break;
                                case "Vegetables":
                                    producto = new Verdura(foodName, scientificName, kcal, price, LocalDate.now(), expiration);
                                    break;
                            }

                            productos.add(producto);
                            System.out.println(producto);

                        }
                        break;
                    case "shops":
                        if (parts.length >= 2) {
                            String shopName = parts[0];
                            String shopAddress = parts[1];
                            GestorProductos gestorProductos = new GestorProductos();
                            // agregar 10 productos aleatorios al gestorProductos de cada tienda
                            for (int i = 0; i < 10; i++) {
                                gestorProductos.addStock(new Stock(productos.get((int) (Math.random() * productos.size())), (int) (Math.random() * 10) + 1));
                            }
                            Tienda tienda = new Tienda(shopName, shopAddress, gestorProductos);

                            gestorTiendas.addTienda(tienda);
                            System.out.println(tienda);
                        }
                        break;
                    case "customers":
                        if (parts.length >= 1) {
                            String customerName = parts[0];
                            // hacer una lista de la copra aleatoria de 1 a 10 productos para cada cliente
                            ArrayList<Producto> listaCompra = new ArrayList<>();
                            int numeroProductos = (int) (Math.random() * 10) + 1;
                            for (int i = 0; i < numeroProductos; i++) {
                                listaCompra.add(productos.get((int) (Math.random() * productos.size())));
                            }
                            // De la misma lista, sacar el producto favorito
                            Producto productoFavorito = listaCompra.get((int) (Math.random() * listaCompra.size()));
                            Cliente cliente = new Cliente(customerName, productoFavorito, listaCompra);

                            gestorClientes.addCliente(cliente);
                            System.out.println(cliente);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Divide una línea de un fichero CSV de manera personalizada.
     * @param line Línea del fichero CSV.
     * @param currentSection Sección actual del fichero CSV.
     * @return Array de partes de la línea.
     */
    private static String[] customSplit(String line, String currentSection) {
        // Dividir la línea de manera predeterminada para obtener el grupo del producto
        String[] preliminaryParts = line.split(",");
        for (int i = 0; i < preliminaryParts.length; i++) {
            preliminaryParts[i] = preliminaryParts[i].trim();
        }

        // Si estamos en la sección de productos y hay suficientes partes, obtenemos el grupo del producto
        String group = "";
        if (currentSection.equals("products") && preliminaryParts.length >= 3) {
            group = preliminaryParts[2];
        }

        // Ahora dividimos la línea de la manera correcta basándonos en el grupo del producto
        if (currentSection.equals("products")) {
            if (group.equals("Vegetables")) {
                ArrayList<String> parts = new ArrayList<>();
                boolean inQuotes = false;
                StringBuilder buffer = new StringBuilder();

                for (char ch : line.toCharArray()) {
                    if (ch == '\"') {
                        inQuotes = !inQuotes; // Cambia el estado de las comillas
                    } else if (ch == ',' && !inQuotes) {
                        parts.add(buffer.toString().trim()); // Agrega la parte al resultado y limpia el buffer
                        buffer = new StringBuilder();
                    } else {
                        buffer.append(ch); // Agrega el carácter al buffer
                    }
                }
                if (!buffer.isEmpty()) {
                    parts.add(buffer.toString().trim()); // Agrega la última parte al resultado
                }

                return parts.toArray(new String[0]);
            } else if (group.equals("Aquatic foods") || group.equals("Animal foods")) {
                return preliminaryParts;
            }
        }

        if (currentSection.equals("shops") || currentSection.equals("customers")) {
            return preliminaryParts;
        }

        return new String[] {};
    }

    /**
     * Exporta una simulación de compra a un fichero de texto para cada cliente.
     * @param gestorTiendas Gestor de tiendas.
     * @param gestorClientes Gestor de clientes.
     */
    public void exportarSimulacion(GestorTiendas gestorTiendas, GestorClientes gestorClientes) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        LocalDateTime now = LocalDateTime.now();

        for (Cliente cliente : gestorClientes.getClientes()) {
            for (Tienda tienda : gestorTiendas.getTiendas()) {
                Stock stock = tienda.getGestorProductos().buscarProductoSecuencial(cliente.getProductoFavorito().getNombre());

                if (stock != null && stock.getCantidad() > 0) {
                    String filename = "resumen_" + cliente.getNombre() + "_" + dtf.format(now) + ".txt";
                    String simulationResults = hacerSimulacion(cliente, tienda);

                    try {
                        // Crear la carpeta si no existe
                        File directory = new File(dtf.format(now));
                        if (! directory.exists()){
                            directory.mkdir();
                        }

                        // Escribir el fichero en la carpeta
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/" + filename))) {
                            writer.write(simulationResults);
                        } catch (IOException e) {
                            System.out.println("An error occurred while writing to the file: " + e.getMessage());
                        }
                    } catch (Exception e) {
                        System.out.println("An error occurred while creating the directory: " + e.getMessage());
                    }

                    break;
                }
            }
        }
    }

    /**
     * Realiza una simulación de compra de un cliente en una tienda.
     * @param cliente Cliente que realiza la compra.
     * @param tienda Tienda en la que se realiza la compra.
     * @return Cadena con el resumen de la simulación.
     */
    private static String hacerSimulacion(Cliente cliente, Tienda tienda) {
        StringBuilder simulationResults = new StringBuilder();

        simulationResults.append("═══════════════════════════════════════════════════════════════════════════════════\n");
        simulationResults.append("Resumen de compra del cliente " + cliente.getNombre() + " en la tienda " + tienda.getNombre() + "\n");
        simulationResults.append("═══════════════════════════════════════════════════════════════════════════════════\n");

        simulationResults.append("\nStock inicial:\n");
        for (Stock stock : tienda.getGestorProductos().getStocks()) {
            simulationResults.append(stock.getProducto().getNombre() + " ▸ " + stock.getCantidad() + "\n");
        }

        simulationResults.append("\n═════════════════════════════ INICIO DE LA SIMULACIÓN ═════════════════════════════\n");

        simulationResults.append("\n" + tienda.getNombre() + "\n");
        simulationResults.append("\n\uD83E\uDDCD Cliente: " + cliente.getNombre() + "\n");
        simulationResults.append("\n\uD83E\uDDFE Lista de la compra:\n");
        for (Producto producto : cliente.getListaCompra()) {
            simulationResults.append(" - "+producto.getNombre() + "\n");
        }
        simulationResults.append("\n\uD83C\uDF1F Producto favorito: " + cliente.getProductoFavorito().getNombre() + "\n");
        simulationResults.append("\n\uD83D\uDED2 Compra:\n");

        int nums = 1; // Initialize counter

        // Comprar primero el producto favorito y luego el resto
        Stock favorito = tienda.getGestorProductos().buscarProductoSecuencial(cliente.getProductoFavorito().getNombre());
        if (favorito != null && favorito.getCantidad() > 0) {
            simulationResults.append(nums + ". Se ha vendido " + cliente.getProductoFavorito().getNombre() + " a " + cliente.getNombre() + "\n");
            favorito.setCantidad(favorito.getCantidad() - 1);
            nums++;
        } else {
            simulationResults.append(nums + ". No hay stock de " + cliente.getProductoFavorito().getNombre() + " para " + cliente.getNombre() + "\n");
            nums++;
        }

        // Resto de productos
        for (Producto producto : cliente.getListaCompra()) {
            // Saltar el producto favorito porque ya se ha comprado
            if (producto.equals(cliente.getProductoFavorito())) {
                continue;
            }

            Stock stock = tienda.getGestorProductos().buscarProductoSecuencial(producto.getNombre());
            if (producto instanceof Verdura verdura) {
                if (verdura.estaCaducada()) {
                    simulationResults.append(nums + ". No se puede vender " + producto.getNombre() + " a " + cliente.getNombre() + " porque está caducada\n");
                    nums++;
                    continue;
                }
            }

            if (stock != null) {
                if (stock.getCantidad() > 0) {
                    simulationResults.append(nums + ". Se ha vendido " + producto.getNombre() + " a " + cliente.getNombre() + "\n");
                    stock.setCantidad(stock.getCantidad() - 1);
                    nums++;
                } else {
                    simulationResults.append(nums + ". No hay stock de " + producto.getNombre() + " para " + cliente.getNombre() + "\n");
                    nums++;
                }
            } else {
                simulationResults.append(nums + ". No hay stock de " + producto.getNombre() + " para " + cliente.getNombre() + "\n");
                nums++;
            }
        }

        simulationResults.append("\n═══════════════════════════════ FIN DE LA SIMULACIÓN ══════════════════════════════\n");

        simulationResults.append("\nStock final:\n");
        for (Stock stock : tienda.getGestorProductos().getStocks()) {
            simulationResults.append(stock.getProducto().getNombre() + " ▸ " + stock.getCantidad() + "\n");
        }

        return simulationResults.toString();
    }

}