package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ranjeetkaur
 */
public class CommonElementInsSortedArrays {

	public static void main(String[] args) {
		Integer[] A = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Integer[] B = new Integer[] { 2, 6, 8, 9 };
		Integer[] C = new Integer[] { 1, 2, 4, 6, 9 };
		System.out.println(getCommons(Arrays.asList(A), Arrays.asList(B), Arrays.asList(C)));
	}

	private static List<Integer> getCommons(List<Integer> A, List<Integer> B, List<Integer> C) {
		List<Integer> X = new ArrayList<>();

		int a=0,b=0,c=0;
		while (a < A.size() && b < B.size() && c < C.size()) {
			if (A.get(a) < B.get(b) && A.get(a) < C.get(c)) {
				a++;
			} else if (B.get(b) < A.get(a) && B.get(b) < C.get(c)) {
				b++;
			} else if (C.get(c) < A.get(a) && C.get(c) < A.get(a)) {
				c++;
			} else if (A.get(a) == B.get(b) && A.get(a) < C.get(c)) {
				a++;
				b++;
			} else if (A.get(a) == C.get(c) && A.get(a) < B.get(b)) {
				a++;
				c++;
			} else if (C.get(c) == B.get(b) && B.get(b) < A.get(a)) {
				c++;
				b++;
			}
			if (A.get(a) == B.get(b) && B.get(b) == C.get(c)) {
				X.add(A.get(a));
				a++;
				b++;
				c++;
			}
		}

		return X;
	}
}
