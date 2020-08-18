
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	static int num, size, curX = 0, curY, ansNum = 1;
	static int[][] maze;
	static String ans = "";

	public static void main(String[] args) throws IOException {
		/*
		 * BufferedReader f = new BufferedReader(new FileReader("A-small.in")); File
		 * file = new File("A-small.out"); PrintWriter out = new PrintWriter(file);
		 * StringTokenizer st = new StringTokenizer(f.readLine()); num =
		 * Integer.parseInt(st.nextToken());
		 */

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		num = in.nextInt();
		for (int i = 0; i < num; i++) {
			// st = new StringTokenizer(f.readLine());
			// size = Integer.parseInt(st.nextToken());
			size = in.nextInt();
			curY = size - 1;
			maze = new int[size][size];
			maze[size - 1][0] = 1;
			// st = new StringTokenizer(f.readLine());
			// String dir = st.nextToken();
			String dir = in.next();
			fill(dir);
			if (maze[1][size - 1] == 1) {
				for (int j = 0; j < 2 * (size - 1); j++) {
					if (curX == size - 1) {
						curY--;
						ans += "S";
						continue;
					}
					if (curY == 0) {
						curX++;
						ans += "E";
						continue;
					}
					if (maze[curY][curX] == 1 && dir.charAt(j) == 'S') {
						curX++;
						ans += "E";
						continue;
					} else if (maze[curY][curX] == 1 && dir.charAt(j) == 'E') {
						curY--;
						ans += "S";
						continue;
					} else {
						curY--;
						ans += "S";
						continue;
					}
				}
			} else {
				for (int j = 0; j < 2 * (size - 1); j++) {
					if (curX == size - 1) {
						curY--;
						ans += "S";
						continue;
					}
					if (curY == 0) {
						curX++;
						ans += "E";
						continue;
					}
					if (maze[curY][curX] == 1 && dir.charAt(j) == 'S') {
						curX++;
						ans += "E";
						continue;
					} else if (maze[curY][curX] == 1 && dir.charAt(j) == 'E') {
						curY--;
						ans += "S";
						continue;
					} else {
						curX++;
						ans += "E";
						continue;
					}
				}
			}

			// tempNum = in.nextInt();
			System.out.println("Case #" + ansNum + ": " + ans);
			ansNum++;
			ans = "";
			curX = 0;

		}
	}

	public static void fill(String dir) {
		int curX = 0, curY = size - 1;
		for (int i = 0; i < 2 * (size - 1); i++) {
			if (dir.charAt(i) == 'S') {
				curY--;
				maze[curY][curX] = 1;

			} else {
				curX++;
				maze[curY][curX] = 1;
			}
		}
	}

}
