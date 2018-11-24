package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ranjeetkaur
 */
public class CountDistinctNumbersInWindow {

	public static void main(String[] args) {
		int[] A = new int[] { 1, 2, 1, 3, 4, 2, 3 };
		ArrayList<Integer> B = new ArrayList<Integer>();
		B.addAll(Arrays.asList(new Integer[] { 1, 2, 1, 3, 4, 2, 3 }));

		System.out.println(Arrays.toString(countDistincts(A, 3)));
		System.out.println(dNums(B, 3));
	}

	public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
		ArrayList<Integer> distincts = new ArrayList<>();

		Map<Integer, Integer> cMap = new TreeMap<>();

		for (int i = 0; i < B; i++) {
			if (cMap.containsKey(A.get(i))) {
				cMap.put(A.get(i), cMap.get(A.get(i)) + 1);
			} else {
				cMap.put(A.get(i), 1);
			}
		}
		distincts.add(cMap.values().size());

		for (int i = B; i < A.size(); i++) {

			int firstCount = cMap.get(A.get(i - B));
			if (firstCount == 1) {
				cMap.remove(A.get(i - B));
			} else {
				cMap.put(A.get(i - B), firstCount - 1);
			}

			if (cMap.containsKey(A.get(i))) {
				cMap.put(A.get(i), cMap.get(A.get(i)) + 1);
			} else {
				cMap.put(A.get(i), 1);
			}
			distincts.add(cMap.values().size());

		}

		return distincts;
	}

	private static int[] countDistincts(int[] A, int k) {
		if (k > A.length) {
			k = A.length;
		}

		int[] countsArr = new int[A.length - k + 1];
		Map<Integer, Integer> cMap = new HashMap<>();

		for (int i = 0; i < k; i++) {
			if (cMap.containsKey(A[i])) {
				cMap.put(A[i], cMap.get(A[i]) + 1);
			} else {
				cMap.put(A[i], 1);
			}

			countsArr[0] = cMap.values().size();
		}
		for (int i = k; i < A.length; i++) {

			int firstCount = cMap.get(A[i - k]);
			if (firstCount == 1) {
				cMap.remove(A[i - k]);
			} else {
				cMap.put(A[i - k], firstCount - 1);
			}

			if (cMap.containsKey(A[i])) {
				cMap.put(A[i], cMap.get(A[i]) + 1);
			} else {
				cMap.put(A[i], 1);
			}
			countsArr[i - k + 1] = cMap.values().size();

		}
		return countsArr;
	}
}
