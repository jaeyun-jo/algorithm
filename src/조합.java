import java.util.Arrays;

public class 조합 {
    int r = 3;
    int[] arr = { 1, 2, 3, 4, 5 };
    int[] result = new int[r];

    public static void main(String[] args) {
        new 조합().combination(0, 0);
    }

    public void combination(int depth, int startIndex) {
        if (depth == r) {
            Arrays.stream(result).forEach(System.out::print);
            System.out.println();
            return;
        }
        for (int i = startIndex; i < arr.length; i++) {
            result[depth] = arr[i];
            combination(depth + 1, i + 1);
        }
    }
}
