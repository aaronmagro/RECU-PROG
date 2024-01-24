package gestion;

import local.manejo.Cliente;
import local.manejo.Tienda;

import java.util.ArrayList;

public class GestorClientes {
    private ArrayList<Cliente> clientes;
    private Tienda tienda;

    public GestorClientes(Tienda tienda) {
        this.clientes = new ArrayList<>();
        this.tienda = tienda;
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

}

