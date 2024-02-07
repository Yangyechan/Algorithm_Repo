package BaekjunOnlineJudge.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_18808 {
    static int n, m, k;
    static int[][] note = new int[40][40];
    static int r, c;
    static int[][] paper = new int[10][10];

    // paper를 90도 회전하는 함수
    static void rotate(){
        int[][] tmp = new int[10][10];

        for(int i = 0; i < r; i++)
            for(int j = 0; j < c; j++)
                tmp[i][j] = paper[i][j];

        for(int i = 0; i < c; i++)
            for(int j = 0; j < r; j++)
                paper[i][j] = tmp[r-1-j][i];

        int swap = r;
        r = c;
        c = swap;
    }

    // note의 (x,y)에 모눈종이의 (0,0)이 올라가게 스티커를 붙일 수 있는지 판단하는 함수. 가능할 경우 note를 갱신한 후 true를 반환.
    static boolean pastable(int x, int y){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(note[x+i][y+j] == 1 && paper[i][j] == 1)
                    return false;
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(paper[i][j] == 1)
                    note[x+i][y+j] = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        while(k-- > 0){
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for(int i = 0; i < r; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < c; j++)
                    paper[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int rot = 0; rot < 4; rot++){
                boolean is_paste = false; // 해당 스티커를 붙였는가?
                for(int x = 0; x <= n-r; x++){
                    if(is_paste) break;
                    for(int y = 0; y <= m-c; y++){
                        if(pastable(x, y)){
                            is_paste = true;
                            break;
                        }
                    }
                }
                if(is_paste) break;
                rotate();
            }
        }
        int cnt = 0;
        for(int i = 0; i < n; i++)
            for(int j = 0; j < m; j++)
                cnt += note[i][j];
        System.out.println(cnt);
    }
}
