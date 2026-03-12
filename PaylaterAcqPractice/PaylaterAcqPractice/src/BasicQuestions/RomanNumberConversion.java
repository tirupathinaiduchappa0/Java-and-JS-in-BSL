package BasicQuestions;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumberConversion {

	public static void main(String[] args) {

		int inputNumber = 1700;

		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder roman = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (inputNumber >= values[i]) {
				roman.append(symbols[i]);
				inputNumber -= values[i];
			}
		}

		System.out.println("Roman number is: " + roman);

		int inputNumber1 = 2700;
		
		//You must need to use LinkedHashMap, else will staj overflow error.

		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");

		StringBuilder roman1 = new StringBuilder();

		for (Map.Entry<Integer, String> entry : map.entrySet()) {
		    while (inputNumber1 >= entry.getKey()) {
		        roman1.append(entry.getValue());
		        inputNumber1 -= entry.getKey();
		    }
		}

		System.out.println("Roman number is: " + roman1);


	}

}
