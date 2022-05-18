package com.example.lab2.repository;

import com.example.lab2.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends CrudRepository<ActivityLog, Integer> {
}
