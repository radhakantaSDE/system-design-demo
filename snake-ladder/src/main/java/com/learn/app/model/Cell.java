package com.learn.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cell {

    private int cellNumber;
    private Move specialMove;
}
