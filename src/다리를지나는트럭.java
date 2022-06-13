import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42583
 */
public class 다리를지나는트럭 {
    public static void main(String[] args) {
        int[] trucks = {7, 4, 5, 6};
        new 다리를지나는트럭().solution(2, 10, trucks);
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = Arrays.stream(truck_weights).boxed().collect(Collectors.toCollection(LinkedBlockingQueue::new));
        Deque<Integer> bridge = IntStream.range(0, bridge_length)
                                         .boxed()
                                         .map(i -> 0)
                                         .collect(Collectors.toCollection(LinkedBlockingDeque::new));
        int elapseSec = 0;
        int currentWeight = 0;
        do {
            currentWeight -= bridge.pollFirst();
            int truck = trucks.peek() == null ? 0 : trucks.peek();
            if (truck == 0 || truck + currentWeight > weight) {
                bridge.addLast(0);
            } else {
                bridge.addLast(trucks.poll());
                currentWeight += truck;
            }
            ++elapseSec;
        } while (!trucks.isEmpty() || currentWeight != 0);

        return elapseSec;
    }
}
