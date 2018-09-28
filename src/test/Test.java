package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

		Integer[] number = {1,2,3,4,5};
		List<Integer> nlist= Arrays.asList(number);
		list = Arrays.asList("111", "222", "333");
		list.stream().forEach(System.out::println);

		IntStream.rangeClosed(1, 5).forEach(System.out::println);

//		list.stream().map(s -> Integer.parseInt(s) * 10).forEach(System.out::println);

		list.stream().filter(s -> Integer.parseInt(s) > 200).forEach(System.out::println);

		List<Integer> nnlist = new ArrayList<>();
		nnlist = Arrays.asList(3,2,1,5,4);

		String str = nlist.stream()
						.filter(s -> s > 2)
						.sorted((s1,s2) -> s2 - s1)
						.map(s -> s.toString())
						.collect(Collectors.joining());

		String a = nnlist.stream()
				.min((s1,s2) -> s1 - s2)
				.toString();

		int[] nums = {3,2,1,5,4};
		System.out.println(IntStream.of(nums).sum());


//		nlist.stream().filter(s -> s > 2).sorted((s1,s2) -> s2 - s1).forEach(s -> nnlist.add(s));
		System.out.println(a);

	}
}
