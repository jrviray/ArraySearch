package proj2;

import java.util.Arrays;
import java.util.Stack;

public class Select_kth_Four {

	public int findK(int[] array, int k) {

		int value = 0;
		int n = array.length;
		// how many columns to split into
		int c = 5;

		while (true) {
			// find median of medians and use it as the pivot
			int pivot = this.pivot(array, n, c);
			// count how many elements are larger or smaller
			int smallCount = 0;
			int largeCount = 0;
			int[] values = new int[2];
			this.counter(array, n, pivot, values);
			smallCount = values[0];
			largeCount = values[1];
			// partition the array
			if (k < smallCount) {
				n = this.partition(array, n, pivot, true);
			} else if (k < n - largeCount) {
				value = pivot;
				break;
			} else {
				k -= n - largeCount;
				n = this.partition(array, n, pivot, false);
			}
		}
		return value;
	}

	// count the elements which are larger or smaller than the pivot
	public void counter(int[] array, int n, int pivot, int[] values) {
		for (int i = 0; i < n; i++) {
			if (array[i] < pivot) {
				values[0]++;
			}
			if (array[i] > pivot) {
				values[1]++;
			}
		}
	}

	// find the median of medians and setting it as the pivot
	public int pivot(int[] array, int n, int c) {
		while (n > 1) {
			int pos = 0;
			int temp = 0;
			for (int start = 0; start < n; start += c) {
				int end = start + c;
				if (end > n) {
					end = n;
				}
				// sort the array into its columns
				for (int i = start; i < end - 1; i++) {
					for (int j = i + 1; j < end; j++) {
						if (array[j] < array[i]) {
							temp = array[i];
							array[i] = array[j];
							array[j] = temp;
						}
					}
				}
				// move median to start
				end = (start + end) / 2;
				temp = array[end];
				array[end] = array[pos];
				array[pos++] = temp;
			}
			n = pos;
		}
		// return pivot
		return array[0];
	}

	// parition elements
	public int partition(int[] array, int n, int pivot, boolean extSmall) {
		int pos = 0;
		for (int i = 0; i < n; i++) {
			if ((extSmall && array[i] < pivot) || (!extSmall && array[i] > pivot)) {
				int temp = array[i];
				array[i] = array[pos];
				array[pos++] = temp;
			}
		}
		n = pos;
		return n;
	}

	public void test(int size, int k) {
		Array array = new Array(size);
		array.generateElements(array.getArray());
		this.findK(array.getArray(), k - 1);
	}
}
