

/*
ID: allenlu2
LANG: JAVA
TASK: time
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class time {
	static int ncity, nroad, ccost, maxProfit = 0;
	static int[] money;
	static LinkedList<Integer>[] conn;

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("time.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("time.out")));
		ncity = in.nextInt();
		money = new int[ncity];
		conn = new LinkedList[ncity];
		nroad = in.nextInt();
		ccost = in.nextInt();
		for (int i = 0; i < ncity; i++) {
			money[i] = in.nextInt();
			conn[i] = new LinkedList<Integer>();
		}
		for (int i = 0; i < nroad; i++) {
			conn[in.nextInt() - 1].add(in.nextInt() - 1);
		}

		for (int i = 0; i < conn[0].size(); i++) {
			curCity(conn[0].get(i), 1, 0);
		}
		out.print(maxProfit);
		out.close();
	}

	public static void curCity(int city, int day, int cmoney) {
		if (city == 0) {
			for (int i = 0; i < 10000; i++) {
				if ((cmoney * (i + 1)) - ((ccost * (day) * (day)) * ((i + 1) * (i + 1))) > maxProfit) {
					maxProfit = (cmoney * (i + 1)) - ((ccost * (day) * (day)) * ((i + 1) * (i + 1)));
				} else {
					break;
				}
			}
			return;

		}
		for (int i = 0; i < conn[city].size(); i++) {
			curCity(conn[city].get(i), day + 1, cmoney + money[city]);
		}

	}

}
