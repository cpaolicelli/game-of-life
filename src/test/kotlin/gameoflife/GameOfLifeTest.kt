package gameoflife

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

    val gameOfLife = GameOfLife(arrayOf(arrayOf(true, true, false, true)))

    @Before
    fun setUp() {
    }


    /**
     * Test that the setup method of the board
     * can setup boards of any combination of rows and columns
     */
    @Test
    fun `board can have any number of rows and columns`() {

    }

    /**
     * Test that iterating though a cells neighbours checks all
     * the cells around it without any index out of bounds exceptions
     * Cases: Normal cell, edge cell, corner cell
     */
    @Test
    fun `iterates through neighbours without going out of bounds`() {

    }

    /**
     * Checks that the neighbours a cell checks are its actual neighbours
     * and not any other cell
     */
    @Test
    fun `iterates through all the correct neighbours`() {

    }

    /**
     * Check that every cell is iterated through every tick
     */
    @Test
    fun `iterates through all the cells`() {

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
        val cellState = gameOfLife.checkCellHasLessThanTwoNeighbours(0)
        assert(cellState)
    }

    /**
     * Check if cell will die with more than 3 neighbours
     */
    @Test
    fun `check if cell will die with more than 3 neighbours`(){
        val cellState = gameOfLife.checkCellHasMoreThanThreeNeighbours(0)
        assert(cellState)
    }

    /**
     * Check if cell will survive for the next generation with 2 or 3 live neighbours
     */
    @Test
    fun `check if cell will survive for the next generation with 2 or 3 live neighbours`(){
        val cellState = gameOfLife.checkDeadCellHasThreeNeighbours(0)
        assert(cellState)
    }

}