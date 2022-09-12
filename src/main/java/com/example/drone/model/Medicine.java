package com.example.drone.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
@Getter
public class Medicine {
    @NotBlank(message ="Name cannot be null")
    @Pattern(regexp = "[_A-Z0-9a-z]+(_[A-Za-z0-9]+)*$")
    private String name;
    private double weight;
    @Pattern(regexp = "[_A-Z0-9]+(_[A-Z]+)*$")
    private String code;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String image;
}
