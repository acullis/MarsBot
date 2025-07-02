package com.red_badger.marsbot;

import java.util.Arrays;

public class Map {
    MapBlock[][] map = null;

    public Map(String mapSize) {
        if(mapSize != null && mapSize.length()>0 && mapSize.contains(" ")){
            int x = -1;
            int y = -1;
            String[] mapSizeXY = mapSize.split(" "); // Splits by space
            if(mapSize.length()>0){
                x = Integer.parseInt(mapSizeXY[0]);
                y = Integer.parseInt(mapSizeXY[1]);
                System.out.println("Map size x="+x+" y="+y);
                initMap(x,y);
            }
        }
    }

    private void initMap(int x, int y) {
        map = new MapBlock[x+1][y+1];
        for (int j = y; j >= 0; j--) {
            for (int i = 0; i <= x; i++) {
                map[i][j] = new MapBlock(i, j);
            }
        }
    }

    public MapBlock getBlock(int x, int y){
        return map[x][y];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(System.lineSeparator());
        for (int j = 3; j >= 0; j--) {
            sb.append(j+"[");
            for (int i = 0; i < 5; i++) {
                sb.append(map[i][j]);
            }
            sb.append("]"+System.lineSeparator());
        }
        sb.append("  ------"+System.lineSeparator());
        sb.append("  012345");
        return sb.toString();
    }
}
