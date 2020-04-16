package com.ea.miushop.repository;

import com.ea.miushop.domain.PickupTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupTimeRepository extends JpaRepository<PickupTime, Long> {
}
