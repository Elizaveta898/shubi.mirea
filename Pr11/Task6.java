package Pr11;

import java.util.Scanner;

public class Task6 {
    public static boolean recursion(int n, int i) {
        if (n < 2) {
            return false;
        }
        else if (n == 2) {
            return true;
        }
        else if (n % i == 0) {
            return false;
        }
        else if (i < n / 2) {
            return recursion(n, i + 1);
        } else {
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if (recursion(n, 2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}