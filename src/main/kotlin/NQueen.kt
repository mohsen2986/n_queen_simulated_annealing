
abstract class NQueen(
    protected var boarderSize: Int ,
    protected var tollerenceCost: Int
) {
    protected var currentState: State? = null
    protected var nextState: State? = null

    abstract fun solve()

    fun show(){
        println("Total cost of ${currentState?.cost}")
        var tem= 0
        var queens: MutableList<Queen> = currentState?.queens!!
        var queen = false;
        println()

        for( i in 0 until boarderSize){
            for( j in 0 until boarderSize){
                for(k in 0 until boarderSize){
                    if(i == queens[k].xIndex && j == queens[k].yIndex){
                        queen = true
                        tem = k
                        break
                    }
                }
                if(queen){
                    print("$tem" + "\t")
                    queen = false
                }else{
                    print("*\t")
                }
            }
            println()
        }
    }

    protected fun isSolvedPosition(s: State) =
        s.calculateCost() <= tollerenceCost
}