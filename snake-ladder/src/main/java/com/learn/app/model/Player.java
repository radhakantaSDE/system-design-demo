package com.learn.app.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {

    private String playerName;
    private Integer playerCellNumber;
}
