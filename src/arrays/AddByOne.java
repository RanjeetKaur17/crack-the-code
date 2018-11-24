package arrays;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author ranjeetkaur
 */
public class AddByOne {
	
	//Main Function
	public static void main(String[] args) {

		//Sample Input
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(new Integer[] { 9,9,8,7 }));
		
		//Call function on sample value
		ArrayList<Integer> b = addByOne(a);

		//Print Output
		System.out.println(b);
	}

	//Function to Add one to a number represented by an arrayList
	private static ArrayList<Integer> addByOne(ArrayList<Integer> a) {
		
		//Reverse the array, so that carry can be appended to start of the original number
		reverse(a);
		
		//Initialize carry with the value to be added, i.e., one
		int carry = 1;
		
		//Add 1 to the given number
		for (int i = 0; i < a.size(); i++) {
				int val = a.get(i);
			 	a.set(i, (val + carry)%10);
				carry = (val + carry)/10;
			if(carry == 0) {
				break;
			}
		}
		
		//Add overflowing carry
		if (carry == 1){
			a.add(1);
		}
		
		//Reverse to get value in original format
		reverse(a);
		return a;
	}

	//Function to reverse the ArrayList
	private static void reverse(ArrayList<Integer> a) {
		for (int i = 0; i < a.size() / 2; i++) {
			int temp = a.get(i);
			a.set(i, a.get(a.size() - i - 1));
			a.set(a.size() - i - 1, temp);
		}

	}
}
