package gameoflife

import java.lang.IndexOutOfBoundsException

/**
 * Main game state class that does stuff with the game
 */
class GameOfLife(
    val board: Array<Array<Boolean>>
) {
    /**
     * Return @param true if the cell has < 2 neighbours
     */
    fun checkCellHasLessThanTwoNeighbours(position: Int): Boolean {
        return true
    }

    /**
     * Return @param true if the cell has > 3 neighbours
     */
    fun checkCellHasMoreThanThreeNeighbours(position: Int): Boolean {
        return true
    }

    /**
     * Return @param true if the cell has == 3 neighbours
     */
    fun checkDeadCellHasThreeNeighbours(position: Int): Boolean {
        return true
    }

    /**
     * Iterate through a cell's neighbours and get the number of live cells
     * @return [Int] value of live cells around board item
     */
    fun getLiveNeighbourCount(x: Int, y: Int): Int {
        var liveCount = 0

        val xOffsets = mutableListOf<Int>()
        xOffsets.add(x-1)
        xOffsets.add(x)
        xOffsets.add(x+1)
        xOffsets.add(x-1)
        xOffsets.add(x+1)
        xOffsets.add(x-1)
        xOffsets.add(x)
        xOffsets.add(x+1)

        val yOffsets = mutableListOf<Int>()
        yOffsets.add(y-1)
        yOffsets.add(y-1)
        yOffsets.add(y-1)
        yOffsets.add(y)
        yOffsets.add(y)
        yOffsets.add(y+1)
        yOffsets.add(y+1)
        yOffsets.add(y+1)

        for (i in 0 until 8) {
            try {
                if (board[xOffsets[i]][yOffsets[i]]) liveCount++
            } catch (e: IndexOutOfBoundsException) {
                e.printStackTrace()
            }
        }

        return liveCount
    }

    /**
     * Determine a cell's state for the next generation based on the number of neighbours it has
     */
    fun getNextGenState(x: Int, y: Int): Boolean {
        val neighbours = getLiveNeighbourCount(x, y)

        return when {
            neighbours < 2 -> false
            neighbours > 3 -> false
            neighbours == 3 -> true
            else -> board[x][y]
        }
    }

}