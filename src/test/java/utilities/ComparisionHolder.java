package utilities;

import java.util.ArrayList;
import java.util.HashMap;

public class ComparisionHolder {
	
	private static HashMap<String ,ArrayList<String>> comparedVarialbes = new HashMap<String, ArrayList<String>>();
	private static int counter = 0;

	public static HashMap<String ,ArrayList<String>> getComparedVarialbes() {
		return comparedVarialbes;
	}

	public static  String setComparedVarialbes(String type, String Expected, String Actual) {
		
		ArrayList<String> holder = new ArrayList<String>();
		holder.add(type);
		holder.add(Expected);
		holder.add(Actual);
		
		counter++;
		
		comparedVarialbes.put("error - " + counter, holder);
		
		return "error - " + counter;
	}

}
