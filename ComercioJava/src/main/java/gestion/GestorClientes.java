package gestion;

import local.manejo.Cliente;
import local.manejo.Tienda;

import java.util.ArrayList;

public class GestorClientes {
    private ArrayList<Cliente> clientes;

    public GestorClientes() {
        this.clientes = new ArrayList<>();
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void delCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

}


