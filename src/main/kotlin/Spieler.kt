open class Spieler(private var name: String) {


    fun welcome() {


        println("${this.name} ist dem Spiel beigetreten.")

    }


    fun choiceAiOrHuman() {

        println("Möchtest du gegen einen echten Spieler oder gegen Computer spielen? Gebe ein 1 für Computer oder 2 für Mensch ein.")

        /*when(kartenWert){
            "1." -> "Computer"
            "2." -> "Mensch"

            else -> "Fehler"
        }*/



    }


    fun bet() {

        var balance = 1000
        println("Es ist möglich 25, 100, 200, 500, 1000, 5000 oder 250000 zu setzen. Mache deinen Einsatz:")





    }

}
