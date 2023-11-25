package com.learn.app;

import com.learn.app.service.RandomService;
import com.learn.app.service.RandomServiceImpl;

import java.util.stream.IntStream;

public class RandomVerifier {

    public static void main(String[] args) {

        final RandomService randomService = new RandomServiceImpl();

        IntStream.range(1, 10).forEach(e -> System.out.println(randomService.randomNumber(5, 10)));
    }
}
