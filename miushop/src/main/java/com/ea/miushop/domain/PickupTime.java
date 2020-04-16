package com.ea.miushop.domain;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "pickup_time")
public class PickupTime {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pickupTimeId;

    private LocalTime pickupTime;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "pickup_schedule_id")
    private PickupSchedule pickupSchedule;

    public PickupTime() {
    }

    public Long getPickupTimeId() {
        return pickupTimeId;
    }

    public void setPickupTimeId(Long pickupTimeId) {
        this.pickupTimeId = pickupTimeId;
    }

    public LocalTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public PickupSchedule getPickupSchedule() {
        return pickupSchedule;
    }

    public void setPickupSchedule(PickupSchedule pickupSchedule) {
        this.pickupSchedule = pickupSchedule;
    }
}
