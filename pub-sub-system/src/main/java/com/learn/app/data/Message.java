package com.learn.app.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message<V> {
    private String key;
    private V payload;
}
