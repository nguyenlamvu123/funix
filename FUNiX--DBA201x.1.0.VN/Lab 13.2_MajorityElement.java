import java.util.*;
import java.io.*;

public class MajorityElement {
    private static int getMajorityElement(int[] a, int left, int right) {
        if (left == right) {
            return -1;
        }
        if (left + 1 == right) {
            return a[left];
        }

        // Sử dụng thuật toán Boyer-Moore Voting
        int candidate = findCandidate(a, left, right);
        
        // Kiểm tra xem phần tử ứng cử viên có phải là phần tử đa số hay không
        if (isMajority(a, left, right, candidate)) {
            return candidate;
        } else {
            return -1;
        }
    }

    // Hàm tìm ứng cử viên cho phần tử đa số
    private static int findCandidate(int[] a, int left, int right) {
        int count = 0, candidate = -1;
        for (int i = left; i < right; i++) {
            if (count == 0) {
                candidate = a[i];
                count = 1;
            } else if (a[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    // Hàm kiểm tra phần tử đa số
    private static boolean isMajority(int[] a, int left, int right, int candidate) {
        int count = 0;
        for (int i = left; i < right; i++) {
            if (a[i] == candidate) {
                count++;
            }
        }
        return count > (right - left) / 2;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (getMajorityElement(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
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
