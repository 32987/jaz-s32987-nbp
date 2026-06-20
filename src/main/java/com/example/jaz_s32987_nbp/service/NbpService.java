package com.example.jaz_s32987_nbp.service;

import com.example.jaz_s32987_nbp.entity.Rate;
import com.example.jaz_s32987_nbp.entity.RequestInfo;
import com.example.jaz_s32987_nbp.entity.Root;
import com.example.jaz_s32987_nbp.repository.NbpRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NbpService {
    private final NbpRequestSender nbpRequestSender;
    private final NbpRepository nbpRepository;

    NbpService(NbpRequestSender nbpRequestSender, NbpRepository nbpRepository) {
        this.nbpRequestSender = nbpRequestSender;
        this.nbpRepository = nbpRepository;
    }

    public double calculateAverage(String currency, LocalDate dateFrom, LocalDate dateTo) {
        Root root = nbpRequestSender.getFromURL(currency, dateFrom, dateTo);
        double sumOfAllMids = root.getRates()
                .stream()
                .mapToDouble(Rate::getMid)
                .sum();
        return sumOfAllMids / root.getRates().size();
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
        requestInfo.setAverage(result);
        requestInfo.setTimeOfRequest(timeOfRequest);

        nbpRepository.save(requestInfo);
    }
}

