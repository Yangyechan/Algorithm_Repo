package boj.stackAndQueue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String p = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String s = br.readLine();
            String s1 = s.substring(1,s.length() - 1);
            String[] strlist = s1.split(",");
            for (int j = 0; j < len; j++) {
                deque.offer(Integer.parseInt(strlist[j]));
            }

            int flag = 0;
            for (int j = 0; j < p.length(); j++) {
                if (deque.isEmpty() && p.charAt(j) == 'D') {
                    //System.out.println("error");
                    sb.append("error\n");
                    //bw.write("error\n");
                    flag = 2;
                    break;
                }
                if(p.charAt(j) == 'R') {
                    if (flag == 0) {
                        flag = 1;
                    }else {
                        flag = 0;
                    }
                } else if (flag == 0 && p.charAt(j) == 'D') {
                    deque.pollFirst();
                } else if (flag == 1 && p.charAt(j) == 'D')  {
                    deque.pollLast();
                }
            }
            int[] arr = new int[deque.size()];
            int size = deque.size();
            if (flag == 2) {
                continue;
            }
            if (!deque.isEmpty()) {
                if (flag == 0) {
                    for (int j = 0; j < size; j++) {
                        arr[j] = deque.pollFirst();
                    }
                }else {
                    for (int j = 0; j < size; j++) {
                        arr[j] = deque.pollLast();
                    }
                }
                if (arr.length == 1) {
                    //System.out.println("[" + arr[0] + "]");
                    sb.append("[" + arr[0] + "]\n");
                    continue;
                }
                for (int j = 0; j < arr.length; j++) {
                    if (j == 0) {
                        //System.out.print("[" + arr[j]);
                        sb.append("[" + arr[j]);
                    } else if (j == arr.length - 1) {
                        //System.out.println("," + arr[j] + "]");
                        sb.append("," + arr[j] + "]\n");
                    } else {
                        //System.out.print("," + arr[j]);
                        sb.append("," + arr[j]);
                    }
                }
            }else {
                //System.out.println("[]");
                sb.append("[]");
            }
        }
        System.out.println(sb);
    }
}
