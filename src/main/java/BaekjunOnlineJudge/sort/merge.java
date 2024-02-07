package BaekjunOnlineJudge.sort;

import java.io.*;
import java.util.StringTokenizer;

public class merge {
    static int[] arr;
    static int[] tmp;

    public static void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lidx = st; // arr[st:mid]에서 값을 보기 위해 사용하는 인덱스
        int ridx = mid; // arr[mid:en]에서 값을 보기 위해 사용하는 인덱스
        for (int i = st; i < en; i++) {
            if (ridx == en) tmp[i] = arr[lidx++];
            else if (lidx == mid) tmp[i] = arr[ridx++];
            else if (arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
            else tmp[i] = arr[ridx++];
        }
        if (en - st >= 0) System.arraycopy(tmp, st, arr, st, en - st);
        // tmp에 임시저장한 값을 arr로 옮김
    }

    public static void mergeSort(int st, int en) {
        if (en - st == 1) return; // 길이 1인 경우는 정렬할 필요가 없음
        int mid = (st + en) / 2;
        mergeSort(st, mid); // st부터 mid-1까지 정렬
        mergeSort(mid, en); // mid부터 en-1까지 정렬
        merge(st, en);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n]; // merge 함수에서 사용할 임시 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n);

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush(); // 버퍼에 남은 데이터를 모두 출력
        bw.close(); // 스트림을 닫음
        br.close(); // 스트림을 닫음
    }
}
