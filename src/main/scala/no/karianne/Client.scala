package no.karianne

object Client extends Application {
  playGame

  def playGame() {
    welcome
    val numberOfQuestions = readNumberOfQuestions
    val game = new QuizGame(numberOfQuestions)
    playGameUntilFinished(game)
    printFinalScore(game)
  }

  def playGameUntilFinished(game: QuizGame) {
    while (game isNotFinished) {
      val question = game.nextQuestion
      println(question)
      var answer = ""
      do {
        answer = readLine
      } while (!(game isValid answer))
      game.answer(answer)
      println("-------------------------------------")
    }
  }

  def welcome = {
    println("Velkommen til quiz!")
  }

  def readNumberOfQuestions = {
    print("Antall spørsmål: ")
    var numOfQuestions = -1
    do {
      numOfQuestions = readInt
    } while (numOfQuestions < 0)
    numOfQuestions
  }

  def printFinalScore(game: QuizGame) {
    println("Spillet er ferdig!")
    println("Du fikk " + game.finalScore + " rette svar av "
            + game.numOfQuestions + " mulige.")
  }
}