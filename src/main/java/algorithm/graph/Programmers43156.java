package algorithm.graph;

public class Programmers43156 {
    public int solution(int[] numbers, int target) {
        return answer;
    }

    // 재귀함수 DFS 를 할 예정이라, 정답을 클래스 단위에서 관리
    private int answer = 0;

    // 재귀함수 DFS
    public void dfs(
            // 내가 사용할 숫자들
            int[] numbers,
            // 내가 다음에 사용할 차례의 숫자
            // 이번 DFS 호출에서 더하거나 빼거나 할 숫자는 numbers[next]
            int next,
            // 목표 값
            int target,
            // 이번 재귀까지 합한 값
            int sum
    ) {
        // 어느 시점에 멈출까?
        if(next == numbers.length) {
            // sum 이 target 과 같은지 확인.
        }
        // 더한 후 다음 숫자 결정
        dfs(numbers, next + 1, target, sum + numbers[next]);
        // 뺀 후 다음 숫자 결정
        dfs(numbers, next + 1, target, sum - numbers[next]);
    }

    public static void main(String[] args) {


    }
}
