package durakfinal2



// KLASSE SPIELER
class Player(val name: String, var balance: Double) {
    var drawnCards: MutableList<Card> = mutableListOf()




    // GIBT TRUE ZURÜCK, WENN DER SPIELER KEINE KARTEN AUF DER HAND HAT, ANDERNFALLS FALSE
    fun hasNoCards(): Boolean {


        return drawnCards.isEmpty()
    }


    // SPIELER ZIEHT EINE KARTE VOM DECK.
    fun drawCard(deck: Deck): Card? {
        if (deck.deck.isNotEmpty()) {
            val card = deck.deck.removeFirst()
            drawnCards.add(card)


        }
        return null

    }


    // SPIELER NIMMT EINE KARTE AUF, DIE ER NICHT SCHLAGEN KANN
    /* private fun takeCard(card: Card, deck: Deck) {
         drawnCards.add(card)
         println("$name kann die Karte [$card] nicht schlagen und muss sie aufnehmen.")




     }*/


    private fun takeCard(cardAttack: Card, deck: Deck) : Card? {
        if (deck.deck.isNotEmpty()) {
            drawnCards.add(cardAttack)
            println("$name kann die Karte [$cardAttack] nicht schlagen und muss sie aufnehmen.")
            println("\nNur Angreifer zieht Karte 🫳 ")  /*Verbleibende Karten im Deck (${deck.deck.size})*/
        }
        return null

    }



// SPIELER ENTFERNT EINE KARTE AUS SEINEN HANDKARTEN
    /*private fun removeCard(card: Card) {
        drawnCards.remove(card)
    }*/


    // AUFFÜLLEN DER HANDKARTEN NACH SPIELZUG
    // KARTEN WERDEN VON DEN VERBLEIBENDEN KARTEN GEZOGEN, WENN DER SPIELER WENIGER ALS 6 KARTEN AUF DER HAND HAT
    fun handReplenish(deck: Deck) {
        while (drawnCards.size < 6) {
            drawCard(deck)

        }
    }


    // ÜBERPRÜFUNG, OB SPIELER EINE KARTE AUF DER HAND HAT, DIE DIE ANGRIFFSKARTE SCHLAGEN KANN
    fun canDefend(attackCard: Card, trump: Card): Boolean {
        for (card in drawnCards) {
            if (card.canDefeat(attackCard, trump)) {
                return true

            }
        }
        //FALSE WIRD ZURÜCKGEGEBEN, WENN SPIELER KEINE KARTE AUF DER HAND HAT, DIE DIE ANGRIFFSKARTE SCHLAGEN KANN
        return false

    }


    // METHODE ANGRIFF
    fun attack(defender: Player, trump: Card, deck: Deck): Card? {

        println("______________________________________________________________________________")
        println("\u001B[1;33m$name\u001B[0m muss \u001B[1;31mANGREIFEN\u001B[0m ⚔️  /  [TRUMPF: $trump]  /  [Karten im Deck: ${deck.deck.size}]")

        for ((index, card) in drawnCards.withIndex()) {




            println("${index + 1}: $card")






        }

        var choice = readln().toInt()
        while (choice !in 1..drawnCards.size) {
            println("Hast du dich vertippt? 😓 Alles gut, einfach erneut eintippen 😮‍💨")
            choice = readln().toInt()

        }

        val attackingCard = drawnCards[choice - 1]
        if (defender.canDefend(attackingCard, trump)) {
            drawnCards.removeAt(choice - 1)
            println("$name greift an mit [$attackingCard]")

            // ZIEHEN EINER KARTE AUS DEN VERBLEIBENDEN KARTEN
            val drawnCardFromRemaining = drawCard(deck)
            if (drawnCardFromRemaining != null) {
                drawnCards.add(drawnCardFromRemaining)
            }

            //RÜCKGABEWERT ANGRIFFSKARTE
            return attackingCard
        } else {

            // VERTEIDIGER MUSS GESPIELTE KARTE AUFNEHMEN, WENN ER SIE NICHT SCHLAGEN KANN ---
            if (this != defender) {
                defender.takeCard(attackingCard, deck)
                val drawnCardFromRemaining = drawCard(deck)
                if (drawnCardFromRemaining != null) {
                    drawnCards.add(drawnCardFromRemaining)
                }
            }
        }
        // GIBT NULL ZURÜCK, WENN SPIELER KEINE KARTE ANGREIFT ODER DIE KARTE NICHT SCHLAGEN KANN
        return null

    }


    // METHODE VERTEIDIGUNG
    fun defend(attackCard: Card, trump: Card, deck: Deck, attacking: Card?): Card? {

        println("\n\u001B[1;36m$name\u001B[0m muss sich \u001B[1;32mVERTEIDIGEN\u001B[0m \uD83D\uDEE1  /  [TRUMPF: $trump]  /  [Karten im Deck: ${deck.deck.size}]")
        println("Wähle per Zahleneingabe deine Karte und bestätige mit Enter:")
        for ((index, card) in drawnCards.withIndex()) {



            println("${index + 1}: $card")






        }

        var choice = readln().toInt()
        while (choice !in 1..drawnCards.size) {
            println("Hast du dich vertippt? 😓 Alles gut, einfach erneut eintippen 😮‍💨")
            choice = readln().toInt()

        }

        val defendingCard = drawnCards[choice - 1]
        if (defendingCard.canDefeat(attackCard, trump)) {
            drawnCards.removeAt(choice - 1)
            println("$name schlägt [${attacking ?: ""}] mit [$defendingCard]")

            // ZIEHEN EINER KARTE AUS DEN VERBLEIBENDEN KARTEN
            val drawnCardFromRemaining = drawCard(deck)
            if (drawnCardFromRemaining != null) {
                drawnCards.add(drawnCardFromRemaining)

            }

            // SPIELER VERTEIDIGT SICH UND GIBT DIE AUSGEWÄHLTE KARTE ZURÜCK
            return defendingCard

        } else {
            // NEUE KARTE AUS ANGRIFFSKARTEN AUFNEHMEN
            // WENN DER SPIELER DIE KARTE NICHT SCHLAGEN KANN, NIMMT ER DIE ANGRIFFSKARTE AUF
            takeCard(attackCard, deck)
            println("----------------------------")


        }


        // GIBT null ZURÜCK, WENN SPIELER KEINE KARTE VERTEIDIGT ODER DIE KARTE NICHT SCHLAGEN KANN.
        return null

    }
}