package com.mycompany.app.main;

import org.hibernate.internal.util.collections.ArrayHelper;

import java.util.Arrays;

public class TestMain {
    public static void main(String[] args) {
        int[] batchSizes = ArrayHelper.getBatchSizes(25);
        System.out.println(Arrays.toString(batchSizes));
    }
}
