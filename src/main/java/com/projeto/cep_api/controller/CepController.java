package com.projeto.cep_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@RestController
public class CepController {

    private final RestTemplate restTemplate;

    public CepController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/consulta-cep")
    public ResponseEntity<Object> consultaCep(@RequestParam String cep) {
        // Validar o formato do CEP (00000-000)
        if (!cep.matches("\\d{5}-\\d{3}")) {
            return ResponseEntity.badRequest().body("CEP inválido. Use o formato 00000-000.");
        }

        // Consultar a API ViaCep
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);

        // Retornar a resposta da API ViaCep
        return response;
    }
}
