package com.example.quickSort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickSortApplication implements CommandLineRunner {

	@Autowired
	private QuickSort quickSort;

	public static void main(String[] args) {
		SpringApplication.run(QuickSortApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		int[] array = { 12, 34, 54, 2, 3 };
		System.out.println("初期配列:");
		quickSort.printArray(array);
		System.out.println("ソート中の配列の状態:");
		quickSort.sort(array, 0, array.length - 1);
		System.out.println("ソート後の配列:");
		quickSort.printArray(array);
	}
}