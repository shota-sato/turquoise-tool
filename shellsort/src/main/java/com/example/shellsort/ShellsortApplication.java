package com.example.shellsort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShellsortApplication implements CommandLineRunner {

    @Autowired
    private ShellSortService shellSort;

    public static void main(String[] args) {
        SpringApplication.run(ShellsortApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int[] array = {22, 54, 2, 3, 11, 17,20};
        System.out.println("初期配列:");
        shellSort.printArray(array);
        System.out.println("ソート中の配列の状態:");
        shellSort.sort(array);
        System.out.println("ソート後の配列:");
        shellSort.printArray(array);
    }
}

