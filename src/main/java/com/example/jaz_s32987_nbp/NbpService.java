package com.example.jaz_s32987_nbp;

import org.springframework.stereotype.Service;

@Service
public class NbpService {
    private final NbpRequests nbpRequests;

    NbpService(NbpRequests nbpRequests) {
        this.nbpRequests = nbpRequests;
    }

    public void getCurrencyAvgFromTo() {

    }
}

