package durakfinal2

// IMPORT, UM DEN ANFANGS-ANGREIFER ZU BESTIMMEN
// IMPORT, UM DEN ANFANGS-ANGREIFER ZU BESTIMMEN
import kotlin.random.Random


fun waiting() {

   Thread.sleep(1000)

}

fun game() {


    val cardsDeck = Deck()
    cardsDeck.mixCards()
    val mixedCards = cardsDeck.deck.toList()
    val trump = cardsDeck.randomTrump()



    println("------------------------------")
    println("⭐️ DAS SPIEL DURAK BEGINNT ⭐️")
    println("------------------------------")

    println("\nDer Kartenstapel ♠️ ♣️ ♥️ ♦️ aus ${mixedCards.size} Karten wird gemischt...")

    waiting()

    // SPIELSTART
    println("Jeder Spieler zieht 6 zufällige Karten aus dem Kartenstapel und eine zufällige Trumpfkarte wird aufgedeckt an unterster Stelle des Decks gelegt.")
    waiting()
    println("Deine Karte musste du per Zahleneingabe entsprechend der Karte auswählen und mit ENTER bestätigen.")
    waiting()



    println("\n---------------------")
    println("\u001b[1mTRUMPF\u001b[0m: $trump")
    println("---------------------")


    // ZUFÄLLIGER SPIELER WIRD FÜR DEN SPIELBEGINN GENERIERT
    val players = listOf(
        Player("\u001B[1;93mHuan Tan\u001B[0m"),
        Player("\u001B[1;36mAnna Nass\u001B[0m")
    ).shuffled(Random.Default)

    val player1 = players[0]
    val player2 = players[1]

    for (i in 0..5) {
        player1.drawCard(cardsDeck)
        player2.drawCard(cardsDeck)
    }

    var deckEmpty = false
    var attacker: Player = player1
    var defender: Player = player2

    waiting()
    // VERBLEIBENDE KARTEN IM DECK
    println("\nVerbleibende Karten im Deck (${cardsDeck.deck.size})")
    waiting()
    while (!player1.hasNoCards() && !player2.hasNoCards()) {


        println("TEST1")
        if (attacker.hasNoCards() || defender.hasNoCards()) {
            break
        }

        var attackingCard = attacker.attack(defender, trump, cardsDeck)

        while (attackingCard != null) {
            val defendingCard = defender.defend(attackingCard, trump, cardsDeck, attackingCard)

            if (defendingCard != null) {
                // VERTEIDIGUNG ERFOLGREICH



                println("\nTEST2")

                // VERBLEIBENDE KARTEN IM DECK
                /*println("\nVerbleibende Karten im Deck (${cardsDeck.deck.size})")
                println("RESTDECK2")*/

                // ÜBERPRÜFEN, OB DER VERTEIDIGER NOCH KARTEN ZUM ANGREIFEN HAT
                if (defender.canDefend(attackingCard, trump)) {


                    // WECHSEL ZWISCHEN ANGREIFER UND VERTEIDIGER
                    val temp = attacker
                    attacker = defender
                    defender = temp

                    /*if (player1.hasNoCards()) {
                        println("\nSpieler ${player1.name} HAT GEWONNEN! TEST1")
                    } else if (player2.hasNoCards()) {
                        println("\nSpieler ${player2.name} HAT GEWONNEN! TEST1")
                    } else {
                        println("\nUNENTSCHIEDEN  TEST1.")
                    }*/




                } else {
                    val temp = attacker
                    attacker = defender
                    defender = temp



                    if (player1.hasNoCards()) {
                        println("\nSpieler ${player1.name} HAT GEWONNEN!  TEST2")
                    } else if (player2.hasNoCards()) {
                        println("\nSpieler ${player2.name} HAT GEWONNEN! TEST2")
                    } else {
                        println("\nUNENTSCHIEDEN. TEST2")
                    }

                }
            }



            if (cardsDeck.deck.isEmpty() && !deckEmpty) {
                println("❗DAS DECK IST LEER❗")
                deckEmpty = true
            }



            attackingCard = attacker.attack(defender, trump, cardsDeck)
        }


        if (cardsDeck.deck.isEmpty() && !deckEmpty) {
            println("❗DAS DECK IST LEER❗")
            deckEmpty = true
        }


        // AUFFÜLLEN DER HANDKARTEN NACH VERWENDUNG
        attacker.handReplenish(cardsDeck)
        defender.handReplenish(cardsDeck)


        // WECHSEL ZWISCHEN ANGREIFER UND VERTEIDIGER
        val temp = attacker
        attacker = defender
        defender = temp





    }
    if (player1.hasNoCards()) {
        println("\nSpieler ${player1.name} HAT GEWONNEN! TEST3")
    } else if (player2.hasNoCards()) {
        println("\nSpieler ${player2.name} HAT GEWONNEN! TEST3")
    } else {
        println("\nUNENTSCHIEDEN. TEST3")
    }


}