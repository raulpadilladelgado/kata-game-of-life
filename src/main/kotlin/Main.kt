package org.example

import java.lang.Thread.sleep

fun main() {
    var gameOfLife = GameOfLife().withRandomLiveCells()
    while (true) {
        gameOfLife = gameOfLife.from(gameOfLife.nextGeneration())
        println("=====================================")
        println(gameOfLife)
        sleep(1000)
    }
}