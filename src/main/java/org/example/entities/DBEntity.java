package org.example.entities;

import lombok.*;

@Data
@Setter
@Getter
@Builder
@AllArgsConstructor
public class DBEntity {
    private Integer integer;
    private String string;
    private Long aLong;
    private Number number;
    private Structure structure;
}
