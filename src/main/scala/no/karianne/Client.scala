package no.karianne

object Client extends Application {
  playGame

  def playGame() {
    readName

    val numberOfQuestions = readNumberOfQuestions

    val game = new QuizGame(numOfQuestions)

    playGameUntilFinished(game)

    printGameIsFinished(game)
  }

  def playGameUntilFinished(game: QuizGame): Unit = {
    while (game isNotFinished) {
      val question = game.nextQuestion
      println(question)
      var answer = ""
      do {
        println(question)
        answer = readLine
      } while (!(game isValid answer))
      game.answer(answer)
      println("-------------------------------------")
    }
  }


  def readName = {
    println("Velkommen til quiz!")
    print("Ditt navn: ")
    val name = readLine
  }

  def readNumberOfQuestions = {
    print("Antall spørsmål: ")
    var numOfQuestions = -1
    do {
      numOfQuestions = readInt
    } while (numOfQuestions < 0)
  }

  def printGameIsFinished(game: QuizGame): Unit = {
    println("Spillet er ferdig!")
    println("Du fikk " + game.finalPoints + " rette svar av "
            + game.numOfQuestions + " mulige.")
  }


}