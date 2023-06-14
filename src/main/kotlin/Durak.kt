var CARD_DECK: List<String> = listOf(
    "♠\uFE0F Pik Ass",
    "♠\uFE0F Pik König",
    "♠\uFE0F Pik Dame",
    "♠\uFE0F Pik Bube",
    "♠\uFE0F Pik 10",
    "♠\uFE0F Pik 9",
    "♠\uFE0F Pik 8",
    "♠\uFE0F Pik 7",
    "♠\uFE0F Pik 6",

    "♣\uFE0F Kreuz Ass",
    "♣\uFE0F Kreuz König",
    "♣\uFE0F Kreuz Dame",
    "♣\uFE0F Kreuz Bube",
    "♣\uFE0F Kreuz 10",
    "♣\uFE0F Kreuz 9",
    "♣\uFE0F Kreuz 8",
    "♣\uFE0F Kreuz 7",
    "♣\uFE0F Kreuz 6",

    "♥\uFE0F Herz Ass",
    "♥\uFE0F Herz König",
    "♥\uFE0F Herz Dame",
    "♥\uFE0F Herz Bube",
    "♥\uFE0F Herz 10",
    "♥\uFE0F Herz 9",
    "♥\uFE0F Herz 8",
    "♥\uFE0F Herz 7",
    "♥\uFE0F Herz 6",

    "♦\uFE0F Karo Ass",
    "♦\uFE0F Karo König",
    "♦\uFE0F Karo Dame",
    "♦\uFE0F Karo Bube",
    "♦\uFE0F Karo 10",
    "♦\uFE0F Karo 9",
    "♦\uFE0F Karo 8",
    "♦\uFE0F Karo 7",
    "♦\uFE0F Karo 6"
)


var game = Game()
var player = Player("Huan Tan")

fun main() {

    player.welcome()
    println()
    println(game.mixCards())
    println()
    game.drawCards()

}