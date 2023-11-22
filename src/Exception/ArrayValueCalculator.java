package Exception;

public class ArrayValueCalculator {
    public static int doCalc(String[][] inputArray) throws ArrayDataException, ArraySizeException {
        if (inputArray.length != 4 || inputArray[0].length != 4) {
            throw new ArraySizeException("Size incorrect, must be 4x4");
        }
        int number = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    number += Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Incorrect data [" + i + "][" + j + "]: " + inputArray[i][j]);
                }
            }
        }

        return number;
    }
}
