package com.ea.miushop.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pickup_schedule")
public class PickupSchedule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pickupScheduleId;

    private LocalDate pickupDate;

    @OneToMany(mappedBy = "pickupSchedule")
    private List<PickupTime> pickupTimes;

    public PickupSchedule() {
    }

    public Long getPickupScheduleId() {
        return pickupScheduleId;
    }

    public void setPickupScheduleId(Long pickupScheduleId) {
        this.pickupScheduleId = pickupScheduleId;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public List<PickupTime> getPickupTimes() {
        return pickupTimes;
    }

    public void setPickupTimes(List<PickupTime> pickupTimes) {
        this.pickupTimes = pickupTimes;
    }
}
