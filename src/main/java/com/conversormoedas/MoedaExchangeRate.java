package com.conversormoedas;

import java.util.Map;

public class MoedaExchangeRate {

  private String base_code;
  private Map<String, Double> conversion_rates;

  public String base_code() {
    return base_code;
  }

  public Double conversion_rate(String targetCurrency) {
    return conversion_rates.get(targetCurrency);
  }

  public double conversionRateFor(String targetCurrency) {
    return conversion_rates.getOrDefault(targetCurrency, 0.0);
  }
}
