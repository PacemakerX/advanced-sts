package m6;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] relationshipMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                relationshipMatrix[i][j] = sc.nextInt();
            }
        }
        int celebrityId = new Solution().findCelebrity(relationshipMatrix, N);
        if (celebrityId != -1) {
            System.out.println("Celebrity id: " + celebrityId);
        } else {
            System.out.println("No Celebrity");
        }
        sc.close();
    }
}

class Solution {
    int findCelebrity(int M[][], int n) {
        int candidate = 0;
        for (int i = 1; i < n; i++) {
            if (M[candidate][i] == 1) {
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != candidate && (M[candidate][i] == 1 || M[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }
}