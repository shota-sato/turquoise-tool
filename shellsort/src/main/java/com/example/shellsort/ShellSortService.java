package com.example.shellsort;

import org.springframework.stereotype.Service;

@Service
public class ShellSortService {

    public void sort(int[] array) {
        int n = array.length;

        // ギャップを設定
        for (int gap = n / 2; gap > 0; gap /= 2) {
            System.out.println("ギャップ: " + gap);
            // ギャップに基づいて挿入ソートを行う
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;

                System.out.println("i: " + i + ", temp: " + temp);

                // ギャップを考慮して要素を移動
                // j 　現在の要素を挿入する位置
                //j が gap 以上である限りループを続けます
                //array[j - gap] > temp：現在の要素（temp）と、ギャップを考慮した位置にある要素（array[j - gap]）を比較
                //j -= gap j をギャップ分だけ減らします。これにより、次の要素（ギャップを考慮した位置）に移動
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    System.out.println("  j: " + j + ", array[j - gap]: " + array[j - gap]);
                    array[j] = array[j - gap];
                }
                array[j] = temp;

                // 途中経過を表示
                System.out.print("途中経過: ");
                printArray(array);
            }
        }
    }

    public void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}