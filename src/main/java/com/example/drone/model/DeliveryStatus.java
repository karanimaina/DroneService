package com.example.drone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;
public enum DeliveryStatus {
    LOADING,  DELIVERING, DELIVERED, RETURNING
}
