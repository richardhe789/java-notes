/*
"C:\Program Files\Java\jdk1.8.0_141\bin\javac"   DisplayMatrix.java

"C:\Program Files\Java\jdk1.8.0_141\bin\java"  DisplayMatrix
 */

public class DisplayMatrix {
	public static void main(String[] args) {
		int[][] arr = new int[6][6];
		int count = 1;
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				arr[i][j] = count;
				count++;
			}
		}

		System.out.println("\nOriginal Matrix");
		System.out.print(printArr(arr));
		// should be
		/*
		 * 01 02 03 04 05 06 
		 * 07 08 09 10 11 12 
		 * 13 14 15 16 17 18 
		 * 19 20 21 22 23 24 
		 * 25 26 27 28 29 30 
		 * 31 32 33 34 35 36
		 */

		// Traverses an array through Row Major Order
		System.out.println("\nrowMajorOrder(arr)");
		System.out.println(rowMajorOrder(arr));
		// should be 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36
		System.out.print("\n");

		// Traverse an array through Column Major Order.
		System.out.println("\ncolumnMajorOrder(arr)");
		System.out.println(columnMajorOrder(arr));
		// should be 1 7 13 19 25 31 2 8 14 20 26 32 3 9 15 21 27 33 4 10 16 22 28 34 5 11 17 23 29 35 6 12 18 24 30 36
		System.out.print("\n");

		System.out.println("\ncolumnTraversal(arr)");
		System.out.println(columnTraversal(arr));
		// should be 1 7 13 19 25 31 32 26 20 14 8 2 3 9 15 21 27 33 34 28 22 16 10 4 5 11 17 23 29 35 36 30 24 18 12 6
		System.out.print("\n");

		System.out.println("\nrowTraversal(arr)");
		System.out.println(rowTraversal(arr));
		// should be 1 2 3 4 5 6 12 11 10 9 8 7 13 14 15 16 17 18 24 23 22 21 20 19 25 26 27 28 29 30 36 35 34 33 32 31
		System.out.print("\n");

		System.out.println("\nspiralTraversal(arr)");
		System.out.println(spiralTraversal(arr));
		// should be 1 2 3 4 5 6 12 18 24 30 36 35 34 33 32 31 25 19 13 7 8 9 10 11 17 23 29 28 27 26 20 14 15 16 22 21
		System.out.print("\n");

		System.out.println("\nmirrorVertical(arr)");
		mirrorVertical(arr);
		System.out.println(printArr(arr));
		// should be
		/*
		 * 01 02 03 03 02 01 
		 * 07 08 09 09 08 07 
		 * 13 14 15 15 14 13 
		 * 19 20 21 21 20 19 
		 * 25 26 27 27 26 25 
		 * 31 32 33 33 32 31
		 */
		System.out.print("\n");

		System.out.println("mirrorHorizontal(arr)");
		mirrorHorizontal(arr);
		System.out.println(printArr(arr));
		// should be
		/*
		 * 01 02 03 03 02 01 
		 * 07 08 09 09 08 07 
		 * 13 14 15 15 14 13 
		 * 13 14 15 15 14 13 
		 * 07 08 09 09 08 07 
		 * 01 02 03 03 02 01
		 */
		System.out.print("\n");

		System.out.println("mirrorDiagonal(arr)");
		mirrorDiagonal(arr);
		System.out.println(printArr(arr));
		// should be
		/*
		 * 01 07 13 13 07 01 
		 * 07 08 14 14 08 02 
		 * 13 14 15 15 09 03 
		 * 13 14 15 15 09 03 
		 * 07 08 09 09 08 02 
		 * 01 02 03 03 02 01
		 */
		System.out.print("\n");
	}

	// Traverses an array through Row Major Order
	public static String rowMajorOrder(int[][] arr) {
		String str = "";
		// Complete method here
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				str += String.valueOf(arr[i][j]) + " ";
			}
		}
		return str;
	}

	// Traverse an array through Column Major Order.
	public static String columnMajorOrder(int[][] arr) {
		String str = "";
		// Complete method here
		for (int col = 0; col < arr[0].length; col++) {
			for (int row = 0; row < arr.length; row++) {
				str += String.valueOf(arr[row][col]) + " ";
			}
		}
		return str;
	}

	/**
	 * Traverse the array by column, then flips direction when changing rows. 
	 * | ^ | ^ 
	 * | | | | 
	 * | | | | 
	 * v | v | 
	 * ^ Traverse the array like so
	 */
	public static String columnTraversal(int[][] arr) {
		String str = "";
		// Complete method here
		int rowsize = arr.length;
		int colsize = arr[0].length;
		for (int col = 0; col < colsize; col++) {
			for (int row = 0; row < rowsize; row++)
				str += String.valueOf(arr[row][col]) + " ";
		}

		return str;
	}

	/**
	 * Traverse the array by Row, then flips direction when changing columns.
	 * --------> 
	 * <-------- 
	 * --------> 
	 * <--------
	 */
	public static String rowTraversal(int[][] arr) {
		String str = "";
		int rowsize = arr.length;
		int colsize = arr[0].length;
		for (int row = 0; row < rowsize; row++) {
			if (row % 2 == 0) {
				for (int col = 0; col < colsize; col++)
					str += String.valueOf(arr[row][col]) + " ";
				// System.out.print(arr[row][col]+ " ");
			} else {
				for (int col = colsize - 1; col >= 0; col--)
					str += String.valueOf(arr[row][col]) + " ";
				// System.out.print(arr[row][col]+ " ");
			}
		}
		return str;
	}

	/**
	 * Traverse the array in a spiral spiral fashion starting from the top left.
	 * refer https://www.enjoyalgorithms.com/blog/print-matrix-in-spiral-order
	 */
	public static String spiralTraversal(int[][] arr) {
		int rowStart = 0;
		int rowEnd = arr.length - 1;
		int colStart = 0;
		int colEnd = arr[0].length - 1;
		String str = "";

		while ((rowStart <= rowEnd) && (colStart <= colEnd)) {
			for (int ii = colStart; ii <= colEnd; ii++)
				str += String.valueOf(arr[rowStart][ii]) + " ";
			// System.out.print(arr[rowStart][ii]+ " ");

			rowStart++;

			for (int ii = rowStart; ii <= rowEnd; ii++)
				str += String.valueOf(arr[ii][colEnd]) + " ";
			// System.out.print(arr[ii][colEnd]+ " ");

			colEnd--;

			if (rowStart <= rowEnd) {
				for (int ii = colEnd; ii >= colStart; ii--)
					str += String.valueOf(arr[rowEnd][ii]) + " ";
				// System.out.print(arr[rowEnd][ii]+ " ");
				rowEnd--;
			}

			if (colStart <= colEnd) {
				for (int ii = rowEnd; ii >= rowStart; ii--)
					str += String.valueOf(arr[ii][colStart]) + " ";
				// System.out.print(arr[ii][colStart]+ " ");
				colStart++;
			}
		}
		return str;
	}

	public static void mirrorVertical(int[][] arr) {
		String str = "";
		int rowsize = arr.length;
		int colsize = arr[0].length;

		if (colsize % 2 == 1) {
			// odd
			for (int row = 0; row < rowsize; row++) {
				for (int col = 0; col < colsize / 2; col++) {
					arr[row][colsize - col - 1] = arr[row][col];
				}
			}
		} else {
			// even
			for (int row = 0; row < rowsize; row++) {
				for (int col = 0; col < colsize / 2; col++) {
					arr[row][colsize - col - 1] = arr[row][col];
				}
			}

		}
	}

	public static void mirrorHorizontal(int[][] arr) {
		String str = "";
		int rowsize = arr.length;
		int colsize = arr[0].length;

		if (rowsize % 2 == 1) {
			// odd
			for (int col = 0; col < colsize; col++) {
				for (int row = 0; row < rowsize / 2; row++) {
					arr[rowsize - row - 1][col] = arr[row][col];
				}
			}
		} else {
			// even
			for (int col = 0; col < colsize; col++) {
				for (int row = 0; row < rowsize / 2; row++) {
					arr[rowsize - row - 1][col] = arr[row][col];
				}
			}

		}
	}

	public static void mirrorDiagonal(int[][] arr) {
		// Complete method here
		String str = "";
		int rowsize = arr.length;
		int colsize = arr[0].length;
		if (rowsize != colsize) {
			System.out.print("Not a good matrix");
			return;
		}
		for (int col = 0; col < colsize; col++) {
			for (int row = 0; row < rowsize; row++) {
				arr[col][row] = arr[row][col];
			}
		}

	}

	public static String printArr(int[][] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] < 10) {
					str += "0" + String.valueOf(arr[i][j]) + " ";
				} else {
					str += String.valueOf(arr[i][j]) + " ";
				}
			}
			str += System.lineSeparator();
		}
		return str;
	}
}
