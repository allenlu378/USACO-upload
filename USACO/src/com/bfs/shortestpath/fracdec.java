package com.bfs.shortestpath;

/*
ID: allenlu2
LANG: JAVA
TASK: fracdec
*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Scanner;

public class fracdec {

	static int num, den, integer, rem;
	static String arg;
	static String dec, ans = "", str;
	static int index;

	public static BigDecimal con(String fraction) throws ParseException {
		BigDecimal d = null;
		if (fraction != null) {
			if (fraction.contains("/")) {
				String[] numbers = fraction.split("/");
				if (numbers.length == 2) {
					BigDecimal d1 = BigDecimal.valueOf(Double.valueOf(numbers[0]));
					BigDecimal d2 = BigDecimal.valueOf(Double.valueOf(numbers[1]));
					BigDecimal response = d1.divide(d2, 300, RoundingMode.DOWN);
					d = response;
				}
			}
		}
		if (d == null) {
			throw new ParseException(fraction, 0);
		}
		return d;
	}

	public static int only(String string) {
		if ((string + string).indexOf(string, 1) != string.length()) {
			return (string + string).indexOf(string, 1);

		}
		return -1;

	}

	public static void main(String[] args) throws IOException, ParseException {
		Scanner in = new Scanner(new File("fracdec.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fracdec.out")));
		int len;
		num = in.nextInt();
		den = in.nextInt();
		arg = num + "/" + den;
		str = con(arg).toString();
		str = str.replaceAll("0+$", "");
		index = str.indexOf(".");
		dec = str.substring(index + 1);

		if (dec.length() > 200) {
			ans += str.substring(0, index + 1);
			for (int i = 0; i < dec.length(); i++) {
				len = only(dec.substring(i));
				if (len != -1) {
					for (int j = 0; j < dec.length(); j++) {
						if (dec.substring(j, j + len).equals(dec.substring(j + len, j + 2 * len))) {
							ans += "(" + dec.substring(j, j + len) + ")";
							break;
						}
						ans += dec.charAt(j);
					}
					break;
				}

			}
		} else {
			ans = str;
			if (dec.length() == 0) {
				ans += "0";
			}
		}
		for (int i = 0; i < ans.length(); i++) {
			if (i % 76 == 0 && i != 0) {
				out.println();
				System.out.println();
			}
			out.print(ans.charAt(i));
			System.out.print(ans.charAt(i));
		}
		out.close();
	}

}
