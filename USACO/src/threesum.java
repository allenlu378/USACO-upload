import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
ID: allenlu2
LANG: JAVA
TASK: threesuma
*/
public class threesum {
	static int arrlen, numq, ans = 0;
	static int[] arr, sect;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("threesum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
		arrlen = in.nextInt();
		arr = new int[arrlen];
		numq = in.nextInt();
		for (int i = 0; i < arrlen; i++) {
			arr[i] = in.nextInt();
		}

		for (int i = 0; i < numq; i++) {
			sect = Arrays.copyOfRange(arr, in.nextInt() - 1, in.nextInt());
			quickSort(sect, 0, sect.length - 1);
			find3(sect, sect.length);
			System.out.println(ans);
			ans = 0;
		}
		out.close();
	}

	static void find3(int arr[], int n) {
		boolean found = false;

		for (int i = 0; i < n - 1; i++) {
			// Find all pairs with sum equals to
			// "-arr[i]"
			HashSet<Integer> s = new HashSet<Integer>();

			for (int j = i + 1; j < n; j++) {
				int x = -(arr[i] + arr[j]);
				if (s.contains(x)) {
					ans++;
					found = true;
				} else {

					s.add(arr[j]);
				}
			}
		}

		if (found == false) {

			System.out.printf("No Triplet Found\n");
			System.out.printf("No triplet found\n");
			System.out.printf("No triplet found\n");

		}
	}

	static int partition(int A[], int si, int ei) {
		int x = A[ei];
		int i = (si - 1);
		int j;

		for (j = si; j <= ei - 1; j++) {
			if (A[j] <= x) {
				i++;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp = A[i + 1];
		A[i + 1] = A[ei];
		A[ei] = temp;
		return (i + 1);
	}

	static void quickSort(int A[], int si, int ei) {
		int pi;

		/* Partitioning index */
		if (si < ei) {
			pi = partition(A, si, ei);
			quickSort(A, si, pi - 1);
			quickSort(A, pi + 1, ei);
		}
	}

}
