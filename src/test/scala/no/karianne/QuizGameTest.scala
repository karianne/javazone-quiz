package no.karianne

import org.junit.Test
import junit.framework.Assert._

class QuizGameTest {
  val numOfQuestions = 3
  val game = new QuizGame(numOfQuestions)

  @Test
  def gameIsNotFinishedWhenQuestionsLeft {
    assertFalse(game.isFinished)
    game.nextQuestion
    game.nextQuestion
    game.nextQuestion
    assertTrue(game.isFinished)
  }

  @Test
  def doesNotGiveSameQuestionTwice {
    var questions = Set[Question]()
    for(i <- 1 to numOfQuestions) {
      questions += game.nextQuestion
    }

    assertEquals(numOfQuestions, questions.size)
  }

  @Test
  def canOnlyAnswerValidAnswers {
    val q = game.nextQuestion
    assertFalse(game.isValid("Hest"))
    assertTrue(game.isValid(q.correctAnswer._1))
    q.wrongAnswers.keys.foreach {
      answer =>
        assertTrue(game.isValid(answer))
    }
  }

  @Test
  def allCorrectAnswersGivesFullScore {
    loop {
      val q = game.nextQuestion
      game.answer(q.correctAnswer._1)
    }

    assertEquals(numOfQuestions, game.finalScore)
  }

  def loop(codeBlock: => Unit) {
    for(i <- 1 to numOfQuestions){
      codeBlock
    }
  }

}