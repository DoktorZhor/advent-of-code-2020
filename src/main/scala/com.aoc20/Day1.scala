package com.aoc20

import scala.io.Source

object Day1 extends App{
    val input: List[Int] = Source.fromResource("day1.txt").getLines().map(_.toInt).toList

    println(solve(2))
    println(solve(3))

    def solve(n: Int): Option[Int] = {
        val pairs = input.combinations(n)
        pairs.filter(_.sum == 2020).map(_.foldLeft(1)(_ * _)).toList.headOption
    }
}