package com.conversormoedas;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
  private ApiClient apiClient;

  public Menu() {
    this.apiClient = new ApiClient();
  }

  public void exibir() {
    Scanner scanner = new Scanner(System.in);
    int comando = 0;

    while (comando != 8) {
      System.out.printf("%-20s%n", "|               MENU                   |");
      System.out.printf("%-10s%n", "| 1-) Real brasileiro >>> Dolar        |");
      System.out.printf("%-10s%n", "| 2-) Real brasileiro >>> Franco suíço |");
      System.out.printf("%-10s%n", "| 3-) Dolar >>> Peso colombiano        |");
      System.out.printf("%-10s%n", "| 4-) Peso argentino >>> Dolar         |");
      System.out.printf("%-10s%n", "| 5-) Peso colombiano >> Dolar         |");
      System.out.printf("%-10s%n", "| 6-) Euro >>> Real brasileiro         |");
      System.out.printf("%-10s%n", "| 7-) Libra esterlina >>> Dolar        |");
      System.out.printf("%-10s%n", "| 8-) Sair                             |");
      System.out.print("Escolha uma opção: ");

      comando = scanner.nextInt();

      try {
        switch (comando) {
          case 1:
            exibirConversao("BRL", "USD");
            break;
          case 2:
            exibirConversao("BRL", "CHF");
            break;
          case 3:
            exibirConversao("USD", "COP");
            break;
          case 4:
            exibirConversao("ARS", "USD");
            break;
          case 5:
            exibirConversao("COP", "USD");
            break;
          case 6:
            exibirConversao("EUR", "BRL");
            break;
          case 7:
            exibirConversao("GBP", "USD");
            break;
          case 8:
            System.out.println("Saindo...");
            break;
          default:
            System.out.println("Opção inválida. Tente novamente.");
        }
      } catch (IOException | InterruptedException e) {
        System.out.println("Erro na conversão: " + e.getMessage());
      }
    }
    scanner.close();
  }

  private void exibirConversao(String moedaBase, String moedaBusca) throws IOException, InterruptedException {
    Moeda moeda = apiClient.buscar(moedaBase, moedaBusca);
    System.out.printf("%n%n1 %s = %.2f %s%n", moeda.getMoedaBase(), moeda.getValor(), moeda.getMoedaBusca());

    Scanner scanner = new Scanner(System.in);
    System.out.println("Pressione qualquer tecla para voltar ao menu...");
    scanner.nextLine();
    limparTela();
  }

  private void limparTela() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (IOException | InterruptedException e) {
      System.out.println("Erro ao limpar a tela.");
    }
  }
}
