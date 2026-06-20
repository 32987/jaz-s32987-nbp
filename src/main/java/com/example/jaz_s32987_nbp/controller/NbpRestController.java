package com.example.jaz_s32987_nbp.controller;

import com.example.jaz_s32987_nbp.service.NbpService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/nbp")
public class NbpRestController {
    private final NbpService nbpService;

    NbpRestController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/{currency}/{dateFrom}/{dateTo}")
    public ResponseEntity<Double> getCurrencyAvgFromTo(
            @Parameter(name = "Currency", description = "The chosen currency to calculate the average of.")
            @PathVariable String currency,
            @Parameter(name = "Date from", description = "The date that marks the beginning of the analyzed time period.")
            @PathVariable LocalDate dateFrom,
            @Parameter(name = "Date to", description = "The date that marks the end of the analyzed time period.")
            @PathVariable LocalDate dateTo) {

        double average = nbpService.calculateAverage(currency, dateFrom, dateTo);
        nbpService.saveRequestInfo(currency, dateFrom, dateTo, average, LocalDateTime.now());

        return ResponseEntity.ok(average);
    }
}
