package com.custom;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreDTO {
    private String 가맹점명;
    private String 프랜차이즈명;
    private String 배달가능여부;
    private Integer 좋아요수;
}
