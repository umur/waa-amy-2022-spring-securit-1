package com.lab.springdata.service.impl;

import com.lab.springdata.entity.Activitylog;
import com.lab.springdata.repo.ActivitylogRepo;
import com.lab.springdata.service.ActivitylogService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivitylogServiceImpl implements ActivitylogService {
    //@NonNull
    private final ActivitylogRepo activitylogRepo;

    public void save(Activitylog activitylog){
        activitylogRepo.save(activitylog);
    }
    public List<Activitylog> getAll(){
        return activitylogRepo.findAll();
    }

}
