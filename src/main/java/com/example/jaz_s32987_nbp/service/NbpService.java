package com.example.jaz_s32987_nbp.service;

import com.example.jaz_s32987_nbp.entity.RequestInfo;
import com.example.jaz_s32987_nbp.entity.Root;
import com.example.jaz_s32987_nbp.repository.NbpRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NbpService {
    private final NbpRequests nbpRequests;
    private final NbpRepository nbpRepository;

    NbpService(NbpRequests nbpRequests, NbpRepository nbpRepository) {
        this.nbpRequests = nbpRequests;
        this.nbpRepository = nbpRepository;
    }

    public Root getRootByCurrencyAndFromTo(String currency, LocalDate dateFrom, LocalDate dateTo) {
        return nbpRequests.getFromURL(currency, dateFrom, dateTo);
    }

    public void saveRequestInfo(
            String currency,
            LocalDate dateFrom,
            LocalDate dateTo,
            double result,
            LocalDateTime timeOfRequest) {
        RequestInfo requestInfo = new RequestInfo();

        requestInfo.setCurrency(currency);
        requestInfo.setDateFrom(dateFrom);
        requestInfo.setDateTo(dateTo);
        requestInfo.setResult(result);
        requestInfo.setTimeOfRequest(timeOfRequest);

        nbpRepository.save(requestInfo);
    }
}

