package BaekjunOnlineJudge.priorityQueue;

import java.util.*;

public class No_1781 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<Integer>[] cnByDeadline = new ArrayList[200002];
        for (int i = 0; i < 200002; i++) {
            cnByDeadline[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            int dl = scanner.nextInt();
            int cn = scanner.nextInt();
            cnByDeadline[dl].add(cn);
        }
        long cupNoodles = 0;
        PriorityQueue<Integer> cnCandidate = new PriorityQueue<>(Comparator.reverseOrder());
        for (int curr = 200000; curr != 0; curr--) {
            for (int noodle : cnByDeadline[curr]) {
                cnCandidate.add(noodle);
            }
            if (!cnCandidate.isEmpty()) {
                cupNoodles += cnCandidate.poll();
            }
        }

        System.out.println(cupNoodles);
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class solve implements Comparable<solve> {
//    int deadline, cup;
//
//    solve(int deadline, int cup) {
//        this.deadline = deadline;
//        this.cup = cup;
//    }
//
//    @Override
//    public int compareTo(solve o) {
//        if (deadline == o.deadline) {
//            return o.cup - cup;
//        }
//        return deadline - o.deadline;
//    }
//}
//public class No_1781 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        PriorityQueue<solve> prePq = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<solve> pq = new PriorityQueue<>();
//
//        for (int i = 0; i < N; i++) {
//            String[] input = br.readLine().split(" ");
//            int deadline = Integer.parseInt(input[0]);
//            int cup = Integer.parseInt(input[1]);
//            pq.offer(new solve(deadline, cup));
//        }
//
//        int time = 0;
//        long ans = 0;
//        while (!pq.isEmpty()) {
//            solve s = pq.poll();
//            prePq.offer(s);
//            if (s.deadline > time) {
//                time++;
//                ans += s.cup;
//            }
//        }
//
//        System.out.println(ans);
//    }
//}
