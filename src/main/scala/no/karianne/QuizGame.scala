package no.karianne

class QuizGame(val numOfQuestions : Int){

  var currentQuestionNumber = 0
  var currentScore = 0
  val allQuestions = QuestionFactory.questions

  def isFinished = currentQuestionNumber == numOfQuestions

  def currentQuestion: Question = {
    allQuestions(currentQuestionNumber - 1)
  }

  def nextQuestion = {
    currentQuestionNumber += 1
    currentQuestion
  }

  def isValid(answer : String) = {
    currentQuestion.isValid(answer)
  }

  def answer(answer : String) = {
    if(currentQuestion.isCorrect(answer)) currentScore += 1
  }

  def finalScore = currentScore

}