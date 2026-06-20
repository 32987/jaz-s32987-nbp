package com.example.jaz_s32987_nbp.controller;

import com.example.jaz_s32987_nbp.entity.Root;
import com.example.jaz_s32987_nbp.service.NbpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/nbp")
public class NbpRestController {
    private final NbpService nbpService;

    NbpRestController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/{currency}/{from}/{to}")
    public ResponseEntity<String> getCurrencyAvgFromTo(
            @PathVariable String currency,
            @PathVariable LocalDate dateFrom,
            @PathVariable LocalDate dateTo) {


        Root root = nbpService.getRootByCurrencyAndFromTo(currency, dateFrom, dateTo);

        nbpService.saveRequestInfo(currency, dateFrom, dateTo, result, timeOfRequest);
        nbpService.getCurrencyAvgFromTo();
    }
}
