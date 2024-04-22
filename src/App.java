import java.lang.reflect.Array;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {

        int[][] matrix = {
                { 1, 0, 0 },
                { 1, 1, 0 },
                { 2, 3, 0 }
        };

        Utility utility = new Utility();
        System.out.println(utility.IsLowerTriangular(matrix));
    }
}

// System.out.println("\nTesting SetArrayByUnique method:");
// Integer[] srcArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 10, 5, 11 };

// utility.SetArrayByUnique(srcArr);