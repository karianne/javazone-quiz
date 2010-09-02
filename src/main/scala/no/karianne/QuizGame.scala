package no.karianne

class QuizGame(val numOfQuestions: Int) {
  val allQuestions = List(
    Question("Hvem er verdens største hest?", ("1", "Arne"), Map("2" -> "Bjarne", "3" -> "Kåre")),
    Question("Hvem ble kalt 'landsmoderen'?", ("1", "Gro"), Map("2" -> "Siv", "3" -> "Anne Grethe")),
    Question("Hva er en ninja?", ("1", "All of the above"), Map("2" -> "Totally awesome", "3" -> "Et pattedyr")),
    Question("Hvem er ninjaens hovedfiende?", ("1", "Pirater"), Map("2" -> "FrP-ere", "3" -> "Edderkopper"))
    )

  private var currentQuestionNumber = 0
  private var currentScore = 0

  def isNotFinished = !isFinished

  def isFinished = currentQuestionNumber == numOfQuestions

  def currentQuestion: Question = allQuestions(currentQuestionNumber)

  def nextQuestion = {
    currentQuestionNumber += 1
    currentQuestion
  }

  def isValid(answer: String) = currentQuestion.isValid(answer)

  def answer(answer: String) = if(currentQuestion isRight answer) currentScore += 1

  def finalPoints = currentScore

}

























/*
class QuizGame(val numOfQuestions: Int) {
  val allQuestions = List(
    Question("Hvem er verdens største hest?", Answer("1", "Arne"), List(Answer("2", "Bjarne"), Answer("3", "Kåre"))),
    Question("Hvem ble kalt 'landsmoderen'?", Answer("1", "Gro"), List(Answer("2", "Siv"), Answer("3", "Anne Grethe"))),
    Question("Hva er en ninja?", Answer("1", "All of the above"), List(Answer("2", "Totally awesome"), Answer("3", "Et pattedyr"))),
    Question("Hvem er ninjaens hovedfiende?", Answer("1", "Pirater"), List(Answer("2", "FrP-ere"), Answer("3", "Edderkopper")))
    )

  private var currentQuestionNumber = 0
  private var currentScore = 0

  def isNotFinished = {
    !isFinished
  }

  def isFinished = {
    numOfQuestions == currentQuestionNumber
  }

  def nextQuestion = {
    currentQuestionNumber += 1
    currentQuestion
  }

  def finalPoints = currentScore

  def isValid(answer: String) = {
    currentQuestion.answers.exists(_.id == answer)
  }

  def answer(answer: String) {
    if (!isValid(answer)) throw new IllegalArgumentException
    if (currentQuestion.rightAnswer.id == answer) {
      currentScore += 1
    }
  }

  private def currentQuestion: Question = {
    allQuestions(currentQuestionNumber - 1)
  }

}
*/