
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CrepeCart {
	static int num;
	static int numP, max;
	static int[][] grid;
	static int curHigh = 0;
	static int ansX, ansY;

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		num = in.nextInt();
		for (int i = 0; i < num; i++) {
			numP = in.nextInt();
			max = in.nextInt() + 1;
			grid = new int[max][max];
			for (int j = 0; j < numP; j++) {
				fill(in.nextInt(), in.nextInt(), in.next());
			}
			findAns();
			System.out.println("Case #" + (i + 1) + ": " + ansY + " " + ansX);
			curHigh = 0;
		}
	}

	public static void findAns() {
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (grid[j][i] > curHigh) {
					curHigh = grid[j][i];
					ansX = j;
					ansY = i;
				}
			}
		}
	}

	public static void fill(int y, int x, String d) {
		if (d.equals("N")) {
			for (int i = x + 1; i < max; i++) {
				for (int j = 0; j < max; j++) {
					grid[i][j]++;
				}
			}
			return;
		} else if (d.equals("E")) {
			for (int i = y + 1; i < max; i++) {
				for (int j = 0; j < max; j++) {
					grid[j][i]++;
				}
			}
			return;
		} else if (d.equals("S")) {
			for (int i = x - 1; i >= 0; i--) {
				for (int j = 0; j < max; j++) {
					grid[i][j]++;
				}
			}
			return;
		} else if (d.equals("W")) {
			for (int i = y - 1; i >= 0; i--) {
				for (int j = 0; j < max; j++) {
					grid[j][i]++;
				}
			}
			return;
		}
	}

}
