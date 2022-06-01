import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12915
 */
public class 문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        solution(strings, 2);
    }

    public static String[] solution(String[] strings, int n) {
        return Arrays.stream(strings)
                     .sorted((a, b) -> {
                         int first = a.split("")[n].compareTo(b.split("")[n]);
                         if (first == 0) {
                             return a.compareTo(b);
                         } else {
                             return first;
                         }
                     })
                     .toArray(String[]::new);
    }
}
