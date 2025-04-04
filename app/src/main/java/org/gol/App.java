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

public class App {

    public static void main(String[] args) {
        new App().startApp();
    }

    public int startApp() {
        LimitedField field = new LimitedField(10);
        field.switchCellStatus(new Coordinate(3, 4));
        field.switchCellStatus(new Coordinate(3, 5));
        field.switchCellStatus(new Coordinate(3, 6));
        field.switchCellStatus(new Coordinate(4, 4));
        field.switchCellStatus(new Coordinate(4, 5));
        field.switchCellStatus(new Coordinate(4, 6));
        field.switchCellStatus(new Coordinate(5, 4));
        field.switchCellStatus(new Coordinate(5, 5));
        field.switchCellStatus(new Coordinate(5, 6));
        field.switchCellStatus(new Coordinate(6, 6));
        for(int i = 0; i < 35; i++) {
            
            field.showField();
            field.step();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        field.showField();

        return 0;
    }
}
