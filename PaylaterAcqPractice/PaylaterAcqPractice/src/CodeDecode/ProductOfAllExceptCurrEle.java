package CodeDecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ProductOfAllExceptCurrEle {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

		List<Integer> output = list.stream().map(i -> list.stream().filter(j -> j != i).reduce(1, (a, b) -> a * b))
				.toList();
		System.out.println("output is:::" + output);

		List<Integer> outputList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			int product = 1;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(i) != list.get(j))
					product *= list.get(j);
			}
			outputList.add(product);
		}

		System.out.println("outputList:::" + outputList);

		int[] arrr = {};
		List<Integer> lis = new ArrayList<>(List.of(1, 2, 3, 2));
		List<Integer> op1 = new ArrayList<>();
		// FactSet company asked this using dupslicates and using for loops only

		for (int i = 0; i < lis.size(); i++) {
			int prod = 1;
			for (int j = 0; j < lis.size(); j++) {
				if (i != j) {
					prod *= lis.get(j);
				}
			}
			op1.add(prod);
		}
		System.out.println(":op is:::::::" + op1);

		int[] arr1 = { 1, 2, 3, 4, 5 };

		int[] opt = new int[arr1.length];

		for (int i = 0; i < arr1.length; i++) {
			int product = 1;
			for (int j = 0; j < arr1.length; j++) {
				// we are checking value here, not the index
				if (arr1[i] != arr1[j]) {
					product *= arr1[j];
				}
			}
			opt[i] = product;
		}

		System.out.println("optttt is:::::::" + Arrays.toString(opt));

		int[] output1 = Arrays.stream(arr1).map(x -> Arrays.stream(arr1).filter(j -> j != x).reduce(1, (a, b) -> a * b))
				.toArray();

		System.out.println("output" + Arrays.toString(output1));

		int[] ar = { 1, 2, 3, 2 };
		// FactSet company asked this using dupslicate nue and using for loops only

		int[] op = new int[ar.length];

		for (int k = 0; k < ar.length; k++) {
			int product1 = 1;
			for (int j = 0; j < ar.length; j++) {
				// we are checking index here, not the value
				if (k != j) {
					product1 *= ar[j];
				}
			}
			op[k] = product1;
		}

		System.out.println("op is:::" + Arrays.toString(op));
	}

}
