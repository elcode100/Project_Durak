package durakfinal2


// KLASSE KARTE
class Card(val suit: String, val value: String) {           // SYMBOL UND WERT DER KARTE.


    // DIE METHODE "toString" GIBT EINE ZEICHENKETTENREPRÄSENTATION DER KARTE ZURÜCK
    override fun toString(): String {

        // DIE SYMBOLE UND WERTE DER KARTE WERDEN KOMBINIERT UND ZURÜCKGEGEBEN
        return "$suit $value"

    }


    // DIE METHODE canDefeat ÜBERPRÜFT, OB DIE GESPIELTE KARTE DIE ANDERE KARTE SCHLAGEN KANN
    // NORMALE KARTE "CARDS" UND DIE TRUMPFKARTE "TRUMP" SIND ALS PARAMETER FESTGELEGT
    fun canDefeat(cards: Card, trump: Card): Boolean {


        // WENN DIE FARBE DER AKTUELLEN KARTE MIT DER TRUMPFFARBE ÜBEREINSTIMMT UND DIE FARBE DER ANDEREN KARTE NICHT MIT DER TRUMPFFARBE ÜBEREINSTIMMT,
        // KANN DIE AKTUELLE KARTE DIE ANDERE KARTE SCHLAGEN.
        if (suit == trump.suit && cards.suit != trump.suit) {
            return true

        } else if (suit == cards.suit) {
            //LISTE DER KARTENWERTE
            val valuesOfCards = listOf("6", "7", "8", "9", "10", "Bube", "Dame", "König", "Ass")

            // DER INDEX DES WERTS DER AKTUELLEN KARTE WIRD ERMITTELT
            val valueIndex1 = valuesOfCards.indexOf(value)

            // DER INDEX DES WERTS DER ANDEREN KARTE WIRD ERMITTELT
            val valueIndex2 = valuesOfCards.indexOf(cards.value)

            // WENN DER INDEX DES WERTS DER AKTUELLEN KARTE GRÖSSER IST ALS DER INDEX DES WERTS DER ANDEREN KARTE,
            // KANN DIE AKTUELLE KARTE DIE ANDERE KARTE SCHLAGEN
            return valueIndex1 > valueIndex2

        }

        // IN ALLEN ANDEREN FÄLLEN KANN DIE AKTUELLE KARTE DIE ANDERE KARTE NICHT SCHLAGEN
        return false

    }
}

