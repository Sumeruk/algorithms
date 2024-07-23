package ru.zinchenko.slideWindow;

import java.util.Arrays;

//Для массива, состоящего из n целых чисел, найдите непрерывный подмассив заданной длины k,
//который имеет максимальное среднее значение.
//Нужно вывести максимальное среднее значение.
public class SlideWindow {
    public static void main(String[] args) {
        int k = 2;
        int[] n = {1, 12, -5, -6, 50, 13};
        int res = 0, sum = 0;

        for (int i = 0; i < k; i++) {
            sum += n[i];
        }

        for (int i = k; i < n.length; i++) {
            sum = sum + n[i] - n[i - k];
            res = Math.max(sum, res);
        }

        System.out.println((double) res / k);


    }


}
