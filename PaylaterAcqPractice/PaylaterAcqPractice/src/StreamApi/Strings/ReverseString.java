package StreamApi.Strings;

import java.util.Arrays;

public class ReverseString {
	public static void main(String[] args) {
		
		String[] array = {"ramu", "beemu", "somu", "seeta"};

		Arrays.stream(array).map(s->new StringBuilder(s).reverse()).forEach(x->System.out.println(x));

		String s= "somu";

		StringBuilder sbd = new StringBuilder(s).reverse();

		StringBuffer sbf = new StringBuffer(s).reverse();

		System.out.println(sbd + "" + sbf);

		//Reverse the string using for loop

		String ss = "somu";

		String[] strArr = ss.split("");

		String[] result = new String[strArr.length];

		int index = 0;

		for (int i = strArr.length-1; i >= 0; i--) {

		result[index] = strArr[i];

		index++;

		}

		System.out.println("reversedstr is:" + (String.join("", result)));
	}

}
