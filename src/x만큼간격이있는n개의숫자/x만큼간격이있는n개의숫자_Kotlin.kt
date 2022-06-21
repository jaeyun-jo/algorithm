package x만큼간격이있는n개의숫자

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12954
 */
fun main() {
    x만큼간격이있는n개의숫자_Kotlin().solution(2, 5)
}

class x만큼간격이있는n개의숫자_Kotlin {

    fun solution(x: Int, n: Int): LongArray {
        return LongArray(n) { x.toLong() * (it + 1) }
    }
}