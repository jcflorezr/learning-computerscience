package net.learning.computerscience.datastructures.topic_6_trees.topic_6_1_binary_heaps.p4_find_the_running_median

import org.junit.Test

import org.junit.Assert.*

class SolutionTest {

    val DELTA = 1e-15

    @Test
    fun findTheRunningMedian1() {
        val solution = Solution()
        val result1 = solution.findTheRunningMedian(mutableListOf(), 12)
        assertEquals(12.0, result1.median, DELTA)
        val result2 = solution.findTheRunningMedian(result1.elements.toMutableList(), 4)
        assertEquals(8.0, result2.median, DELTA)
        val result3 = solution.findTheRunningMedian(result2.elements.toMutableList(), 5)
        assertEquals(5.0, result3.median, DELTA)
        val result4 = solution.findTheRunningMedian(result3.elements.toMutableList(), 3)
        assertEquals(4.5, result4.median, DELTA)
        val result5 = solution.findTheRunningMedian(result4.elements.toMutableList(), 8)
        assertEquals(5.0, result5.median, DELTA)
        val result6 = solution.findTheRunningMedian(result5.elements.toMutableList(), 7)
        assertEquals(6.0, result6.median, DELTA)
    }

    @Test
    fun findTheRunningMedian2() {
        val solution = Solution()
        val result1 = solution.findTheRunningMedian(mutableListOf(), 1)
        assertEquals(1.0, result1.median, DELTA)
        val result2 = solution.findTheRunningMedian(result1.elements.toMutableList(), 2)
        assertEquals(1.5, result2.median, DELTA)
        val result3 = solution.findTheRunningMedian(result2.elements.toMutableList(), 3)
        assertEquals(2.0, result3.median, DELTA)
        val result4 = solution.findTheRunningMedian(result3.elements.toMutableList(), 4)
        assertEquals(2.5, result4.median, DELTA)
        val result5 = solution.findTheRunningMedian(result4.elements.toMutableList(), 5)
        assertEquals(3.0, result5.median, DELTA)
        val result6 = solution.findTheRunningMedian(result5.elements.toMutableList(), 6)
        assertEquals(3.5, result6.median, DELTA)
        val result7 = solution.findTheRunningMedian(result6.elements.toMutableList(), 7)
        assertEquals(4.0, result7.median, DELTA)
        val result8 = solution.findTheRunningMedian(result7.elements.toMutableList(), 8)
        assertEquals(4.5, result8.median, DELTA)
        val result9 = solution.findTheRunningMedian(result8.elements.toMutableList(), 9)
        assertEquals(5.0, result9.median, DELTA)
        val result10 = solution.findTheRunningMedian(result9.elements.toMutableList(), 10)
        assertEquals(5.5, result10.median, DELTA)
    }
}