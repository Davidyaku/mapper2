package org.example.entities;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MaryEntity {
    private Integer integer;
    private String string;
    private Long aLong;
    private Number number;
    private Structure structure2;
}
