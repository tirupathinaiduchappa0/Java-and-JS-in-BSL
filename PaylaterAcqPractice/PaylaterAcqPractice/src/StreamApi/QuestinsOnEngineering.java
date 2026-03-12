package StreamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestinsOnEngineering {

	public static void main(String[] args) {

		List<Engineering> list = new ArrayList<>();

		Engineering e1 = new Engineering("Ramu", "HR", "manager", 50000);

		Engineering e2 = new Engineering("Ramu", "IT", "Developer", 50000);

		Engineering e3 = new Engineering("Ramu", "MECH", "manager", 50000);

		Engineering e4 = new Engineering("Ramu", "FLM", "Lead", 50000);

		Engineering e5 = new Engineering("Ramu", "IT", "support", 50000);

		Engineering e6 = new Engineering("Ramu", "HR", "Executive", 50000);

		list.add(e1);

		list.add(e2);

		list.add(e3);

		list.add(e4);

		list.add(e5);

		list.add(e6);

		Map<Object, List<Object>> PositionsinEachDept = list.stream().collect(
				Collectors.groupingBy(x -> x.getDept(), Collectors.mapping(x -> x.getRole(), Collectors.toList())));

		System.out.println("PositionsinEachDept:::::" + PositionsinEachDept);
	}

}
