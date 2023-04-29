
public class CountingInversions {
	public static void main(String[] args) {
		int[] num = new int[10000];
		int[] numbers = new int[10000];

		for (int i = 0; i < 10000; i++) {
			numbers[i] = (int) (Math.random() * (1000000 - 1000 + 1)) + 1000;
			// System.out.print(numbers[i] + ", ");
		}

		num = numbers;

		long start = System.currentTimeMillis();
		int inversions = countInversions(numbers);
		long end = System.currentTimeMillis();
		System.out.println("Brute force method:");
		System.out.println("Number of inversions: " + inversions);
		System.out.printf("Execution time in milliseconds: %d%n%n", end - start);

		long start2 = System.currentTimeMillis();
		int inversions2 = countInversions2(numbers);
		long end2 = System.currentTimeMillis();
		System.out.println("Divide and conquer method:");
		System.out.println("Number of inversions: " + inversions2);
		System.out.printf("Execution time in milliseconds: %d%n", end2 - start2);
	}

	public static int countInversions(int[] numbers) {
		int inversions = 0;

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					inversions++;
				}
			}
		}

		return inversions;
	}

	public static int countInversions2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return mergeSort(arr, 0, arr.length - 1);
	}

	private static int mergeSort(int[] arr, int start, int end) {
		int inversions = 0;
		if (start < end) {
			int mid = (start + end) / 2;
			inversions += mergeSort(arr, start, mid);
			inversions += mergeSort(arr, mid + 1, end);
			inversions += merge(arr, start, mid, end);
		}
		return inversions;
	}

	private static int merge(int[] arr, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int i = start, j = mid + 1, k = 0;
		int inversions = 0;
		while (i <= mid && j <= end) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inversions += mid - i + 1;
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= end) {
			temp[k++] = arr[j++];
		}
		System.arraycopy(temp, 0, arr, start, temp.length);
		return inversions;
	}
}
