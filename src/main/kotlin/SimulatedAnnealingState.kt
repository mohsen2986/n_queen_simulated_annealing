
class SimulatedAnnealingState: State {
    constructor(boarderSize: Int ):super(boarderSize){
        for (i in 0 until boarderSize) {
            queens[i] = Queen(i, generateRandomPosition())
        }
    }
    constructor(boarderSize: Int , queens: MutableList<Queen>):super(boarderSize){
        this.queens = queens
        cost = 0;
    }

    fun generateRandomPosition() = (0..boarderSize).random()

    override fun getNextState(): State {
        var newQueens: MutableList<Queen> = mutableListOf()
        repeat(boarderSize) { newQueens.add(Queen())}

        var rand = generateRandomPosition()
        for( i in 0 until boarderSize){
            newQueens[i] = Queen(queens[i].xIndex, queens[i].yIndex)
            if(rand == i){
                var temp = generateRandomPosition()
                while (temp == queens[i].yIndex){
                    temp = generateRandomPosition()
                }
                newQueens[i] = Queen(queens[i].xIndex, temp)
            }
        }
        return SimulatedAnnealingState(boarderSize , newQueens)
    }

}