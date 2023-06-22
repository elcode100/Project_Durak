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
    println("""
        [1]  Spiel beginnen
        [2]  Kontostand Abfrage
        [3]  Geld einzahlen
        [4]  Geld Auszahlen
        [5]  Ausloggen
    """.trimIndent())

    val input = readln().toInt()

    when {
        input == 1 -> {

            game()
            menu()

        }

        input == 2 -> {


        }

        input == 3 -> {


        }

        input == 4 -> {


        }

        input == 5 -> {

            println("Ciao")

        }

        input >= 6 -> {

            println("Fehlerhafte Eingabe...versuche es nochmal \uD83D\uDE09")
            println()
            menu()

        }


    }


}