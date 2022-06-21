package x만큼간격이있는n개의숫자;

import java.util.stream.LongStream;

public class x만큼간격이있는n개의숫자 {
    public static void main(String[] args) {
        solution(2, 5);
    }

    public static long[] solution(int x, int n) {
        return LongStream.range(1, n + 1)
                         .map(i -> x * i)
                         .toArray();
    }
}
