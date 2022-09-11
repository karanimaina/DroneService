package com.example.drone.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
   @Id
   @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "created+on",updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Africa/Nairobi")
    public Date created_on;
    @Column(name = "softDelete")
    @JsonIgnore
    public boolean softDelete;
    @PrePersist
    public void addData(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        ZoneId zoneId  = ZoneId.of("Africa/Nairobi");
        ZonedDateTime nairobi =  zonedDateTime.withZoneSameInstant(zoneId);
        this.created_on = Date.from(nairobi.toInstant());
        this.softDelete = false;
    }



}
