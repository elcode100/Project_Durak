package durakfinal2

fun menu() {

    val reset = "\u001B[0m"
    val bold = "\u001B[1m"
    val red = "\u001B[31m"

    val hello = "⚡️ ${bold}Willkommen bei ${red}Syntax-Durak24${reset} ⚡️"
    println(hello)
    println()
    println("------------------------")
    println("       \u001B[1mHauptmenü\u001B[0m")
    println("------------------------")
    println(
        """
        [1]  Spiel beginnen
        [2]  Kontostand Abfrage
        [3]  Geld einzahlen
        [4]  Geld Auszahlen
        [5]  Betreiber-Konto
        [6]  Ausloggen
    """.trimIndent()
    )

    val input = readln().toInt()

    when {
        input == 1 -> {

            game()
            menu()

        }

        input == 2 -> {

            accountBalanceQuery()

        }

        input == 3 -> {

            deposit()
        }

        input == 4 -> {

            payOff()
        }


        input == 5 -> {

            println("Auf dem Betreiber-Konto liegen aktuell: $operatorAccount €")
            println("Zurück mit Enter")
            readln()
            menu()

        }




        input == 6 -> {

            println("Ciao")

        }


        input >= 7 -> {

            println("Fehlerhafte Eingabe...versuche es nochmal \uD83D\uDE09")
            println()
            menu()

        }


    }


}




var accountBalancePlayer1 = 0.0
var accountBalancePlayer2 = 0.0

var operatorAccount = 0.0


fun accountBalanceQuery() {

    println("Für welchen Spieler abfragen?")

    println(
        """
        [1]  Spieler 1
        [2]  Spieler 2
    """.trimIndent()
    )
    val input = readln().toInt()



    when {
        input == 1 -> {

            println("Dein Kontostand beträgt: $accountBalancePlayer1")
            println("Zurück")
            readln()
            menu()


        }

        input == 2 -> {

            println("Dein Kontostand beträgt: $accountBalancePlayer2")
            println("Zurück")
            readln()
            menu()


        }


        input >= 3 -> {

            println("Fehlerhafte Eingabe...versuche es nochmal \uD83D\uDE09")
            println("Zurück")
            readln()
            accountBalanceQuery()

        }


    }
}



    fun deposit() {

        println("Für welchen Spieler einzahlen?")

        println(
            """
        [1]  Spieler 1
        [2]  Spieler 2
    """.trimIndent()
        )
        val input = readln().toInt()

        when {
            input == 1 -> {

                println("Dein Kontostand beträgt: $accountBalancePlayer1")
                println("Wie viel möchtest du einzahlen?")
                var inputEinzahlen1 = readln().toDouble()
                accountBalancePlayer1 += inputEinzahlen1
                println("Dein neuer Kontostand beträgt $accountBalancePlayer1")



                println("Zurück mit Enter")
                readln()
                menu()


            }

            input == 2 -> {

                println("Dein Kontostand beträgt: $accountBalancePlayer2")
                println("Wie viel möchtest du einzahlen?")
                val inputEinzahlen2 = readln().toDouble()
                accountBalancePlayer2 += inputEinzahlen2
                println("Dein neuer Kontostand beträgt $accountBalancePlayer2")

                println("Zurück mit Enter")
                readln()
                menu()

            }


            input >= 3 -> {

                println("Fehlerhafte Eingabe...versuche es nochmal \uD83D\uDE09")
                println("Zurück mit Enter")
                readln()
                deposit()


            }


        }
    }





fun payOff() {

    println("Für welchen Spieler auszahlen?")

    println(
        """
        [1]  Spieler 1
        [2]  Spieler 2
    """.trimIndent()
    )
    val input = readln().toInt()

    when {
        input == 1 -> {

            println("Dein Kontostand beträgt: $accountBalancePlayer1")
            println("Wie viel möchtest du auszahlen?")
            var inputAuszahlen1 = readln().toDouble()
            accountBalancePlayer1 -= inputAuszahlen1
            println("Dein neuer Kontostand beträgt $accountBalancePlayer1")



            println("Zurück mit Enter")
            readln()
            menu()


        }

        input == 2 -> {

            println("Dein Kontostand beträgt: $accountBalancePlayer2")
            println("Wie viel möchtest du auszahlen?")
            var inputPayOff = readln().toDouble()
            accountBalancePlayer2 -= inputPayOff
            println("Dein neuer Kontostand beträgt $accountBalancePlayer2")

            println("Zurück mit Enter")
            readln()
            menu()

        }


        input >= 3 -> {

            println("Fehlerhafte Eingabe...versuche es nochmal \uD83D\uDE09")
            println("Zurück mit Enter")
            readln()
            payOff()


        }


    }
}