package com.learn.app.service;

/**
 * x_n = (a * x_(n-1) + c) % m
 *
 * where:
 * x_n — the next number in the sequence
 * x_(n-1) — the previous number in the sequence
 * a is the multiplication coefficient
 * c is the shift coefficient
 * m is the modulus
 * */
public class RandomServiceImpl implements RandomService {

    private double last;
    public RandomServiceImpl() {
        last = (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    @Override
    public Integer randomNumber() {

        last = (last * 32719 + 3) % 32749;
        return 0;//last % Integer.MAX_VALUE;
    }

    @Override
    public Integer randomNumber(int start, int end) {

        last = (last * 32719 + 3) % 32749;

        return (int)((last % Integer.MAX_VALUE) * (end - start)) + start;
    }


    public static class SimpleRandom {
        int max;
        int last;

    }
}
