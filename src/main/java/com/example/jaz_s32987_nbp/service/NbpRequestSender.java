package com.example.jaz_s32987_nbp.service;

import com.example.jaz_s32987_nbp.entity.Root;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;

@Component
public class NbpRequestSender {
    private final RestTemplate restTemplate;

    NbpRequestSender(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Root getFromURL(String currency, LocalDate dateFrom, LocalDate dateTo) {
        try {
            return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + dateFrom + "/" + dateTo + "/", Root.class);
        } catch (HttpClientErrorException.NotFound e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } catch (HttpClientErrorException.BadRequest e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }/* catch (HttpServerErrorException.ServiceUnavailable e) {
            throw new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT);
        }*/
    }
}
