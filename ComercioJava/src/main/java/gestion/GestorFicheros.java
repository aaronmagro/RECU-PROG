package gestion;

import local.manejo.Cliente;
import local.manejo.Tienda;
import productos.Carne;
import productos.Pescado;
import productos.Producto;
import productos.Verdura;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class GestorFicheros {
    public static void leerDatosDesdeCSV(String absolutePath, GestorProductos gestorProductos, ArrayList<Tienda> tiendas, ArrayList<Cliente> clientes) {
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
                            switch (group) {
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

                            /*if (producto != null) {
                                gestorProductos.agregarProducto(producto, 1); // Añade el producto con cantidad inicial de 1
                            }*/

                            System.out.println(producto);


                        }
                        break;
                    case "shops":
                        if (parts.length >= 2) {
                            String shopName = parts[0];
                            String shopAddress = parts[1];
                            Tienda tienda = new Tienda(shopName, shopAddress);
                            tiendas.add(tienda);

                            System.out.println(tienda);
                        }
                        break;
                    case "customers":
                        if (parts.length >= 1) {
                            String customerName = parts[0];
                            Cliente cliente = new Cliente(customerName, null);
                            clientes.add(cliente);

                            System.out.println(cliente);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
                        inQuotes = !inQuotes; // Cambia el estado de estar dentro de las comillas
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


    public static void main(String[] args) {
        GestorProductos gestorProductos = new GestorProductos();
        ArrayList<Tienda> tiendas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        String relativePath = "datosAplicacion.csv";
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();

        leerDatosDesdeCSV(absolutePath, gestorProductos, tiendas, clientes);

    }
}