/**
 * https://programmers.co.kr/learn/courses/30/lessons/12943?language=java
 */
public class 콜라츠추측 {

    public static void main(String[] args) {
        solution(626331);
    }

    public static int solution(int num) {
        int answer = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = (num * 3) + 1;
            }
            ++answer;
            if(answer > 480) {
                System.out.println(answer+","+num);
            }
            if(answer == 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}
