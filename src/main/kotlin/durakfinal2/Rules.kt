package durakfinal2


// ALLGEMEINE INFO: ES IST EINE LIGHT VERSION VON DURAK, DA NICHT ALLE REGELN EINGEBAUT SIND. WIE Z.B.
//MEHRERE KARTEN GLEICHZEITIG SPIELEN. DIE TRUMPFKARTE WIRD AM ENDE LEIDER AUCH NICHT MEHR GESPIELT. SIE IST
//NUR ZUFÄLLIG AUSGEWÄHLT, DAMIT MAN EIN TRUMPF IM SPIEL HAT

// LEIDER GIBT ES AUCH EINIGE SPIELLOGIK-FEHLER IM LAUFE DES SPIELS UND BEI EINEM NEUSTART DES SPIELS,
//WENN MAN SCHON EINE PARTIE GESPIELT HAT, WERDEN DIE KARTEN IRGENDWO ZWISCHENGESPEICHERT UND BEI EINEM NEUSTART
//OHNE BEENDEN DES PROGRAMMS WERDEN MEHR ALS 6 KARTEN VERGEBEN. BEI DEM ERSTEN SPIELSTART ABER RICHTIG.

//COMPUTER SPIELER WURDE LEIDER NICHT PROGRAMMIERT. WIRD ABER NOCH SPÄTER IMPLEMENTIERT

//AUF JEDEN FALL...WORK IN PROGRESS :) ES WIRD AUCH NACH PROJEKT_ABSCHLUSS DADRAN WEITERGEARBEITET UND FEHLER
//BEHOBEN, DAMIT ES DANN IN MODUL 3 PROGRAMMIERT WERDEN KANN.


// IMPORT-R, UM DEN ANFANGS-ANGREIFER ZU BESTIMMEN
import kotlin.random.Random


fun waiting() {

    Thread.sleep(400)

}


// ZUFÄLLIGER SPIELER WIRD FÜR DEN SPIELBEGINN GENERIERT
val players = listOf(
    Player("\u001B[1;93mTan\u001B[0m", balance = accountBalancePlayer1), // --> Konto wird zu Anna zugewiesen
    Player("\u001B[1;36mAnna\u001B[0m", balance = accountBalancePlayer2)  // --> Konto wird zu Tan zugewiesen
).shuffled(Random.Default)

val player1 = players[0]
val player2 = players[1]


