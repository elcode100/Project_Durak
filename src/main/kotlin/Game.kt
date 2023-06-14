open class Game : Player(name = "Huan Tan") {



    fun mixCards(): MutableList<String> {

        val mixing: MutableList<String> = CARD_DECK.toMutableList()
        mixing.shuffle()
        return mixing

    }


    fun drawCards() {


        val deck = mixCards()
        for (sixCards in 1..6) {

            println(deck[sixCards])
        }
    }


}