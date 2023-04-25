package ui;

import br.newtonpaiva.Cliente;
import br.newtonpaiva.Ingresso;
import br.newtonpaiva.Pedido;

import javax.swing.*;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class LojaJogos {
    public static void main(String[] args) {

        try {
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

                if (ingressoDeOutroJogo > 2 || ingressoDeOutroJogo < 1) {
                    throw new Exception("Digita apenas a opção 1 ou 2");
                }

                ingresso.nome = nomeJogo;
                ingresso.setValor(valor);
                ingresso.setQuantidade(quantidadeDeIngresso);
                pedido.setCliente(cliente);
                pedido.getIngressos().add(ingresso);

            } while (ingressoDeOutroJogo == 1);


            String mensagemJogos = "";
            int posicao = 0;
            for (Ingresso ing : pedido.getIngressos()) {
                if (posicao == pedido.getIngressos().size() - 1) {
                    mensagemJogos += ing.getQuantidade() + " Ingresso(s): " + ing.nome;
                } else {
                    mensagemJogos += ing.getQuantidade() + " Ingresso(s): " + ing.nome + "\n";
                }
                String mensagem = "Pedido feito para " + cliente.getNome() + "\n" + mensagemJogos + "\nValor: " + pedido.calculaValor(ing);
                JOptionPane.showMessageDialog(null, mensagem);
            }


        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Favor entrar com números ao invés de letras");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
    }
}


