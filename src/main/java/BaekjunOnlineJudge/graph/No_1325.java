package BaekjunOnlineJudge.graph;
import java.io.*;
import java.util.*;

public class No_1325 {
    static int n,m,a,b;
    static ArrayList<Integer>[] list;
    static boolean visit [];
    static int depth[];
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        list=new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
            list[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<m;i++) {
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        depth=new int[n+1];

        for(int i=1;i<=n;i++) {
            visit=new boolean[n+1];
            Queue <Integer>queue=new LinkedList<Integer>();
            queue.add(i);
            visit[i]=true;
            while(!queue.isEmpty()) {
                int n=queue.poll();
                for(int date:list[n]) {
                    if(!visit[date]) {
                        queue.add(date);
                        visit[date]=true;
                        depth[date]++;
                    }

                }
            }

        }
        max=0;
        for(int date:depth) {
            max=Math.max(max, date);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++) {
            if(depth[i]==max) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb);
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class com implements Comparable<com> {
//    int num, cnt;
//
//    com(int num, int cnt) {
//        this.num = num;
//        this.cnt = cnt;
//    }
//
//    @Override
//    public int compareTo(com o) {
//        if (cnt == o.cnt) {
//            return num - o.num;
//        }
//        return o.cnt - cnt;
//    }
//}
//public class No_1325 {
//    static List<List<Integer>> lists = new ArrayList<>();
//    static boolean[] visited;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String[] input = br.readLine().split(" ");
//        int N = Integer.parseInt(input[0]);
//        int M = Integer.parseInt(input[1]);
//
//        for (int i = 0; i <= N; i++) {
//            lists.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < M; i++) {
//            String[] input2 = br.readLine().split(" ");
//            int a = Integer.parseInt(input2[0]);
//            int b = Integer.parseInt(input2[1]);
//
//            lists.get(b).add(a);
//        }
//
//        PriorityQueue<com> pq = new PriorityQueue<>();
//        for (int i = 1; i <= N; i++) {
//            visited = new boolean[N + 1];
//            pq.offer(new com(i, BFS(i)));
//        }
//
//        StringBuilder sb = new StringBuilder();
//        int minCnt = pq.peek().cnt;
//        while (!pq.isEmpty()) {
//            com tmp = pq.poll();
//            if (tmp.cnt == minCnt) {
//                sb.append(tmp.num + " ");
//            }
//        }
//        System.out.println(sb);
//    }
//    static int BFS(int x) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.offer(x);
//        visited[x] = true;
//        int cnt = 0;
//
//        while (!queue.isEmpty()) {
//            int now = queue.poll();
//            for (int i = 0; i < lists.get(now).size(); i++) {
//                if (!visited[lists.get(now).get(i)]) {
//                    visited[lists.get(now).get(i)] = true;
//                    cnt++;
//                    queue.offer(lists.get(now).get(i));
//                }
//            }
//        }
//        return cnt;
//    }
//}
