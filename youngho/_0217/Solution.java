package _0217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int T, N;
    private static int[] weights;

    private static int[][] memo;

    public static void main(String[] args) throws IOException {

        T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(input.readLine());
            weights = new int[N];
            tokens = new StringTokenizer(input.readLine(), " ");

            int weightSum = 0;
            for (int i = 0; i < N; i++) {
                weightSum += weights[i] = Integer.parseInt(tokens.nextToken());
            }
            memo = new int[weightSum + 1][(1 << N)];

            int answer = solve(N, 0, 0, 0);

            output.append('#').append(t).append(' ').append(answer).append('\n');
        }

        System.out.print(output);
    }

    private static int solve(final int toChoose, final int left, final int right, final int visit) {
        if (left < right) {
            return 0;
        }

        if (memo[left][visit] != 0) {
            return memo[left][visit];
        }

        if (toChoose == 0) {
            return memo[left][visit] = 1;
        }

        int cntSum = 0;

        for (int i = 0; i < N; i++) {
            if ((visit & (1 << i)) == 0) {
                cntSum += solve(toChoose - 1, left + weights[i], right, visit | (1 << i));
                cntSum += solve(toChoose - 1, left, right + weights[i], visit | (1 << i));
            }
        }
        return memo[left][visit] = cntSum;
    }

}