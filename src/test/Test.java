package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {
	public static void main(String...args) {
		List<String> list = new ArrayList<>();
		Integer[][] array = {{1,10}, {2,9}, {3,8}};

		Comparator<Integer[]> c = new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o2[0].compareTo(o1[0]);
			}
		};
		Arrays.sort(array, c);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i][0] + ":" + array[i][1]);
		}
	}
}
