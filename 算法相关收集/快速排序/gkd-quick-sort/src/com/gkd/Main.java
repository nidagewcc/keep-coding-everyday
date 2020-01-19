package com.gkd;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {21, 32, 43, 98, 54, 45, 23, 4, 66, 86};

        quickSort(arr, 0, 9);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {

        // 基准数，取左边第一个元素为基准数
        int temp = arr[0];
        int i = left, j = right;

        while (i < j) {
            if (temp >= arr[j]) {
                arr[i] = arr[j];
                arr[j] = temp;

                j--;
            }
        }

        while (i < j) {
            if (arr[i] > temp) {
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

    }
}
