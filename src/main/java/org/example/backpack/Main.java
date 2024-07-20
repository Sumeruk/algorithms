package org.example.backpack;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

//Задача о рюкзаке
//

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int W = Integer.parseInt(tokenizer.nextToken());



    }

    private static int getMaxCostInBackpack(int[] weights, int[] prices, int W){
        int maxCostOfBackpack = 0;
        int amount = weights.length;
        int[][] m = new int[weights.length + 1][W + 1];

        for (int j = 0; j < W + 1; j++){
            m[0][j] = 0;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 1; j <= W ; j++) {
                if (weights[i - 1] > j){
                    //вес нового товара больше того, что может поместиться в рюкзак
                    m[i][j] = m[i - 1][j];
                } else {
                    //стоимость товара в рюкзаке + стоимость следующего товара, который может поместиться в рюкзак
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - weights[i - 1]] + prices[i - 1]);
                }

                if (maxCostOfBackpack < m[i][j]){
                    maxCostOfBackpack = m[i][j];
                }
            }
        }

        return maxCostOfBackpack;
    }
}
