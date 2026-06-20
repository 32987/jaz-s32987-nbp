package com.example.jaz_s32987_nbp.service;

import com.example.jaz_s32987_nbp.entity.Root;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class NbpRequests {
    private final RestTemplate restTemplate;

    NbpRequests(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root getFromURL(String currency, LocalDate dateFrom, LocalDate dateTo) {
        /*try {*/
            return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + dateFrom + "/" + dateTo + "/", Root.class);
        /*} catch () {

        }*/
    }
}
