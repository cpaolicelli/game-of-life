package gameoflife

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


}