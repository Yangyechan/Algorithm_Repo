package algorithm.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PostfixCalculation {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Integer> digiStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);
            if (Character.isDigit(token)){
                //digiStack.push(token)
            }

        }
    }
    public static void main(String[] args) throws IOException {
        new PostfixCalculation().solution();
    }
}
