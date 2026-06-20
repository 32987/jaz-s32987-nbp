package com.example.jaz_s32987_nbp.repository;

import com.example.jaz_s32987_nbp.entity.RequestInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpRepository extends JpaRepository<RequestInfo, Long> {
    
}
