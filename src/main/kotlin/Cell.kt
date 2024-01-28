package org.example

import org.example.CellStatus.ALIVE
import org.example.CellStatus.DEAD

data class Cell(private var status: CellStatus = DEAD) {
    fun regenerate(liveNeighbours: Int) {
        if (liveNeighbours < 2) {
            status = DEAD
        }
        if (liveNeighbours > 3) {
            status = DEAD
        }
        if (liveNeighbours == 3) {
            status = ALIVE
        }
    }

    fun isAlive() = status == ALIVE
}

enum class CellStatus {
    ALIVE, DEAD
}