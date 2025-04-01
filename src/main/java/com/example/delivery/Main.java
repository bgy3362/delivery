import java.io.*;
import java.util.*;


public class Main {
    static int N, K;
    static int initState = 0;
    static int[][] arr;
    static int[] dp;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[1<<N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        String s = br.readLine();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == 'Y') {
                initState = initState | (1 << i);
            }
        }
        K = Integer.parseInt(br.readLine());
        dp[initState] = 0;
        int answer = Integer.MAX_VALUE;

        for(int state=initState; state<(1<<N); state++) {
            if(dp[state] == Integer.MAX_VALUE) continue;

            if(Integer.bitCount(state) >= K) {
                answer = Math.min(answer, dp[state]);
                continue;
            }

            for(int i=0; i<N; i++) {
                if((state & (1 << i)) != 0) {
                    for(int j=0; j<N; j++) {
                        if(i == j) continue;

                        int nextState = state | (1 << j);
                        dp[nextState] = Math.min(dp[nextState], dp[state] + arr[i][j]);
                    }
                }
            }
        }

        if(answer == Integer.MAX_VALUE) {
            sb.append(-1);
        } else {
            sb.append(answer);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
  000 001 010 011 100 101 110 111
   M   0   M   3   M   5   M   7

3
0 10 11
10 0 12
12 13 0
YNN
1

* */
