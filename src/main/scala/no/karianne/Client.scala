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
    while (!game.isFinished) {
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
    println("Welcome to the quiz!")
  }

  def readNumberOfQuestions = {
    print("Number of questions: ")
    var numOfQuestions = -1
    do {
      numOfQuestions = readInt
    } while (numOfQuestions < 0)
    numOfQuestions
  }

  def printFinalScore(game: QuizGame) {
    println("Game over!")
    println("You had " + game.finalScore + " of "
            + game.numOfQuestions + " correct answers.")
  }
}