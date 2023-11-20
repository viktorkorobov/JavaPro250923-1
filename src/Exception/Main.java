package Exception;

public class Main extends ArrayValueCalculator{
    public static void main(String[] args) {
        String[][] testArray = {
                {"1", "2", "3", "4","2"},
                {"5", "6", "7", "8","2"},
                {"9", "10", "11", "12","2"},
                {"13", "14", "15", "16","2"}
        };

        try {
            int result = doCalc(testArray);
            System.out.println("Result sum: " + result);
        } catch (ArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }
}
