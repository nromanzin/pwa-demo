package fr.nromanzin.pwademo.controller.dto;

import lombok.Data;

@Data
public class GetItemDTO {
    private String uuid;
    private String name;
    private int quantity;
}
