package ui;

import br.newtonpaiva.Cliente;
import br.newtonpaiva.Ingresso;
import br.newtonpaiva.Pedido;

import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class LojaJogos {
    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        Ingresso ingresso = new Ingresso();
        Pedido pedido = new Pedido();
        pedido.setIngressos(new ArrayList<>());

        String nome = JOptionPane.showInputDialog("Insira o seu nome: ");
        cliente.setNome(nome);

        Integer ingressoDeOutroJogo;

        do {

            String nomeJogo = JOptionPane.showInputDialog("Informe o nome do jogo");

            Double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do jogo: "));

            Integer quantidadeDeIngresso = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantia de ingressos desejados: "));

            ingressoDeOutroJogo = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja comprar o ingresso de outro jogo? \n Digite 1 para - Sim \n Digite 2 para - Não", "", JOptionPane.QUESTION_MESSAGE));


            ingresso.nome = nomeJogo;
            ingresso.setValor(valor);
            ingresso.setQuantidade(quantidadeDeIngresso);
            pedido.setCliente(cliente);
            pedido.getIngressos().add(ingresso);


        } while (ingressoDeOutroJogo == 1);


        String mensagem = "Pedido feito para " + cliente.getNome();
        String nomeIngresso = "";
        Ingresso ing = null;
        String mensagem1 = "";
        int i;

        for (i = 0; i < pedido.getIngressos().size(); i++) {
            ing = (Ingresso) pedido.getIngressos().get(i);
            if (i == pedido.getIngressos().size() - 1)
                mensagem1 += ing.getQuantidade() + " ingressos(s) para o jogo: " + ing.nome + "\n";
            else
                mensagem1 += ing.getQuantidade() + " ingressos(s) para o jogo: " + ing.nome + "\n";

        }

        String mensagem2 = mensagem + "\n" + mensagem1 + "O valor total dos ingressos é: " + pedido.calculaValor(ing);
        showMessageDialog(null, mensagem2);
    }
}


