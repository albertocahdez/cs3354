package edu.txst.midterm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVBoardLoader implements BoardLoader {

	@Override
	public Board load(String filename) {
		Board board = new Board();
		board.setStepCounter();
		String line;
		int row = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			while ((line = br.readLine()) != null && row < 6) {
				String[] values = line.split(",");
				for (int col = 0; col < values.length && col < 10; col++) {
					int cellType = Integer.parseInt(values[col].trim());
					board.setCell(row, col, cellType);
				}
				row++;
			}
		} catch (IOException | NumberFormatException e) {
			System.err.println("Error loading level: " + e.getMessage());
		}
		return board;
	}
}
