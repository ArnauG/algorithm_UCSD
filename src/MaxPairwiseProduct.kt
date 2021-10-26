import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.StringTokenizer

fun getMaxPairwiseProduct(numbers: LongArray): Long {
    var result = 0L
    val n = numbers.size
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (numbers[i] * numbers[j] > result) {
                result = numbers[i] * numbers[j]
            }
        }
    }
    return result
}

fun getMaxPairwiseProductFast(numbers: LongArray): Long {
    var highestNumber = 0L
    var secondHighestNumber = 0L

    numbers.forEach { number ->
        if (number >= highestNumber) {
            secondHighestNumber = highestNumber
            highestNumber = number
        } else if (number > secondHighestNumber) {
            secondHighestNumber = number
        }
    }

    return highestNumber * secondHighestNumber
}

fun main(args: Array<String>) {
    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val numbers = LongArray(n)
    for (i in 0 until n) {
        numbers[i] = scanner.nextInt().toLong()
    }
    println(getMaxPairwiseProductFast(numbers))
}

class FastScanner(stream: InputStream) {
    var br: BufferedReader = BufferedReader(InputStreamReader(stream))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt() = next().toInt()
}