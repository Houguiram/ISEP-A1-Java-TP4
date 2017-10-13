import java.util.Arrays;
import java.util.Scanner;

public class TP4 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int[] array = { 45, 56, 2, 654, 32, 4, 28 };
		System.out.println("Tableau non trié :");
		printIntArray(array);
		array = recurSort(array, 0, array.length - 1);
		System.out.println("Tableau trié :");
		printIntArray(array);
	}

	public static int[] recurSort(int[] array, int begin, int end) {
		if (begin >= end) {
			int[] newArray = {array[begin]};
			return newArray;
		} else {
			int diff = (end - begin) / 2;
			int[] t1 = recurSort(array, begin, begin + diff);
			int[] t2 = recurSort(array, begin + diff + 1, end);
			int[] res = new int[end - begin + 1];
			res = fusion(t1, t2);
			return res;
		}

	}

	public static int[] fusion(int[] array1, int[] array2) {
		if (array1.length == 0) {
			return array2;
		} else if (array2.length == 0) {
			return array1;
		} else if (array1[0] <= array2[0]) {
			int[] newArray = new int[array1.length + array2.length];
			System.arraycopy(array1, 0, newArray, 0, 1);
			System.arraycopy(fusion(Arrays.copyOfRange(array1, 1, array1.length), array2), 0, newArray, 1,
					fusion(Arrays.copyOfRange(array1, 1, array1.length), array2).length);
			return newArray;

		} else {
			int[] newArray = new int[array1.length + array2.length];
			System.arraycopy(array2, 0, newArray, 0, 1);
			System.arraycopy(fusion(array1, Arrays.copyOfRange(array2, 1, array2.length)), 0, newArray, 1,
					fusion(array1, Arrays.copyOfRange(array2, 1, array2.length)).length);
			return newArray;
		}
	}	
	
	public static void printIntArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

}
