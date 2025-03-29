package org.gol;

import java.util.ArrayList;

public record Coordinate(int x, int y) {

    public ArrayList<Coordinate> getNeighbours(int size) {
        ArrayList<Coordinate> neighbours = new ArrayList<>();

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i != 0 || j != 0) {
                    if(this.x() + i < 0 || this.x() + i >= size || this.y() + j < 0 || this.y() + j >= size) {
                        continue;
                    }
                    neighbours.add(new Coordinate(this.x() + i, this.y() + j));
                }
            }
        }

        return neighbours;
    }
}
