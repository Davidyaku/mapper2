package org.example.entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Structure {
    private String name;
    private List<Integer> list;
}
