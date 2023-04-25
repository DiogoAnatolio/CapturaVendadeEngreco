package br.newtonpaiva;
import br.newtonpaiva.Cliente;
import br.newtonpaiva.Ingresso;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pedido {

    private Cliente cliente;
    private ArrayList<Ingresso> ingressos;

    public Double calculaValor(Ingresso ingresso){
        Double saldoFinal = ingresso.getValor()*ingresso.getQuantidade();
        return saldoFinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(ArrayList<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

}
