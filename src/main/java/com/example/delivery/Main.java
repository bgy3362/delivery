import java.io.*;
import java.util.*;

class Main {
    static int N, L;
    static ArrayDeque<int[]> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            int k = Integer.parseInt(st.nextToken());

            while(!q.isEmpty() && q.peek()[0] <= (i-L)) {
                q.poll();
            }

            while(!q.isEmpty() && q.peekLast()[1] > k) {
                q.pollLast();
            }

            q.offer(new int[]{i, k});

            sb.append(q.peek()[1]).append(" ");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

/*
1 5 2 3 6 2 3 7 3 5 2 6
(인덱스, 값)
1. 인덱스 TTL 지난얘들 out
2. 들어갈 때 큰얘들은 다 뺴도됌
3. [0] 출력

0[1] 1
1[1 5] 1
2[1 2] 1
3[2 3] 2
[2 3 6] 2
[2] 2
[2 3] 2
[2 3 7] 2
[3 3] 3
[7 3 5] 3
[3 5 2] 2
[5 2 6] 2

* */