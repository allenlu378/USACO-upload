import java.io.IOException;
import java.util.LinkedList;

class DataPair implements Comparable<DataPair> {

	private int row, col;

	// constructor
	DataPair() {
		row = 0;
		col = 0;
	}

	DataPair(int s, int e) {
		row = s;
		col = e;
	}

	public int getRow() {
		return (row);
	}

	public int getCol() {
		return (col);
	}

	public int compareTo(DataPair CompPair) {
		return (this.col - CompPair.getCol());
	}

}

public class assign {
	static int numCows, numPairs, numPoss = 0;

	static int[] numBreeds;
	static LinkedList<DataPair> same = new LinkedList<DataPair>(), diff = new LinkedList<DataPair>();
	static LinkedList<Integer> notDone = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		int[][] grid = new int[3][3];
		int count = 0;
		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 3; j++) {
				grid[j][i] = count;
				count++;
			}
		}
		System.out.println("Done");

	}

	public static void calc(int cowtoChange) {
		if (cowtoChange == numCows) {
			if (check()) {
				numPoss++;
			}
			return;
		}
		for (int i = 1; i <= 3; i++) {
			numBreeds[cowtoChange] = i;
			calc(cowtoChange + 1);
		}

	}

	public static boolean check() {
		for (int i = 0; i < same.size(); i++) {
			if (numBreeds[same.get(i).getRow() - 1] != numBreeds[same.get(i).getCol() - 1]) {
				return false;
			}
		}
		for (int i = 0; i < diff.size(); i++) {
			if (numBreeds[diff.get(i).getRow() - 1] == numBreeds[diff.get(i).getCol() - 1]) {
				return false;
			}
		}
		return true;
	}
}
