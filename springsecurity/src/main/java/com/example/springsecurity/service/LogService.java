package com.example.springsecurity.service;

import com.example.springsecurity.entity.Activity;
import com.example.springsecurity.repo.LogRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LogService {
    private final LogRepo logRepo;

    public void save(Activity activity) {
        logRepo.save(activity);
    }
}
