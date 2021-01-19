public class ShipsCounter {
    static int[][] ships = {
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0,},
            {0, 1, 0, 0, 0, 0, 0, 1, 0, 0,},
            {0, 1, 0, 1, 1, 0, 0, 0, 0, 0,},
            {0, 1, 0, 1, 1, 0, 0, 1, 1, 1,},
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {1, 1, 1, 1, 0, 1, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 0,},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 1,}
    };

    public static void main(String[] args) {
            int count = 0;

        for (int row = 0; row < ships.length; row++) {
            for (int column = 0; column < ships[row].length; column++) {

                if (ships[row][column] == 1) {

                    ships[row][column] = 0; // clearing counted ship
                    count++;

                    for (int curColumn = column + 1; curColumn < ships[row].length; curColumn++) { // searching parts of same ship in current row starting from first position
                        if (ships[row][curColumn] == 1) {
                            ships[row][curColumn] = 0; // clearing part of already counted ship
                        } else {
                            break;
                        }
                    }

                    for (int curRow = row + 1; curRow < ships.length; curRow++) { // searching parts of same ship in current column starting from first position
                        if (ships[curRow][column] == 1) {
                            ships[curRow][column] = 0;  //clearing part of already counted ship
                            if (column + 1 < ships[row].length && ships[curRow][column + 1] == 1) { // check if ship contain parts from square or rectangle
                                ships[curRow][column + 1] = 0; //clearing square or rectangle part of already counted ship
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}