package Conversions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConversionFromOneTypeToAnotherType {
	public static void main(String[] args) {

		// 25) convert given list of strings in to array of strings.

		// 25) convert given list of strings in to Map.

		// 26) convert given Map in to List.

		List<String> list = Arrays.asList("P", "A", "XYZ", "AA", "88", "C", "DDD", "DODDD", "m", "boys");

		// List<String> listl = List.of("P", "A", "XYZ", "AA", "BB", "C", "DDD",
		// "DDDDD",
		// "m", "boys ");

		// 1. convert given list of strings in to array of strings. (List In To Array)

		String[] convertListInToStringArray = list.stream().toArray(String[]::new);

		//System.out.println("convertListInToStringArray:" + Arrays.toString(convertListInToStringArray));

		// 2.convert given list of strings in to Map. (List In To Map)

		List<String> fruits = Arrays.asList("apple", "banana", "citrus", "manogo", "guava");

		// IntStream produces primitive int,Map requires Integer boxed() converts int →
		// Integer
		Map<Integer, String> ConvertListInToMap = IntStream.range(0, fruits.size()).boxed()
				.collect(Collectors.toMap(i -> i + 1, fruits::get));

		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < fruits.size(); i++) {
			map.put(i + 1, fruits.get(i));
		}
		//System.out.println("list to map is::" + map);

		//System.out.println("ConvertListInToMap ::" + ConvertListInToMap);

		Map<Object, Object> ConvertlistInToMap1 = fruits.stream()

				.collect(Collectors.toMap(i -> i.toString().substring(0, 1), x -> x));

		//System.out.println("ConvertListInToMap ::" + ConvertListInToMap);

		//System.out.println("ConvertListInToMap111111" + ConvertlistInToMap1);

		Map<Object, Object> ConvertListInToMap2 = fruits.stream().collect(Collectors.toMap(x -> x, x -> x.length()));

		//System.out.println("ConvertListInToMap:::" + ConvertListInToMap2);

		// 3. convert given Map in to List. (Map in to List)

		Map<String, Long> mapAsOutput = list.stream()
				.collect(Collectors.groupingBy(x -> x.toLowerCase(), TreeMap::new, Collectors.counting()));

		System.out.println("mapAsOutput" + mapAsOutput);

		// TreeMlap will give in alphabetical order where as LinkedHashMap will give
		// insertion order(it preserves the order) // here above i am getting map as
		// output i will convert this map in to List.

		List<List<Long>> converMapToList = Arrays
				.asList(mapAsOutput.entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList()));

		System.out.println("converMapToList::" + converMapToList);
		// Generate 10 Random numbers

		Random rand = new Random();

		Stream.generate(rand::nextInt).limit(10).map(x -> x * 100).forEach(x -> System.out.println(x));

	}
}
