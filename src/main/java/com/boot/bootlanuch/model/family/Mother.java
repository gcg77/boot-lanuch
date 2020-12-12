package com.boot.bootlanuch.model.family;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class Mother {
    private String[] names;
    @Min(18)
    private Integer age;
}
