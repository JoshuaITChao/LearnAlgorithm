package com.joshua;

import java.util.Arrays;

import com.joshua.sort.Sort;
import com.joshua.sort.cmp.BubbleSort1;
import com.joshua.sort.cmp.BubbleSort2;
import com.joshua.sort.cmp.BubbleSort3;
import com.joshua.sort.cmp.HeapSort;
import com.joshua.sort.cmp.InsertionSort1;
import com.joshua.sort.cmp.InsertionSort2;
import com.joshua.sort.cmp.InsertionSort3;
import com.joshua.sort.cmp.MerageSort;
import com.joshua.sort.cmp.SelectionSort;
import com.joshua.tools.Asserts;
import com.joshua.tools.Integers;

@SuppressWarnings({"rawtypes", "unchecked", "unused"})
public class Main {

	public static void main(String[] args) {
		
		Integer[] array = Integers.random(1000, 1, 100000);
		
		testSorts(array, 
				new BubbleSort1(),
				new BubbleSort2(),
				new BubbleSort3(),
				new SelectionSort(),
				new InsertionSort1(),
				new InsertionSort2(),
				new InsertionSort3(),
				new HeapSort(),
				new MerageSort()
				);
		

	}
	
	static void testSorts(Integer[] array, Sort... sorts) {
		for (Sort sort : sorts) {
			Integer[] newArray = Integers.copy(array);
			sort.sort(newArray);
			Asserts.test(Integers.isAscOrder(newArray));
		}
		Arrays.sort(sorts);
		
		for (Sort sort : sorts) {
			System.out.println(sort);
		}
	}

}
