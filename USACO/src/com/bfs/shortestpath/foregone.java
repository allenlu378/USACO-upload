
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	static int num;
	static int tempNum, mid, numAns = 1;

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("A-small.in"));
		File file = new File("A-small.out");
		PrintWriter out = new PrintWriter(file);
		StringTokenizer st = new StringTokenizer(f.readLine());
		num = Integer.parseInt(st.nextToken());
		// Scanner in = new Scanner(new BufferedReader(new
		// InputStreamReader(System.in)));
		// num = in.nextInt();
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(f.readLine());
			tempNum = Integer.parseInt(st.nextToken());
			// tempNum = in.nextInt();

			mid = tempNum / 2;
			for (int j = 1; j < mid; j += 1) {
				if (check4(j) && check4(tempNum - j)) {
					System.out.println("Case #" + numAns + ": " + j + " " + (tempNum - j));

					numAns++;
					break;
				}
			}

		}
	}

	public static boolean check4(int numb) {
		String str = String.valueOf(numb);
		if (str.indexOf('4') == -1) {
			return true;

		} else {
			return false;
		}

	}

}
