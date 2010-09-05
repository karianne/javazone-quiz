package no.karianne

class QuizGame(val numOfQuestions : Int){

  private val allQuestions = QuestionFactory.questions
  private var currentQuestionNumber = 0
  private var currentScore = 0


  def isNotFinished = !isFinished

  def isFinished = currentQuestionNumber == numOfQuestions

  def currentQuestion: Question = {
    allQuestions(currentQuestionNumber - 1)
  }

  def nextQuestion = {
    currentQuestionNumber += 1
    currentQuestion
  }

  def isValid(answer : String) = currentQuestion.isValid(answer)

  def answer(answer : String) = {
    if(currentQuestion.isCorrect(answer)) currentScore += 1
  }

  def finalScore = currentScore

}