fun game() {


    val cardsDeck = Deck()
    cardsDeck.mixCards()
    val mixedCards = cardsDeck.deck.toList()
    val trump = cardsDeck.randomTrump()






    println("Einigt euch auf auf euren Einsatz")
    val bet = readln().toDouble()

    if (bet <= accountBalancePlayer1 && bet <= accountBalancePlayer2) {

        println("Der Einsatz beträgt: $bet")
    } else {

        println("Dieser Einsatz übersteigt deinen Kontostand")
        println("[1] Mache einen neuen Einsatz")
        println("[2] Zurück ins Hauptmenü")
        val inputChoice = readln().toInt()

        when {

            inputChoice == 1 -> game()
            inputChoice == 2 -> menu()
            inputChoice >= 3 -> {
                println("Oh hast du dich vertippt. Versuche es gleich nochmal ;)")
                game()


            }


        }

    }



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


        /*println("TEST1")*/
        if (attacker.hasNoCards() || defender.hasNoCards()) {
            break
        }

        var attackingCard = attacker.attack(defender, trump, cardsDeck)

        while (attackingCard != null) {
            val defendingCard = defender.defend(attackingCard, trump, cardsDeck, attackingCard)

            if (defendingCard != null) {
                // VERTEIDIGUNG ERFOLGREICH


                /*println("\nTEST2 !!!!!!")*/

                // VERBLEIBENDE KARTEN IM DECK
                /*println("\nVerbleibende Karten im Deck (${cardsDeck.deck.size})")
                println("RESTDECK2")*/

                // ÜBERPRÜFEN, OB DER VERTEIDIGER NOCH KARTEN ZUM ANGREIFEN HAT
                if (defender.canDefend(attackingCard, trump)) {


                    // WECHSEL ZWISCHEN ANGREIFER UND VERTEIDIGER
                    val temp = attacker
                    attacker = defender
                    defender = temp

                    if (player1.hasNoCards()) {
                        println("\nSpieler ${player1.name} HAT GEWONNEN!")


                        accountBalancePlayer1 += (bet * 0.9)
                        operatorAccount += (bet * 0.1)
                        accountBalancePlayer2 -= bet
                        println("Herzlichen Glückwunsch, du hast ${(bet * 1.9)} € gewonnen!")
                        println("Möchtest du ein neues Spiel starten oder ins Hauptmenü zurückkehren")

                        println(
                            """
                                [1]  Spiel neustarten
                                [2]  Zurück ins Hauptmenü
                            """.trimIndent()
                        )
                        val input1 = readln().toInt()

                        when (input1) {
                            1 -> {

                                game()
                            }

                            2 -> {

                                menu()

                            }
                        }


                    } else if (player2.hasNoCards()) {
                        println("\nSpieler ${player2.name} HAT GEWONNEN!")



                        accountBalancePlayer2 += (bet * 0.9)
                        operatorAccount += (bet * 0.1)
                        accountBalancePlayer1 -= bet
                        println("Herzlichen Glückwunsch, du hast ${(bet * 1.9)} € gewonnen!")
                        println("Möchtest du ein neues Spiel starten oder ins Hauptmenü zurückkehren")

                        println(
                            """
                                [1]  Spiel neustarten
                                [2]  Zurück ins Hauptmenü
                            """.trimIndent()
                        )
                        val input2 = readln().toInt()

                        when (input2) {
                            1 -> {

                                game()
                            }

                            2 -> {

                                menu()

                            }
                        }


                    } else {
                        /*println("\nUNENTSCHIEDEN  TEST1.")*/
                    }

                    // WECHSEL ZWISCHEN ANGREIFER UND VERTEIDIGER
                } else {
                    val temp = attacker
                    attacker = defender
                    defender = temp



                    if (player1.hasNoCards()) {
                        println("\nSpieler ${player1.name} HAT GEWONNEN!")

                        accountBalancePlayer1 += (bet * 0.9)
                        operatorAccount += (bet * 0.1)
                        accountBalancePlayer2 -= bet
                        println("Herzlichen Glückwunsch, du hast ${(bet * 1.9)} € gewonnen!")
                        println("Möchtest du ein neues Spiel starten oder ins Hauptmenü zurückkehren")

                        println(
                            """
                                [1]  Spiel neustarten
                                [2]  Zurück ins Hauptmenü
                            """.trimIndent()
                        )
                        val input1 = readln().toInt()

                        when (input1) {
                            1 -> {

                                game()
                            }

                            2 -> {

                                menu()

                            }
                        }


                    } else if (player2.hasNoCards()) {
                        println("\nSpieler ${player2.name} HAT GEWONNEN!")

                        accountBalancePlayer2 += (bet * 0.9)
                        operatorAccount += (bet * 0.1)
                        accountBalancePlayer1 -= bet
                        println("Herzlichen Glückwunsch, du hast ${(bet * 1.9)} € gewonnen!")
                        println("Möchtest du ein neues Spiel starten oder ins Hauptmenü zurückkehren")

                        println(
                            """
                                [1]  Spiel neustarten
                                [2]  Zurück ins Hauptmenü
                            """.trimIndent()
                        )

                        when (readln().toInt()) {
                            1 -> {

                                game()
                            }

                            2 -> {

                                menu()

                            }
                        }


                    } else {
                        /*println("\nUNENTSCHIEDEN. TEST2")*/
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

}