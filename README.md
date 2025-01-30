# CEP API - Projeto Spring Boot

Este é um projeto Spring Boot que implementei para criar uma API que consulta informações de um CEP (Código de Endereçamento Postal) utilizando a API pública **ViaCEP**. O sistema valida o CEP informado e, caso seja válido, retorna os detalhes associados, como endereço, bairro, cidade e estado.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.2**
- **Maven**
- **RestTemplate** (para realizar chamadas HTTP)

## Funcionalidades

- **Validação do formato do CEP:** O CEP precisa estar no formato `00000-000`.
- **Consulta ao ViaCEP:** Ao receber um CEP válido, a API retorna as informações associadas ao CEP utilizando a API pública **ViaCEP**.

## Endpoints

### `GET /consulta-cep?cep={cep}`

Com este endpoint, é possível consultar as informações de um CEP.

#### **Parâmetros:**
- `cep` (obrigatório): O CEP a ser consultado, no formato `00000-000`.

#### **Exemplo de Requisição:**
```bash
GET http://localhost:8080/consulta-cep?cep=01001-000
```

#### **Exemplo de Resposta (sucesso):**
``` json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```

#### **Exemplo de Resposta (erro - CEP inválido):**
``` json
{
  "message": "CEP inválido. Use o formato 00000-000."
}
```
# Como Executar

## Pré-requisitos
Antes de iniciar, é necessário ter os seguintes itens instalados:

- Java 17 ou superior  
- Maven  

## Passos para execução  

### Clone este repositório:
```bash
git clone https://github.com/Matheus-Mastellona/API---Projeto-Spring-Boot
```

### Acesse o diretório do projeto:
```bash
cd cep-api
```

### Compile e inicie a aplicação:
```bash
mvn spring-boot:run
```

### A aplicação estará disponível em:
```bash
http://localhost:8080
```

## Testando a API

Após iniciar o projeto, você pode testar a API enviando uma requisição GET para o endpoint /consulta-cep com o parâmetro cep:
```bash
curl "http://localhost:8080/consulta-cep?cep=01001-000"
```
![image](https://github.com/user-attachments/assets/ee0b2a56-1b80-4363-b0c3-022b81245ea5)


## Configuração
A configuração do projeto está no arquivo application.properties:

```properties
spring.application.name=cep-api
spring.jackson.serialization.indent_output=true
```

## Dependências
O projeto utiliza as seguintes dependências Maven:

```xml
<dependencies>
    <!-- Spring Boot Web -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Ferramentas de Desenvolvimento -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>

    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>

    <!-- Testes -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

```
## Considerações Finais
Este projeto foi desenvolvido como parte do meu processo seletivo para a vaga de Dev back-end (java/Spring Boot). Durante a implementação, busquei aplicar boas práticas no desenvolvimento com Spring Boot, garantindo um código limpo, modular e eficiente.

Caso tenha algum feedback ou queira discutir melhorias, ficarei feliz em conversar! Obrigado pela oportunidade e pelo tempo dedicado à avaliação do meu trabalho.

Se precisar entrar em contato, estou disponível no LinkedIn ou pelo e-mail.
