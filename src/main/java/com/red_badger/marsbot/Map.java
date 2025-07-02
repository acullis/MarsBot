package com.red_badger.marsbot;

public final class Map {

    private MapBlock[][] map = null;

    public  Map(int x, int y) {
        initMap(x, y);
    }

    private void initMap(int x, int y) {
        map = new MapBlock[x+1][y+1];
        for (int j = y; j >= 0; j--) {
            for (int i = 0; i <= x; i++) {
                map[i][j] = new MapBlock(i, j);
            }
        }
    }

    public MapBlock getBlock(int x, int y) throws ArrayIndexOutOfBoundsException {
        if(x>=0 && x<map.length &&
           y>=0 && y<map[0].length ) {
            return map[x][y];
        }
        return null;
    }

    public int getXLength() {
        return map.length;
    }

    public int getYLength() {
        return map[0].length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        for (int j = map[0].length-1; j >= 0; j--) {
            sb.append(j).append("[");
            for (MapBlock[] mapBlocks : map) {
                sb.append(mapBlocks[j]);
            }
            sb.append("]").append(System.lineSeparator());
        }
        sb.append("  ------").append(System.lineSeparator());
        sb.append("  012345");
        return sb.toString();
    }
}
