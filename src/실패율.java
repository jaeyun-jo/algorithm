import java.util.stream.Collectors
import java.util.stream.IntStream

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 */
fun main(args: Array<String>) {
    실패율().solution(8, intArrayOf(1, 2, 3, 4, 5, 6, 7))
}

class 실패율 {
    fun solution(N: Int, stages: IntArray): IntArray {
        return IntStream.range(1, N + 1).mapToObj { s ->
            when (val tryCount = stages.count { it >= s }) {
                0 -> Pair(s, 0.0)
                else -> Pair(s, stages.count { it == s } / tryCount.toDouble())
            }
        }.sorted { o1, o2 ->
            o2.second.compareTo(o1.second)
        }.map {
            it.first
        }.collect(Collectors.toList()).toIntArray()
    }
}
