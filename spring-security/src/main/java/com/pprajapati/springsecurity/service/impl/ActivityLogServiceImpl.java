package com.pprajapati.springsecurity.service.impl;

import com.pprajapati.springsecurity.domain.ActivityLog;
import com.pprajapati.springsecurity.repo.ActivityLogRepo;
import com.pprajapati.springsecurity.service.ActivityLogService;
import org.springframework.stereotype.Service;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
  private final ActivityLogRepo activityLogRepo;

  public ActivityLogServiceImpl(ActivityLogRepo activityLogRepo) {
    this.activityLogRepo = activityLogRepo;
  }

  @Override
  public void save(ActivityLog a) {
    activityLogRepo.save(a);
  }
}
