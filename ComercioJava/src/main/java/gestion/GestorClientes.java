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

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void delCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

}


