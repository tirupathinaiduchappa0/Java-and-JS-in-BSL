package BasicQuestions;

import java.util.*;

public class devexampl {

    public static void main(String[] args) {

    	List<Integer> li = new ArrayList<>(Arrays.asList(12, 29, 34, 4, 51));

    	for(int i = 0; i < li.size(); i++) {
    	    for(int j = i + 1; j < li.size(); j++) {
    	        if (li.get(i) > li.get(j)) {
    	            int temp = li.get(i);
    	            li.set(i, li.get(j));
    	            li.set(j, temp);
    	        }
    	    }
    	}

    	System.out.println(li);
        

        
        List<Integer> lis = List.of(10,20,30,40,50,60,70,80,90);
        Map<Integer,Integer> result = new HashMap<>();
        Set<Integer> compSet = new HashSet<>();
        int targetNum=100;
        for(int i :lis) {
        	int comp= targetNum-i;
        	if(compSet.contains(i)) {
        		result.put(i, comp);
        	}
        	compSet.add(comp);
        }
        System.out.println(result);
        
        List<Integer> lis1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> op = new ArrayList<>();

        for(int i = 0; i < lis1.size(); i++) {
            int prd = 1;   // ✅ move here

            for(int j = 0; j < lis1.size(); j++) {
                if(i != j) {
                    prd = prd * lis1.get(j);
                }
            }

            op.add(prd);   // ✅ add once per i
        }

        System.out.println(op);
        
    }
}