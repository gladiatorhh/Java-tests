import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Utility {

    public <T> T[] CopyArray(T[] srcArr, T[] desArr, int srcPos, int length, int desPos) throws Exception {

        if (srcArr.length > desArr.length) {
            throw new Exception("Your array is smaller that it should be");
        }

        for (int i = srcPos; i < length; i++) {
            desArr[i] = srcArr[desPos];
            desPos++;
        }

        return desArr;
    }

    public <T> T[] CopyArray(T[] srcArr, T[] desArr, int srcPos, int length) throws Exception {
        return CopyArray(srcArr, desArr, srcPos, length, 0);
    }

    public <T> void PrintRepeatCounts(T[] arr) throws Exception {

        if (arr == null) {
            throw new Exception("Array should not be null");
        }

        int times = 0;
        T[] uniqueArr = GetUnique(arr);

        for (int i = 0; i < uniqueArr.length; i++) {
            for (T item : arr) {
                if (uniqueArr[i].equals(item)) {
                    times++;
                }
            }
            System.out.println(
                    "item " + i + " with value " + uniqueArr[i] + " has been repeated " + times + " times");
        }
        times = 0;
    }

    public <T> void PrintRepeatedOnes(T[] arr) throws Exception {

        if (arr == null) {
            throw new Exception("Array should not be null");
        }

        int times = 0;
        T[] uniqueArr = GetUnique(arr);

        for (int i = 0; i < uniqueArr.length; i++) {
            for (T item : arr) {
                if (uniqueArr[i].equals(item)) {
                    times++;
                }
            }
            if (times > 1) {
                System.out.println("item " + i + " with value " + uniqueArr[i]);
            }
            times = 0;
        }
    }

    public <T> void PrintArrayByEvenOdd(T[] arr) throws Exception {

        if (arr == null) {
            throw new Exception("Array should not be null");
        }

        System.out.println("Odd ones :>");
        for (int i = 1; i < arr.length; i += 2) {
            System.out.println("item " + i + " with value " + arr[i]);
        }

        System.out.println("Even ones :)");
        for (int i = 0; i < arr.length; i += 2) {
            System.out.println("item " + i + " with value " + arr[i]);
        }
    }

    public void PrintMax(int[] arr) throws Exception {

        if (arr.length == 0) {
            throw new Exception("Array should not be null");
        }

        int max = arr[0];
        int min = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (min > i) {
                min = i;
            }
        }

        System.out.println("maximum number is : " + max + " minium number is : " + min);
    }

    public void CheckStandardDeviation(double[] array) throws Exception {

        if (array.length == 0) {
            throw new Exception("Array should not be null");
        }

        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        double avg = sum / array.length;

        double sumOfSquares = 0;
        for (double num : array) {
            sumOfSquares += Math.pow(num - avg, 2);
        }
        double standardDeviation = Math.sqrt(sumOfSquares / array.length);

        System.out.println("sum :" + sum);
        System.out.println("average :" + avg);
        System.out.println("Standard deviation :" + standardDeviation);
    }

    public <T> T[] SpinArray(T[] arr, int spinIndex) throws Exception {

        if (arr == null) {
            throw new Exception("Array should not be null");
        }

        if (spinIndex > arr.length) {
            throw new Exception("What are you doing enter a correct value for spin index");
        }

        T[] newArray = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);

        int newArrIndexer = 0;
        for (int i = spinIndex; i < newArray.length; i++) {
            newArray[newArrIndexer] = arr[i];
            newArrIndexer++;
        }

        for (int i = 0; i < spinIndex; i++) {
            newArray[newArrIndexer] = arr[i];
            newArrIndexer++;
        }

        return newArray;
    }

    public void SortArrayAndPrint(int[] arr) throws Exception {

        if (arr.length == 0) {
            throw new Exception("Array should not be null");
        }

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void PrintBiggest(int[] arr, int count) throws Exception {

        if (arr.length == 0) {
            throw new Exception("Array should not be null");
        }

        if (count > arr.length) {
            throw new Exception("What are you doing enter a correct value for count");
        }

        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(arr[count - 1]);
    }

    public <T> void SetArrayByUnique(T[] arr) throws Exception {

        if (arr == null) {
            throw new Exception("Array should not be null");
        }

        T[] unique = GetUnique(arr);

        for (T item : unique) {
            System.out.println(item);
        }
    }

    public <T> T[] GetUnique(T[] arr) {
        ArrayList<T> unique = new ArrayList<T>();
        boolean exists = false;

        for (int i = 0; i < arr.length; i++) {
            for (Object object : unique) {
                if (object != null && object.equals(arr[i])) {
                    exists = true;
                }
            }

            if (!exists) {
                unique.add(arr[i]);
            }
            exists = false;
        }

        return (T[]) unique.toArray();
    }

    public int[][] CalculateTranspose(int[][] matrix, int rows, int cols) {
        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }

        return transpose;
    }

    public static boolean IsIdentity(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && matrix[i][j] != 1) {
                    return false;
                }
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean IsLowerTriangular(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean IsUpperTriangular(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public <T> void PrintArray(T[] arr) {
        for (T item : arr) {
            System.out.println(item);
        }
    }

    public void Print2DArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
