package com.example.jaz_s32987_nbp;

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
            @PathVariable LocalDate from,
            @PathVariable LocalDate to) {
        nbpService.getCurrencyAvgFromTo();

    }
}
