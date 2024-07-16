package com.custom;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
    private int no;
    private String franchise;
    private String name;
    private String tel;
    private String address;
    private Integer weekdayOpen;
    private Integer weekendOpen;
    private boolean isDelivered;
    private Integer like;

}