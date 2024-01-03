package boj.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class No_1707_BipartiteGraph {
    static ArrayList<Integer> stack[];
    static boolean[] visited;
    static int[] checked;
    static boolean isEven;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] str = br.readLine().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            stack = new ArrayList[V+1];
            visited = new boolean[V+1];
            checked = new int[V+1];
            isEven = true;
            for (int j = 1; j <= V; j++) {
                stack[j] = new ArrayList<>();
            }
            for (int j = 1; j <= E; j++) {
                String[] str2 = br.readLine().split(" ");
                int u = Integer.parseInt(str2[0]);
                int v = Integer.parseInt(str2[1]);
                stack[u].add(v);
                stack[v].add(u);
            }
            for (int k = 1; k <= V; k++) {
                if (isEven) {
                    DFS(k);
                }else {
                    break;
                }
            }
            if (isEven) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static void DFS (int start) {
        visited[start] = true;
        for (int target : stack[start]) {
            if (!visited[target]) {
                checked[target] = (checked[start] + 1) % 2;
                DFS(target);
            } else if (checked[start] == checked[target]) {
                isEven = false;
            }
        }
    }
}
//public class No_1707 { // 이분그래프
//
//    // 그래프 데이터 저장 인접리스트
//    static ArrayList<Integer>[] A;
//    static boolean[] visited;
//    static int[] check;
//    static boolean isEven;
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        //입력은 여러 개의 테스트 케이스로 구성되어 있는데, 첫째 줄에 테스트 케이스의 개수 K가 주어진다.
//        int testCase = Integer.parseInt(br.readLine());
//        for( int t=0; t<testCase; t++){
//            //각 테스트 케이스의 첫째 줄에는 그래프의 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다.
//            String[] s = br.readLine().split(" ");
//
//            int V = Integer.parseInt(s[0]);
//            int E = Integer.parseInt(s[1]);
//
//            A = new ArrayList[V+1];
//            visited = new boolean[V+1];
//            check = new int[V+1];
//            isEven = true;
//            for(int i =1; i<=V; i++){
//                A[i] = new ArrayList<Integer>();
//            }
//            // 엣지 데이터 저장하기
//            for(int i=0; i<E; i++){
//                s = br.readLine().split(" ");
//                int start = Integer.parseInt(s[0]);
//                int end = Integer.parseInt(s[1]);
//                A[start].add(end);
//                A[end].add(start);
//            }
//            // 모든 노드에서 DFS 실행해야함/
//            for(int i=1 ; i<=V; i++){
//                if(isEven) {
//                    DFS(i);
//                }else{
//                    break;
//                }
//
//            }
//
//            if(isEven) System.out.println("YES");
//            else System.out.println("NO");
//        }
//
//
//    }
//
//    private static void DFS(int start) {
//        visited[start] = true;
//        for(int i : A[start]){ // 인접리스트로받아서 start에서 연결된 모든노드탑색
//            if(!visited[i]){
//                // 바로 직전에 있는 노드와 다른 집합으로 분류를 해주는것
//                check[i] = (check[start] + 1) % 2; // 1 0 1 0 1 0 으로 인접구분
//                DFS(i);
//            }else if(check[start] == check[i]){
//                isEven=false;
//            }
//        }
//    }
//}
