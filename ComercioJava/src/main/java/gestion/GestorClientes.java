package gestion;

import local.manejo.Cliente;

import java.util.ArrayList;

public class GestorClientes {

    // Atributos
    private ArrayList<Cliente> clientes;

    // Constructor
    public GestorClientes() {
        this.clientes = new ArrayList<>();
    }

    // Getters y Setters
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    // Métodos
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

}


