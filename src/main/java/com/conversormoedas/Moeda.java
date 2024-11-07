package com.conversormoedas;

public class Moeda {

  private String moedaBase; 
  private String moedaBusca; 
  private double valor;

  public Moeda(String moedaBase, String moedaBusca, double valor) {
    this.moedaBase = moedaBase;
    this.moedaBusca = moedaBusca;
    this.valor = valor;
  }

  public String getMoedaBase() {
    return moedaBase;
  }

  public String getMoedaBusca() {
    return moedaBusca;
  }

  public double getValor() {
    return valor;
  }
}
