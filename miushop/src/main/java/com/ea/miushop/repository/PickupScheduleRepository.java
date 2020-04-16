package com.ea.miushop.repository;

import com.ea.miushop.domain.PickupSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupScheduleRepository extends JpaRepository<PickupSchedule, Long> {
}
