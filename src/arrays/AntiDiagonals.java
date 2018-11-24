package arrays;

import java.util.Arrays;
import java.util.ArrayList;

/**
 * @author ranjeetkaur
 */
public class AntiDiagonals {

	//Main Function
	public static void main(String[] args) {
		
		//Sample Input
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(new ArrayList<>(Arrays.asList(new Integer[] { 1, 2, 3 })));
		a.add(new ArrayList<>(Arrays.asList(new Integer[] { 4, 5, 6 })));
		a.add(new ArrayList<>(Arrays.asList(new Integer[] { 7, 8, 9 })));
		
		//Call function on sample value
		ArrayList<ArrayList<Integer>> b = antiDiagonals(a);
		
		//Print Output
		System.out.println(b);
	}
	
	//Function to print anti diagonals of a 2-D Matrix
	public static ArrayList<ArrayList<Integer>> antiDiagonals(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		//Initialize the length and counter of output array
		int counter = 0; 
		int size = a.size() + a.size() - 1;
		
		//Initialize output array
		for(int i = counter; i < size; i++) {
			ans.add(new ArrayList<>());
		}
		
		//Parse the array to read as anti diagonals
		for(int i = 0; i < a.size(); i++) {
			int tempi = i;
			int tempj = 0;
			int j = counter;
			while(j < size) {
				while(tempj < a.size() - i) {
					ans.get(j).add(a.get(tempi).get(tempj));
					tempj++;
					j++;
				}
				tempi++;
				tempj--;
				while(tempi < a.size()) {
					ans.get(j).add(a.get(tempi).get(tempj));
					tempi++;
					j++;
				}
				counter++;
				size--;
			}
		}
		
		return ans;
	}
}
