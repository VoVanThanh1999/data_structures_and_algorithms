package data.structures;

import java.util.ArrayList;

import java.util.List;
class Position {
	int row;
	int column;

	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
}

class State {
	Position position;
	int current;

	public State(Position position, int current) {
		super();
		this.position = position;
		this.current = current;
	}
}

public class Solution {

	static String countLuck(String[] matrix, int k) {
		Position start = null;
		Position end = null;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length(); j++) {
				if (String.valueOf(matrix[i].charAt(j)).equals("M")) {
					start = new Position(i, j);
				} else if (String.valueOf(matrix[i].charAt(j)).equals("*")) {
					end = new Position(i, j);
				}
			}
		}
		return theNumbersWavesInTheForest(start, end, matrix) == k ? "Impressed" : "Oops!";
	}

	static int theNumbersWavesInTheForest(Position start, Position end, String[] matrix) {
		StringBuilder strings[] = new StringBuilder[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			strings[i] = new StringBuilder(matrix[i]);
		}

		State state = new State(start, 0);
		java.util.Stack<State> stack = new java.util.Stack<State>();
		stack.push(state);
		while (!stack.isEmpty()) {
			State current = stack.pop();
			int currentColumn = current.position.column;
			int currentRow = current.position.row;
			int lengthMatrix = matrix.length;
			int lengthString = matrix[0].length();
			int countCunrentWaves = current.current;
			if (currentColumn == end.column && currentRow == end.row) {
				return countCunrentWaves;
			} else {
				strings[currentRow].setCharAt(currentColumn, '1');
			}
			List<Position> positions = new ArrayList<Position>();
			// Top
			if (currentRow - 1 >= 0 && strings[currentRow - 1].charAt(currentColumn) == '.'
					|| currentRow - 1 >= 0 && strings[currentRow - 1].charAt(currentColumn) == '*') {
				positions.add(new Position(currentRow - 1, currentColumn));
			}
			// Bottom
			if (currentRow + 1 < lengthMatrix && strings[currentRow + 1].charAt(currentColumn) == '.'
					|| currentRow + 1 < lengthMatrix && strings[currentRow + 1].charAt(currentColumn) == '*') {
				positions.add(new Position(currentRow + 1, currentColumn));
			}
			// Left
			if (currentColumn - 1 >= 0 && strings[currentRow].charAt(currentColumn - 1) == '.'
					|| currentColumn - 1 >= 0 && strings[currentRow].charAt(currentColumn - 1) == '*') {
				positions.add(new Position(currentRow, currentColumn - 1));
			}
			// Right
			if (currentColumn + 1 < lengthString && strings[currentRow].charAt(currentColumn + 1) == '.'
					|| currentColumn + 1 < lengthString && strings[currentRow].charAt(currentColumn + 1) == '*') {
				positions.add(new Position(currentRow, currentColumn + 1));
			}
			if (positions.size() > 1) {
				countCunrentWaves += 1;
			}
			for (int i = 0; i < positions.size(); i++) {
				State s = new State(positions.get(i), countCunrentWaves);
				stack.push(s);
			}
		}
		return -1;
	}

}
