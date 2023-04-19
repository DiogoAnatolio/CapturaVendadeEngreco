package ui;

import br.newtonpaiva.Cliente;
import br.newtonpaiva.Ingresso;
import br.newtonpaiva.Pedido;

import javax.swing.*;
import java.util.ArrayList;

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

        String nomeIngresso = "";
        int posicao = 0;

        for (int i = 0; 1 < pedido.getIngressos().size(); i++){
            Ingresso ing = (Ingresso) pedido.getIngressos().get(i);
            nomeIngresso += ing.nome;
            if(posicao == pedido.getIngressos().size() - 2){
                nomeIngresso += ing.nome + "e";
            } else if (posicao == pedido.getIngressos().size() -1) {
                nomeIngresso += ing.nome + ".";
            } else {
                nomeIngresso += ing.nome + ",";
            }
            posicao++;
        }

        JOptionPane.showMessageDialog(null, "Pedido feito para " + nomeIngresso);

                //"\n" + ingresso.getQuantidade() + "ingressos: " + ingresso.nome + "\n Valor: " + );

        }
    }


