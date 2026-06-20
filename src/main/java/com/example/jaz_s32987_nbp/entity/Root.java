package com.example.jaz_s32987_nbp.entity;

import java.util.List;

public class Root {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Root{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}

