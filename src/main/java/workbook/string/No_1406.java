package workbook.string;

import java.io.*;
import java.util.*;

public class No_1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<Character>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        //index 변수를 이용해 cursor의 위치를 다루고자 함
        int index = list.size(); //처음 시작시 커서는 문장의 맨 뒤에서 시작해야함 (ex. abc|)

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);

            switch(c) {
                case 'L':
                    if(index != 0) {
                        index = index - 1;
                    }

                    break;
                case 'D':
                    if(index != list.size()) {
                        index = index + 1;
                    }

                    break;
                case 'B':
                    if(index != 0) {
                        list.remove(index-1);
                        index--;
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    list.add(index, t);
                    index++;

                    break;
                default:
                    break;
            }
        }
        for(Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }
}
