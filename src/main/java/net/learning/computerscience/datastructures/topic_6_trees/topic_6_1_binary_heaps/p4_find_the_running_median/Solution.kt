package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p4_find_the_running_median;

import java.util.*

class Solution {

    fun findTheRunningMedian(currentElements: MutableList<Int>, newElement: Int) : Pair {
        val minHeap = PriorityQueue<Int>()
        val maxHeap = PriorityQueue<Int>(kotlin.Comparator { o1, o2 -> o2 - o1 })
        val midElement = when {
            currentElements.isEmpty() -> newElement
            else -> currentElements[currentElements.size / 2]
        }
        currentElements.add(newElement)
        currentElements
            .filter { it != midElement }
            .forEach {
                when {
                    it > midElement -> minHeap.offer(it)
                    it < midElement -> maxHeap.offer(it)
                }
            }
        when {
            maxHeap.size < minHeap.size -> maxHeap.offer(midElement)
            else -> minHeap.offer(midElement)
        }
        val runningMedian = when {
            (minHeap.size + maxHeap.size) % 2 == 0 -> ((minHeap.peek().toDouble() + maxHeap.peek().toDouble()) / 2)
            else -> when {
                minHeap.size > maxHeap.size -> minHeap.peek().toDouble()
                else -> maxHeap.peek().toDouble()
            }
        }

        val newElements = ArrayDeque<Int>()
        while (minHeap.isNotEmpty()) {
            newElements.addLast(minHeap.poll())
        }
        while (maxHeap.isNotEmpty()) {
            newElements.addFirst(maxHeap.poll())
        }

        return Pair(elements = newElements.toList(), median = runningMedian)

    }

}

data class Pair(
    val elements: List<Int>,
    val median: Double
)