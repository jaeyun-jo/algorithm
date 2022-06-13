import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class 실패율 {
    public static void main(String[] args) {
        int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
        solution(3, stages);
    }

    public static int[] solution(int N, int[] stages) {
        Map<Integer, Long> count = Arrays.stream(stages)
                                         .boxed()
                                         .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Double> stageFailRateMap = new HashMap<>();
        IntStream.range(0, N)
                 .forEach(i -> {
                     double tryCount = 0;
                     for (int j = i + 1; j < stages.length; j++) {
                         tryCount += count.getOrDefault(j, 0L);
                     }
                     if(tryCount == 0) {
                         stageFailRateMap.put(i + 1, 0.0);
                     } else {
                         stageFailRateMap.put(i + 1, count.getOrDefault(i + 1, 0L) / tryCount);
                     }
                 });

       return stageFailRateMap.keySet().stream()
                                       .sorted((o1, o2) -> {
                                           int first = stageFailRateMap.get(o2).compareTo(stageFailRateMap.get(o1));
                                           return first == 0 ? o1.compareTo(o2) : first;
                                       })
                                       .mapToInt(i -> i)
                                       .toArray();
    }
}