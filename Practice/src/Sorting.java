import java.io.*;
import java.util.*;

public class Sorting {
	private static Random random = new Random();

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
//				j++;
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
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
				j--;
			}
		} else {
			int t = a[j];
			a[j] = a[l];
			a[l] = t;
		}

		int m1 = j + 1;
		int m2 = j + k - l;

		int[] m = { m1, m2 };
		return m;
	}

	private static int partition2(int[] a, int l, int r) {
		int x = a[l];
		int j = l;
		for (int i = l + 1; i <= r; i++) {
			if (a[i] <= x) {
				j++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[l];
		a[l] = a[j];
		a[j] = t;
		return j;
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

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		int n = scanner.nextInt();
//		boolean good = true;
		int[] a = new int[n];
//			int[] a = { 22213472, 144637581, 427735275, 897969411, 527154940, 142948379, 485699694, 72888021, 525007839,
//					766271062, 475521626, 912235839, 873942140, 219520177, 762191092, 84527628, 889984220, 136200415,
//					975662669, 761096759, 939793964, 666131207, 495071542, 200328339, 820179593, 969071224, 827978169,
//					275478515, 740352011, 183966526, 874925349, 643363328, 911886596, 72888021, 29416410, 557410869,
//					341732310, 142800889, 184011188, 2278660, 962684526, 612532121, 367950610, 15189782, 562844001,
//					119773929, 779927170, 105057456, 847080097, 418923671, 829126922, 257738545, 257205211, 203151125,
//					850206485, 578670775, 347188337, 323089941, 191731193, 338670050, 272361231, 791884563, 5722657,
//					383092656, 669998828, 515565835, 958973404, 144942472 };
//			int[] ans = { 2278660, 5722657, 15189782, 22213472, 29416410, 72888021, 72888021, 84527628, 105057456,
//					119773929, 136200415, 142800889, 142948379, 144637581, 144942472, 183966526, 184011188, 191731193,
//					200328339, 203151125, 219520177, 257205211, 257738545, 272361231, 275478515, 323089941, 338670050,
//					341732310, 347188337, 367950610, 383092656, 418923671, 427735275, 475521626, 485699694, 495071542,
//					515565835, 525007839, 527154940, 557410869, 562844001, 578670775, 612532121, 643363328, 666131207,
//					669998828, 740352011, 761096759, 762191092, 766271062, 779927170, 791884563, 820179593, 827978169,
//					829126922, 847080097, 850206485, 873942140, 874925349, 889984220, 897969411, 911886596, 912235839,
//					939793964, 958973404, 962684526, 969071224, 975662669 };
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		randomizedQuickSort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
//			if (!Arrays.equals(a, ans)) {
//				System.out.println("\n Wrong answer");
//				good = false;
//			}

	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
