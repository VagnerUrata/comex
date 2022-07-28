package br.com.alura.comex;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {

    ArrayList<Pedido> pedidos = ProcessadorDeCsv.processaArquivo("pedidos.csv");
    System.out.println("Número de pedidos: " + pedidos.size());

    Pedido primeiroPedido = pedidos.get(0);
    System.out.println("Primeiro pedido: " + primeiroPedido);

    Pedido ultimoPedido = pedidos.get(pedidos.size()-1);
    System.out.println("Ultimo pedido: " + ultimoPedido);
  }
}
