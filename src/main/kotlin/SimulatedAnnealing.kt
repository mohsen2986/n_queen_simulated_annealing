import kotlin.math.exp

class SimulatedAnnealing(
    boarderSize: Int ,
    tollerence: Int ,
    tempreture: Double
): NQueen(boarderSize , tollerence) {
    var tempreture = tempreture
    init {
        currentState = SimulatedAnnealingState(boarderSize)
    }

    override fun solve() {
        while (!isSolvedPosition(currentState!!)) {
            var temperature: Double = tempreture
            var delta: Double
            var probability: Double
            var rand: Double


            while (temperature > 0 && (currentState?.calculateCost() !== 0)) {
                nextState = currentState!!.getNextState()
                delta = (currentState?.calculateCost()!! - nextState?.calculateCost()!!).toDouble()
                probability = exp(delta / temperature)
                rand = Math.random()

                if (delta > 0) {
                    currentState = nextState
                } else if (rand <= probability) {
                    currentState = nextState
                }
                temperature--
            }
        }
    }
}