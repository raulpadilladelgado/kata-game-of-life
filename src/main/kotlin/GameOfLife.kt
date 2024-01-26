package org.example

class GameOfLife {
    private var cells: Array<Array<Cell>> = Array(10) { Array(10) { Cell.DEAD } }

    fun nextGeneration(): Array<Array<Cell>> {
        cells.indices.forEach { rowIndex ->
            cells[rowIndex].indices.forEach { columnIndex ->
                if (liveNeighboursFrom(rowIndex, columnIndex) < 2) {
                    cells[rowIndex][columnIndex] = Cell.DEAD
                }
                if (liveNeighboursFrom(rowIndex, columnIndex) > 3) {
                    cells[rowIndex][columnIndex] = Cell.DEAD
                }
                if (liveNeighboursFrom(rowIndex, columnIndex) == 3) {
                    cells[rowIndex][columnIndex] = Cell.ALIVE
                }
            }
        }
        return cells
    }

    fun withLiveCellAt(row: Int, colum: Int): GameOfLife {
        cells[row][colum] = Cell.ALIVE
        return this
    }

    private fun liveNeighboursFrom(currentCellRowIndex: Int, currentCellColumnIndex: Int): Int {
        var liveNeighbours = 0
        (currentCellRowIndex - 1..currentCellRowIndex + 1).forEach { rowIndex ->
            (currentCellColumnIndex - 1..currentCellColumnIndex + 1)
                .filter { columnIndex ->
                    isCellIndexInTheBounds(rowIndex, columnIndex)
                            && isNotTheCurrentCell(rowIndex, currentCellRowIndex, columnIndex, currentCellColumnIndex)
                            && isCellAlive(rowIndex, columnIndex)
                }
                .forEach { _ -> liveNeighbours++ }
        }
        return liveNeighbours
    }

    private fun isCellIndexInTheBounds(rowIndex: Int, it: Int) =
        rowIndex in cells.indices && it in cells[rowIndex].indices

    private fun isNotTheCurrentCell(
        rowIndex: Int,
        currentCellRowIndex: Int,
        columnIndex: Int,
        currentCellColumnIndex: Int
    ) = (rowIndex != currentCellRowIndex || columnIndex != currentCellColumnIndex)

    private fun isCellAlive(rowIndex: Int, columnIndex: Int) = cells[rowIndex][columnIndex] == Cell.ALIVE
}

enum class Cell {
    ALIVE, DEAD
}