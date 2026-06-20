package com.example.jaz_s32987_nbp.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Schema(description = "Contains information about a request for the average exchange rate")
public class RequestInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "The unique ID of the request info.")
    private long id;
    @Schema(description = "Contains the currency.")
    private String currency;
    @Schema(description = "The date, from which the analyzed period starts.")
    private LocalDate dateFrom;
    @Schema(description = "The end date of the analyzed period.")
    private LocalDate dateTo;
    @Schema(description = "The calculated result of the request.")
    private double result;
    @Schema(description = "The creation time of the request.")
    private LocalDateTime timeOfRequest;

    public RequestInfo() {

    }
    public RequestInfo(String currency, LocalDate dateFrom, LocalDate dateTo, double result, LocalDateTime timeOfRequest) {
        this.currency = currency;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.result = result;
        this.timeOfRequest = timeOfRequest;
    }

    public long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public double getResult() {
        return result;
    }

    public LocalDateTime getTimeOfRequest() {
        return timeOfRequest;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public void setTimeOfRequest(LocalDateTime timeOfRequest) {
        this.timeOfRequest = timeOfRequest;
    }

    @Override
    public String toString() {
        return "RequestInfo{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", from=" + dateFrom +
                ", to=" + dateTo +
                ", result=" + result +
                ", timeOfRequest=" + timeOfRequest +
                '}';
    }
}
