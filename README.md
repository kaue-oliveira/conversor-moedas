# Conversor de Moedas

Este é um projeto simples de conversão de moedas utilizando uma API externa para realizar as conversões em tempo real.

## Funcionalidade

O programa exibe um menu aonde o usuário pode escolher uma conversão de moedas. Após a seleção, o programa mostra o valor da conversão correspondente.
## Estrutura do Menu

O menu oferece as seguintes opções de conversão de moedas:

1. **Real brasileiro (BRL) para Dólar (USD)**
2. **Real brasileiro (BRL) para Franco suíço (CHF)**
3. **Dólar (USD) para Peso colombiano (COP)**
4. **Peso argentino (ARS) para Dólar (USD)**
5. **Peso colombiano (COP) para Dólar (USD)**
6. **Euro (EUR) para Real brasileiro (BRL)**
7. **Libra esterlina (GBP) para Dólar (USD)**
8. **Sair**

## Como Testar o Projeto

### Pré-requisitos

Para rodar o projeto, você precisará de:

- **Java 8 ou superior**
- **Uma chave de API**
  
### Instruções

1. **Obtenha uma chave de API:**

   O projeto utiliza a API `https://v6.exchangerate-api.com` para realizar as conversões. Você precisará se cadastrar no site e obter sua chave de API.

2. **Coloque a sua chave de API no código:**

   Após obter sua chave de API, abra a classe `ApiClient.java` e substitua o valor de `apiKey` pela sua chave.


