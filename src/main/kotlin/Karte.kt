open class Karte() {


    fun mix(): MutableList<String> {

        CARDDECK.shuffle()
        return CARDDECK
    }


}