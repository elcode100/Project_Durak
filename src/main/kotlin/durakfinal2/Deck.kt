package durakfinal2

// KLASSE DECK
class Deck {

    // DECK WIRD MIT 36 KARTEN BEFÜLLT

    var deck: MutableList<Card> = mutableListOf()

    init {
        for (suit in listOf("♠️ Pik", "♣️ Kreuz", "♥️ Herz", "♦️ Karo")) {
            for (value in listOf("Ass", "König", "Dame", "Bube", "10", "9", "8", "7", "6")) {
                deck.add(Card(suit, value))
            }
        }
    }

    // DECK MISCHEN
    fun mixCards() {
        deck.shuffle()
    }

    // ZUFÄLLIGER TRUMPF WIRD AUS DEM DECK GEZOGEN
    fun randomTrump(): Card {
        return deck.removeFirst()
    }

    // VERBLEIBENDE KARTEN IM DECK NACH DEM AUSTEILEN DER KARTEN UND ZUFÄLLIGER AUSGABE DES TRUMPFS
    fun remainingCards(player1: Player, player2: Player): List<String> {

        val allDrawnCards = player1.drawnCards + player2.drawnCards
        val remainingCards = mutableListOf<String>()

        for (card in deck) {
            val cards = "${card.suit} ${card.value}"
            if (cards !in allDrawnCards.map { it.toString() }) {
                remainingCards.add(cards)
            }
        }

        return remainingCards
    }
//METHODE NICHT MEHR VERWENDET

}