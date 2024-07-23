package ru.zinchenko.strings;

import java.util.Arrays;

// z - функция
// длина наибольшего общего префикса строки и ее суффикса
public class zFunction {
    public static void main(String[] args) {
        //String s = "dbcabc"; // нет ответа, тк d больше не встречается
        //String s = "abcabc"; // [0, 0, 0, 3, 0, 0], тк abc - совпадающая строка
        String s = "ab#abdababab"; //поиск количеста вхождений шаблона в строку (до #)
                                   //все позиции i в Z-массиве, для которых Z[i] равно длине шаблона P.
                                   //Эти позиции соответствуют вхождениям шаблона P в строку S.
        int n = s.length();
        int[] z = new int[n];
        int R = 0;
        int L = 0;
        for(int i = 1; i < n; i++) {
            z[i] = 0;
            if (R > i) {
                z[i] = Math.min(R - i, z[i - L]);
            }
            while (i + z[i] < n && s.charAt(i+z[i]) == s.charAt(z[i])) {
                z[i]++;
            }
            if (i + z[i] > R) {
                L = i;
                R = i + z[i];
            }
        }
        z[0] = 0;

        System.out.println(Arrays.toString(z));
    }
}
