import kotlin.collections.mutableListOf

abstract class State(
    var boarderSize: Int = 0 ,
) {
    var cost: Int = 0
    var queens: MutableList<Queen> = mutableListOf()
    init{
        repeat(boarderSize) { queens.add(Queen()) }
    }

    abstract fun  getNextState(): State?

     fun calculateCost(): Int{
        cost =0
        for (i in 0 until boarderSize) {
            for (j in 0 until boarderSize) {
                if (i == j) continue
                if (queens[i].xIndex == queens[j].xIndex // the same row
                    || queens[i].yIndex == queens[j].yIndex // the same column
                    || queens[i].xIndex - queens[j].xIndex == queens[i].yIndex - queens[j].xIndex // the same diagonal
                    || queens[i].xIndex - queens[j].xIndex == queens[j].yIndex - queens[j].yIndex // the same counter diagonal
                ) {
                    cost++
                }
            }
        }
        cost /= 2
        return cost
    }
}