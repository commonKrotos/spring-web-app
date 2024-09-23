package com.backend.road.service;

import com.backend.road.repository.RtyRepository;
import org.springframework.stereotype.Service;

@Service
public class RtyService {

    final
    RtyRepository rtyRepository;

    public RtyService(RtyRepository rtyRepository) {
        this.rtyRepository = rtyRepository;
    }
    }
