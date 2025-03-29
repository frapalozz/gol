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
 * Class representing a real cell in the game of life.
 * The cell has a status (DEAD or ALIVE) and a coordinate (X, Y).
 * @author Francesco Palozzi
 */
public class RealCell implements Cell {

    final Coordinate coordinate;
    Status status;
    Status nextStatus;

    /**
     * Constructor of the class.
     * @param coordinate
     */
    RealCell(Coordinate coordinate) {
        this.coordinate = coordinate;
        this.status = Status.DEAD;
    }

    @Override
    public boolean isAlive() {
        return this.status == Status.ALIVE;
    }

    @Override
    public Status getStatus() {
        return this.status;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void switchStatus() {
        this.status = this.status.switchStatus();
    }

    @Override
    public Coordinate getCoordinate() {
        return this.coordinate;
    }

    @Override
    public ArrayList<Coordinate> getNeighbours(int size) {
        return this.coordinate.getNeighbours(size);
    }

    @Override
    public void setNextStatus(int aliveNeighbours) {
        switch (aliveNeighbours) {
            case 2: this.nextStatus = this.status; break;
            case 3: this.nextStatus = Status.ALIVE; break;
            default: this.nextStatus = Status.DEAD; break;
        }
    }

    @Override
    public void step() {
        this.status = this.nextStatus;
    }
    
}
