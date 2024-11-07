package com.conversormoedas;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import com.google.gson.Gson;

public class ApiClient {

  private String apiKey = "apikey"; 
  private String site = "https://v6.exchangerate-api.com/v6/";
  private Gson gson;

  public ApiClient() {
    gson = new Gson();
  }

  public Moeda buscar(String moedaBase, String moedaBusca) throws IOException, InterruptedException {
    String endereco = site + apiKey + "/latest/" + moedaBase;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(endereco))
        .build();

    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
    
    String json = response.body();
    MoedaExchangeRate moedaExchangeRate = gson.fromJson(json, MoedaExchangeRate.class);
    
    double valor = moedaExchangeRate.conversionRateFor(moedaBusca);
    return new Moeda(moedaBase, moedaBusca, valor);
  }
}
