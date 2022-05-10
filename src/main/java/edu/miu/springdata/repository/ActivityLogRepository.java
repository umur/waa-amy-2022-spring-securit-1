package edu.miu.springdata.repository;

import edu.miu.springdata.entity.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepository extends CrudRepository<ActivityLog, Long> {
}
