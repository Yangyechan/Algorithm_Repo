package BaekjunOnlineJudge.recurrence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No_17478 {
    static StringBuilder sb;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        n = Integer.parseInt(br.readLine());
        func(0);
        sb.append("라고 답변하였지.");
        System.out.println(sb);
    }
    static void func(int cnt) {
        String str = "";
        for (int i = 0; i < cnt * 4; i++) {
            str += '_';
        }
        sb.append(str + "\"재귀함수가 뭔가요?\"\n");
        if (cnt == n) {
            sb.append(str + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            return;
        }
        sb.append(str + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n" +
                str + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n" +
                str + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        int now = cnt+1;
        func(now);
        sb.append(str + "____" + "라고 답변하였지.\n");
    }
}
