package com.example.quickSort;

import org.springframework.stereotype.Service;

@Service
public class QuickSort {

    public void sort(int[] array, int low, int high) {
        if (low < high) {
            // パーティションを作成し、ピボットのインデックスを取得
            int pivotIndex = partition(array, low, high);
            // ピボットを基準に再帰的にソート
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // ピボットを配列の最後の要素に設定
        int i = low - 1; // 小さい要素のインデックス

        System.out.println("ピボット: " + pivot + " (array[" + high + "])");

        for (int j = low; j < high; j++) {
            System.out.println("  j: " + j + ", array[j]: " + array[j]);
            if (array[j] <= pivot) {
                i++;
                // 要素を交換
                swap(array, i, j);
                System.out.println("    swap: array[" + i + "] <-> array[" + j + "]");
            }
        }
        // ピボットを正しい位置に移動
        swap(array, i + 1, high);
        System.out.println("  swap: array[" + (i + 1) + "] <-> array[" + high + "] (ピボットの移動)");

        // 途中経過を表示
        System.out.print("途中経過: ");
        printArray(array);
        return i + 1; // ピボットのインデックスを返す
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}