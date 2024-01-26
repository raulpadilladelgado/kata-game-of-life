import org.example.Cell
import org.example.GameOfLife
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class GameOfLifeShould {

    @Test
    fun `kill a live cell with less than two live neighbours`() {
        val gameOfLife = GameOfLife()
            .withLiveCellAt(0, 0)
            .withLiveCellAt(0, 1)

        val cells = gameOfLife.nextGeneration()

        assertEquals(Cell.DEAD, cells[0][0])
    }

    @Test
    fun `kill a live cell with more than three live neighbours`() {
        val gameOfLife = GameOfLife()
            .withLiveCellAt(0, 0)
            .withLiveCellAt(0, 1)
            .withLiveCellAt(0, 2)
            .withLiveCellAt(1, 0)
            .withLiveCellAt(1, 1)

        val cells = gameOfLife.nextGeneration()

        assertEquals(Cell.DEAD, cells[0][1])
    }

    @Test
    fun `keep alive cells with two or three live neighbours`() {
        val gameOfLife = GameOfLife()
            .withLiveCellAt(0, 0)
            .withLiveCellAt(0, 1)
            .withLiveCellAt(1, 0)

        val cells = gameOfLife.nextGeneration()

        assertEquals(Cell.ALIVE, cells[0][0])
    }

    @Test
    fun `make a dead cell alive with three live neighbours`() {
        val gameOfLife = GameOfLife()
            .withLiveCellAt(0, 1)
            .withLiveCellAt(1, 0)
            .withLiveCellAt(1, 1)

        val cells = gameOfLife.nextGeneration()

        assertEquals(Cell.ALIVE, cells[0][0])
    }
}