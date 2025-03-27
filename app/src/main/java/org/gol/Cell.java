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
 * Interface representing a cell in the game of life.
 * @author Francesco Palozzi
 */
public interface Cell {
    
    /**
     * Return the status of the cell.
     * @return the status of the cell
     */
    Status getStatus();

    /**
     * Set the status of the cell.
     * @param status
     */
    void setStatus(Status status);

    /**
     * Switch the status of the cell.
     */
    void switchStatus();

    /**
     * Return the coordinate of the cell.
     * @return the coordinate of the cell
     */
    Coordinate getCoordinate();

    /**
     * Return the neighbours of the cell.
     * @return the neighbours of the cell
     */
    ArrayList<Coordinate> getNeighbours();

    /**
     * Set the next status of the cell.
     * @param status
     */
    void setNextStatus(Status status);

    /**
     * Step the cell to the next status.
     */
    void step();
}
