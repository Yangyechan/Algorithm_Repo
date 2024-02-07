package mutsa.week5.day4;

public class BracketWithoutStack {
    public static void main(String[] args) {
        String brackets = "((((()))))";
        System.out.println(brackets.charAt(0));

        while (brackets.contains("()")) {
            brackets = brackets.replace("()", "");
        }
        if (brackets.length() == 0) {
            System.out.println("올바른 괄호입니다.");
        } else {
            System.out.println("괄호가 아닙니다.");
        }
    }
}
