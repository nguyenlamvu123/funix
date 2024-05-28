import java.io.*;
import java.util.Scanner;


public class Array {
	static Scanner sc = new Scanner(System.in);
	static int n = 0;
	static int choice = 1;
	static int [] mang1chieu;
	public static void main(String[] args) {
		int[] vo = docfile(0, "sapxeptimkiemcoban.txt");
		while (choice != 0) {
			choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("Choice 1: Manual Input");
				System.out.println("Please enter input number of elements: ...");
				n = luuvaotep();  // yêu cầu 1
			} else if (choice == 2) {
				System.out.println("Choice 2: File input");
				System.out.println("File path is INPUT.TXT");		
				mang1chieu = docfile(n, "INPUT.TXT");  // yêu cầu 2
			} else if (choice == 3) {  // error
				System.out.println("Choice 3: Bubble sort");
				int[] mang1chieu_ = bubbleSort(mang1chieu);  // yêu cầu 3
			}
		}
		// int[] mang1chieu____ = indexelemgreaterval(mang1chieu, n);  // yêu cầu 6
		// int[] mang1chieu__ = selectionSort(mang1chieu);  // yêu cầu 4
		// int[] mang1chieu___ = insertionSort(mang1chieu);  // yêu cầu 5

		// Scanner sc = new Scanner(System.in);
		// int x = sc.nextInt();
		// int bs = binarySearch(mang1chieu, 0, n - 1, x);  // yêu cầu 7
		// System.out.print(bs);
		// readFile();
	}

	public static int luuvaotep() {
		try {
			FileWriter out = new FileWriter("INPUT.TXT");
			int n = sc.nextInt();
			System.out.println("Please enter input elements: ...");
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				out.write(x);
			}
			out.close();
			return n;
		} catch(IOException e) {
			e.printStackTrace();
			return 0;
		}		
	}

	public static int[] docfile(int n, String filename) {
		mang1chieu = new int[n];		
		int c;
		try {
			FileReader in = new FileReader(filename);
			int i = 0;
			while ((c = in.read()) != -1) {
				if (filename == "INPUT.TXT") {
					System.out.print(c + " ");
					mang1chieu[i] = c;
					i++;
				} else {
					while ((c = in.read()) != -1) {
						System.out.print((char) c);
					}
				}
			}
			in.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return mang1chieu;
	}

	public static void chuyenmangsothanhmangkitu(int[] arr, String filename) {
		char[] mangKyTu = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				mangKyTu[i] = 'N';
			} else {
				mangKyTu[i] = (char) ('0' + arr[i]);
			}
		}

		for (int m: mangKyTu) {
			System.out.print(m + " ");
		}

		if (filename != "_") {
			try {
				FileWriter out = new FileWriter(filename);
				out.write(mangKyTu);
				out.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int[] bubbleSort(int[] arr) {
        	int n = arr.length;

	        for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++){
	                	if (arr[j] > arr[j + 1]) {
				int temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
				}
			}
			chuyenmangsothanhmangkitu(arr, "_");
		}
		chuyenmangsothanhmangkitu(arr, "INPUT1.TXT");
		return arr;
        }

	public static int[] selectionSort(int[] arr) {
        	int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}
		int temp = arr[min_idx];
		arr[min_idx] = arr[i];
		arr[i] = temp;
        	}

		chuyenmangsothanhmangkitu(arr, "INPUT2.TXT");
		return arr;
        }

	public static int[] insertionSort(int[] arr) {
        	int n = arr.length;
	        for (int i = 1; i < n; ++i) {
        	    int key = arr[i];
	            int j = i - 1;
	            while (j >= 0 && arr[j] > key) {
        	        arr[j + 1] = arr[j];
                	j = j - 1;
	            }
        	    arr[j + 1] = key;
	        }

		chuyenmangsothanhmangkitu(arr, "INPUT3.TXT");
		return arr;
    	}

	public static int[] indexelemgreaterval(int[] arr, int n) {
		Scanner sc = new Scanner(System.in);
		int[] indgreval = new int[n];
		int j = 0;
		int val = sc.nextInt();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > val) {
				indgreval[j] = i;
				// System.out.println(i + "____" + arr[i]);
				j ++;
			}  // else {
				// System.out.println("%%%%%%%%%" + arr[i]);
			// }
		}

		chuyenmangsothanhmangkitu(indgreval, "INPUT4.TXT");
		return indgreval;
	}

	public static int binarySearch(int arr[], int l, int r, int x) {
        	if (r >= l) {
			int mid = (l + r) / 2;
			// System.out.println(l + "%%%%%%%%%" + r);
			// System.out.println(mid + "____" + arr[mid]);
			if (arr[mid] < x) {
				return binarySearch(arr, mid + 1, r, x);
			}
			int bi = binarySearch(arr, l, mid - 1, x);
			if (arr[mid] == x) {
				if (bi == -1) {
					return mid;
				} else {
					return bi;
				}
			}
			if (arr[mid] > x) {
		                return bi;
			}
		}
	        return -1;
        }
}
