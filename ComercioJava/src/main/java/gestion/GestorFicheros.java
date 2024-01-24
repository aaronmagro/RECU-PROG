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

                String[] parts = line.split(",");
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

                            System.out.println(tiendas);
                        }
                        break;
                    case "customers":
                        if (parts.length >= 1) {
                            String customerName = parts[0];
                            Cliente cliente = new Cliente(customerName, null);
                            clientes.add(cliente);

                            System.out.println(clientes);
                        }
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GestorProductos gestorProductos = new GestorProductos();
        ArrayList<Tienda> tiendas = new ArrayList<>();
        ArrayList<Cliente> clientes = new ArrayList<>();

        String relativePath = "datosAplicacion.csv";
        File file = new File(relativePath);
        String absolutePath = file.getAbsolutePath();

        leerDatosDesdeCSV(absolutePath, gestorProductos, tiendas, clientes);

        // Imprimir para verificar
        System.out.println(gestorProductos);
        System.out.println(tiendas);
        System.out.println(clientes);
    }
}