package 기능개발

import java.util.*
import java.util.stream.Collectors
import java.util.stream.IntStream
import kotlin.math.ceil

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
 */

fun main(args: Array<String>) {
    기능개발_Kotlin().solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1))
}

class 기능개발_Kotlin {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val requiredDays = LinkedList(IntStream.range(0, progresses.size)
                .mapToLong { ceil((100 - progresses[it]) / speeds[it].toDouble()).toLong() }
                .boxed()
                .collect(Collectors.toList()))

        val result = mutableListOf<Int>()
        while (requiredDays.isNotEmpty()) {
            val beforeCount = requiredDays.size
            deployProgress(requiredDays.poll(), requiredDays)
            result.add(beforeCount - requiredDays.size)
        }
        return result.toIntArray()
    }

    private fun deployProgress(targetDay: Long, requiredDays: Queue<Long>) {
        run {
            repeat(requiredDays.size) {
                if (targetDay >= requiredDays.peek()) {
                    requiredDays.poll()
                } else {
                    return@run
                }
            }
        }
    }
}