package com.example.drone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.beans.JavaBean;

@Getter
@Setter
@Builder
@Table(name="tb_delivery_load")
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryLoad extends BaseEntity {
    @ManyToOne
    private  Medicine medicine;
    private int count;
    @ManyToOne
    @JsonIgnore
    private Delivery delivery;
}
