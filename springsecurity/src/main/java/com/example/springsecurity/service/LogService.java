package com.example.springsecurity.service;


import com.example.springsecurity.entity.Activity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.springsecurity.repo.LogRepo;
@Service
@AllArgsConstructor
public class LogService {


    private final LogRepo logRepo;

    public void save(Activity activity) {
        logRepo.save(activity);
    }
}
