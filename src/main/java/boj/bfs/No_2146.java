package boj.bfs;

import java.util.*;

public class No_2146 {
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int[][] map;
    static int[][] group;
    static int[][] dist;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        group = new int[N][N];
        dist = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int cnt = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] == 1 && group[i][j] == 0){
                    Queue<int[]> q = new LinkedList<int[]>();
                    group[i][j] = cnt;
                    q.offer(new int[] {i,j});
                    while(!q.isEmpty()){
                        int cur[] = q.poll();
                        for(int dir=0; dir<4; dir++){
                            int nx = cur[0] + dx[dir];
                            int ny = cur[1] + dy[dir];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                            if(map[nx][ny] == 1 && group[nx][ny] == 0){
                                q.offer(new int[] {nx,ny});
                                group[nx][ny] = cnt;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }

        int result = -1;
        for(int z=0; z<cnt-1; z++){
            Queue<int[]> q = new LinkedList<int[]>();
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(group[i][j] == z+1){
                        dist[i][j] = 0;
                        q.offer(new int[] {i,j});
                    } else {
                        dist[i][j] = -1;
                    }
                }
            }

            while(!q.isEmpty()){
                int cur[] = q.poll();
                for(int dir=0; dir<4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(group[nx][ny] == 0){
                        dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                        group[nx][ny] = z+1;
                        q.offer(new int[] {nx,ny});
                    } else if(group[nx][ny] != z+1){
                        if(result == -1 || result > dist[cur[0]][cur[1]] + dist[nx][ny])
                            result = dist[cur[0]][cur[1]] + dist[nx][ny];
                    }
                }
            }
        }
        System.out.println(result);
    }
}
