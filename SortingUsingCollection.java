package Week3Assignment1;

import java.util.*;


public class SortingUsingCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	//	String[] array1 = new String[]{"Google","Microsoft","TestLeaf","Maverick"};
		
		List<String> list1 = new ArrayList<String>();
		
		list1.add("Google");
		list1.add("Microsoft");
		list1.add("TestLeaf");
		list1.add("Maverick");
		
		int sizeofList1 = list1.size();
		System.out.println("Size of List" + sizeofList1);
		
		Collections.sort(list1);
		Collections.reverse(list1);
		
		System.out.println(list1);		
		
	
		
				
		
		
		
		
	}

}
