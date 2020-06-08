import java.util.Arrays;
import java.util.Random;

public class QSortStress {
	private static Random random = new Random();

	public static void main(String[] args) {
//		Random random = new Random();
		boolean pass = true;
		int x = 1;
		while (pass) {
			int size = random.nextInt(500);
			int[] a = new int[size];
			int[] b = new int[size];
			int[] c = new int[size];
			

			for (int i = 0; i < size; i++) {
				a[i] = random.nextInt(1000000000);
				b[i] = a[i];
				c[i] = a[i];
			}
			
			randomizedQuickSort(a, 0, a.length - 1); //Three Partition Implementation
			Arrays.sort(b);

			if (Arrays.equals(a, b)) {
				System.out.println("Correct Answer" + x);
				x++;
			} else {
				pass = false;
				
				System.out.println("\n\n Original dataset: \n\n");
				for (int i = 0; i < c.length; ++i) {
					System.out.print(c[i] + " ");
				}
				
				System.out.println("\n\nInput Length: " + b.length + " " + "\n\n Correct Answer: \n\n");

				for (int i = 0; i < b.length; ++i) {
					System.out.print(b[i] + " ");
				}	

				System.out.println("\n\n Your Answer: \n\n");

				for (int i = 0; i < a.length; ++i) {
					System.out.print(a[i] + " ");
				}

			}
		}

	}
	
	private static void randomizedQuickSort(int[] a, int l, int r) {
		if (l >= r) {
			return;
		}
		int k = random.nextInt(r - l + 1) + l;
		int t = a[l];
		a[l] = a[k];
		a[k] = t;
		// use partition3
		int[] m = partition3(a, l, r);
		randomizedQuickSort(a, l, m[0] - 1);
		randomizedQuickSort(a, m[1] + 1, r);
	}	
	
	private static int[] partition3(int[] a, int l, int r) {
		int x = a[l];
//		System.out.println("X:" + x);
		int j = l;
		int k = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] < x) {
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			} else if (a[i] == x) {
//                k = j;
				k++;
				int t = a[i];
				a[i] = a[k];
				a[k] = t;
				if (a[i] < x) {
					j++;
					t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		if (j >= k) {
			for (int i = l; i < k; i++) {
				int t = a[j];
				a[j] = a[i];
				a[i] = t;
				j--;
			}			
		} else {
			int t = a[j];
			a[j] = a[l];
			a[l] = t;
//			j--;
		}

		int m1 = j + 1;
		int m2 = j + k - l;

		int[] m = { m1, m2 };
		return m;
	}
	
}
