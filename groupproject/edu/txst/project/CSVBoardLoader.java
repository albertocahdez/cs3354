
package edu.txst.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVBoardLoader implements BoardLoader {

    @Override
    public Board load(String filename) {
        Board board = new Board();

        try (BufferedReader br =
                new BufferedReader(new FileReader(filename))) {

            String line;
            int row = 0;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                if (row >= 6) {
                    throw new IllegalArgumentException(
                        "CSV contains more than 6 rows."
                    );
                }

                String[] values = line.split(",", -1);

                if (values.length != 10) {
                    throw new IllegalArgumentException(
                        "Row " + (row + 1) +
                        " must contain exactly 10 columns."
                    );
                }

                for (int col = 0; col < 10; col++) {
                    int cellType =
                        Integer.parseInt(values[col].trim());

                    if (cellType < 0 || cellType > 8) {
                        throw new IllegalArgumentException(
                            "Invalid cell type at row " +
                            (row + 1) + ", column " + (col + 1)
                        );
                    }

                    board.setCell(row, col, cellType);
                }

                row++;
            }

            if (row != 6) {
                throw new IllegalArgumentException(
                    "CSV must contain exactly 6 rows."
                );
            }

        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException(
                "Unable to load level: " + e.getMessage(), e
            );
        }

        board.setStepCounter();
        return board;
    }
}
