/*
 *  MIT License
 *
 *  Copyright (c) 2025 Francesco Palozzi
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.

 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package org.gol;

import java.util.ArrayList;

/**
 * Class representing a limited field in the game of life.
 * The field has a size and a matrix of cells.
 * @author Francesco Palozzi
 */
public class LimitedField implements Field {

    private final Cell[][] cells;

    /**
     * Constructor of the class.
     * @param size dimensione della griglia
     */
    LimitedField(int size) {
        cells = new Cell[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                cells[x][y] = new RealCell(new Coordinate(x, y));
            }
        }
    }


    @Override
    public Cell getCell(Coordinate coordinate) {
        return cells[coordinate.x()][coordinate.y()];
    }

    @Override
    public void setCellStatus(Coordinate coordinate, Status status) {
        cells[coordinate.x()][coordinate.y()].setStatus(status);
    }

    @Override
    public void switchCellStatus(Coordinate coordinate) {
        cells[coordinate.x()][coordinate.y()].switchStatus();
    }

    @Override
    public void step() {
        for (Cell[] value : cells) {
            for (int j = 0; j < cells.length; j++) {
                Cell cell = value[j];
                cell.setNextStatus(aliveNeighbours(cell));
            }
        }

        for (Cell[] cell : cells) {
            for (int j = 0; j < cells.length; j++) {
                cell[j].step();
            }
        }
    }

    /**
     * Return the number of alive neighbours of the cell.
     * @param cell Cella da cui controllare i vicini
     * @return the number of alive neighbours of the cell
     */
    private int aliveNeighbours(Cell cell) {
        ArrayList<Coordinate> neighbours = cell.getNeighbours(cells.length);
        int aliveNeighbours = 0;

        for (Coordinate coordinate : neighbours) {
            if(cells[coordinate.x()][coordinate.y()].isAlive()) {
                aliveNeighbours++;
            }
        }

        return aliveNeighbours;
    }


    @Override
    public void showField() {
        for (Cell[] cell : cells) {
            for (int j = 0; j < cells.length; j++) {
                System.out.print(cell[j].getStatus().toString() + " | ");
            }

            System.out.println();
        }
        System.out.println();
    }
    
}
