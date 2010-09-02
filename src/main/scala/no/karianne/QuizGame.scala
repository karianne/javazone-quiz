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

  def answer(answer: String) = if(currentQuestion isCorrect answer) currentScore += 1

  def finalScore = currentScore

}