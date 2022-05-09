package com.lab.springdata.service;

import com.lab.springdata.entity.Activitylog;
import com.lab.springdata.repo.ActivitylogRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ActivitylogService {


    public void save(Activitylog activitylog);
    public List<Activitylog> getAll();

}
