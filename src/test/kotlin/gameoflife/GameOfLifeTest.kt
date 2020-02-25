package gameoflife

import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * The universe of the Game of Life is an infinite, two-dimensional orthogonal grid of square cells, each of which is
 * in one of two possible states, alive or dead, (or populated and unpopulated, respectively). Every cell interacts
 * with its eight neighbours, which are the cells that are horizontally, vertically, or diagonally adjacent.
 * At each step in time, the following transitions occur:
 *
 * 1) Any live cell with fewer than two live neighbours dies, as if by underpopulation.
 * 2) Any live cell with two or three live neighbours lives on to the next generation.
 * 3) Any live cell with more than three live neighbours dies, as if by overpopulation.
 * 4) Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
 *
 * These rules, which compare the behavior of the automaton to real life, can be condensed into the following:
 *
 * Any live cell with two or three neighbors survives.
 * Any dead cell with three live neighbors becomes a live cell.
 * All other live cells die in the next generation. Similarly, all other dead cells stay dead.
 *
 * The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules
 * simultaneously to every cell in the seed; births and deaths occur simultaneously, and the discrete moment at which
 * this happens is sometimes called a tick. Each generation is a pure function of the preceding one.
 * The rules continue to be applied repeatedly to create further generations.
 */
class GameOfLifeTest {

    private lateinit var gameOfLife: GameOfLife
    val board: Array<Array<Boolean>> = arrayOf(arrayOf(), arrayOf(), arrayOf(), arrayOf(), arrayOf(), arrayOf(),
        arrayOf(), arrayOf())

    @Before
    fun setUp() {
        for (i in 0 until 8) {
            board[i] = arrayOf(false, false, false, false, false, false, false, false)
        }

        gameOfLife = GameOfLife(board)
    }

    /**
     * Checks that getLiveNeighbourCount() counts the correct number of live neighbours
     * and doesn't crash
     */
    @Test
    fun `getLiveNeighbourCount returns the correct number of live neighbours`() {

        val x = 5
        val y = 5

        board[x - 1][y - 1] = true
        board[x][y - 1] = true
        board[x + 1][y] = true

        assertEquals(3, gameOfLife.getLiveNeighbourCount(x, y))
    }

    /**
     * Check if cell should be revived where there is exactly 3 neighbours
     */
    @Test
    fun `test cell revive`(){

    }

    /**
     * Check if cell is going to live in the next iteration,
     * - has exactly 2 neighbours
     */
    @Test
    fun `check if cell will die with less than two neighbours`(){

        val x = 5
        val y = 5

        board[x - 1][y - 1] = true

        val cellState = gameOfLife.getNextGenState(x, y)
        assertEquals(false, cellState)
    }

    /**
     * Check if cell will die with more than 3 neighbours
     */
    @Test
    fun `check if cell will die with more than 3 neighbours`(){
        val x = 5
        val y = 5

        board[x - 1][y - 1] = true
        board[x][y - 1] = true
        board[x + 1][y - 1] = true
        board[x - 1][y] = true

        val cellState = gameOfLife.getNextGenState(x, y)
        assertEquals(false, cellState)
    }

    /**
     * Check if cell will remain the same for the next generation with 2 live neighbours
     */
    @Test
    fun `check if cell will remain the same for the next generation with 2 live neighbours`(){
        val x = 5
        val y = 5

        board[x][y] = false
        board[x - 1][y - 1] = true
        board[x][y - 1] = true

        var cellState = gameOfLife.getNextGenState(x, y)
        assertEquals(false, cellState)

        board[x][y] = true
        cellState = gameOfLife.getNextGenState(x, y)
        assertEquals(true, cellState)
    }


}