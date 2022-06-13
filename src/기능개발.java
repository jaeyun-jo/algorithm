import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 기능개발 {
    public static void main(String[] args) {
        int[] p = { 40, 93, 30, 55, 60, 65 };
        int[] s = { 60, 1, 30, 5, 10, 7 };
        solution(p, s);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Long> completedDays = IntStream.range(0, progresses.length).mapToLong(i -> (long) Math.ceil((100 - progresses[i]) / (double) speeds[i]))
                                             .boxed()
                                             .collect(Collectors.toCollection(LinkedBlockingQueue::new));
        List<Integer> result = new ArrayList<>();
        while (!completedDays.isEmpty()) {
            int deployCount = 1;
            Long day = completedDays.poll();
            while (!completedDays.isEmpty()) {
                if (day >= completedDays.peek()) {
                    ++deployCount;
                    completedDays.poll();
                } else {
                    break;
                }
            }
            result.add(deployCount);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
