package com.aoc20

import scala.io.Source

case class InputLine(
    lowerBound: Int,
    upperBound: Int,
    letter: Char,
    password: String
)

object InputLine {
    def fromString(s: String): Option[InputLine] = {
        val inputs = s.split(":").flatMap(_.split(" ").flatMap(_.split("-"))).filterNot(_.isBlank())

        if(inputs.length == 4)
            Some(InputLine(inputs(0).toInt, inputs(1).toInt, inputs(2).charAt(0), inputs(3)))
        else None
    }
}
object Day2 extends App {
    val input= parseInput

    println(solve(isValid))
    println(solve(isValid2))

    def solve(f: InputLine => Boolean): Int = input.map(f(_)).filter(_ == true).length

    private def isValid(line: InputLine): Boolean = {
        val range = line.lowerBound to line.upperBound
        val count = line.password.count(_ == line.letter)
        range.contains(count)
    }

    private def isValid2(line: InputLine): Boolean = {
        line.password.charAt(line.lowerBound - 1) == line.letter ^
        line.password.charAt(line.upperBound - 1) == line.letter
    }

    private def parseInput: List[InputLine] = {
        val rawInput = Source.fromResource("day2.txt").getLines().toList
        val parsed = rawInput.map((InputLine.fromString(_))).flatten

        if(parsed.length != rawInput.length)
            throw new RuntimeException("Failed to parse all input records")
        else
            parsed
    }
}