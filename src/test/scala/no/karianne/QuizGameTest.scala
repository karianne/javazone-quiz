package no.karianne

import org.scalatest.junit.JUnitSuite
import org.junit.Test
import junit.framework.Assert._

class QuizGameTest extends JUnitSuite {
  val numOfQuestions = 3
  val game = new QuizGame(numOfQuestions)

  @Test
  def gameIsNotFinishedWhenThereAreQuestionsLeft {
    assertFalse(game.isFinished)

    for (i <- 1 to numOfQuestions) {
      game.nextQuestion
    }

    assertTrue(game.isFinished)
  }

  @Test
  def sameQuestionDoesNotShowUpTwice {
    var questions = Set[Question]()
    for (i <- 1 to numOfQuestions) {
      questions += game.nextQuestion
    }

    assertEquals(numOfQuestions, questions.size)
  }

  @Test
  def canOnlyAnswerValidAnswers {
    val question = game.nextQuestion
    assertFalse(game.isValid("Hest"))
    assertTrue(game.isValid(question.correctAnswer._1))

    question.wrongAnswers.keys.foreach(answer =>
      assertTrue(game.isValid(answer))
      )
  }

  @Test
  def zeroRightAnswersGiveZeroScore {
    for (i <- 1 to numOfQuestions) {
      val question = game.nextQuestion
      game.answer(question.wrongAnswers.head._1)
    }

    assertEquals(0, game.finalScore)
  }

  @Test
  def allRightAnswersGivesFullScore {

    loop (1, numOfQuestions) {
      val question = game.nextQuestion
      game.answer(question.correctAnswer._1)
    }

    assertEquals(numOfQuestions, game.finalScore)
  }

  def loop(start : Int, stop : Int)( codeBlock: => Unit) {
    for (i <- start to stop) {
      codeBlock
    }
  }

  @Test
  def testStuff {
    //assertTrue(Some[String].isInstanceOf[Option[String]])
  }

  /*
  val numOfQuestions = 3
  val game = new QuizGame(numOfQuestions)

  @Test
  def gameIsNotFinishedWhenThereAreQuestionsLeft {
    assertTrue(game isNotFinished)
    for(i <- 1 to numOfQuestions) {
      game nextQuestion
    }
    assertTrue(game isFinished)
  }

  @Test
  def sameQuestionDoesNotShowUpTwice {
    // TODO: Gjoer det sjikkeli' funnksjonellt!
    var qs = HashSet[Question]()
    (1 to numOfQuestions) foreach {_ => qs += game.nextQuestion}

    assertEquals(numOfQuestions, qs.size)
  }

  @Test
  def canOnlyAnswerValidAnswers {
    val question = game.nextQuestion
    assertFalse(game.isValid("Huzza"))
    assertFalse(game.isValid("90000"))

    assertTrue(game.isValid(question.correctAnswer.id))
    question.wrongAnswers foreach {answer => assertTrue(game.isValid(answer.id))}
  }

  //@Test
  def allRightAnswersGivesFullScore {
    for (i <- 1 to numOfQuestions) {
      val q = game.nextQuestion
      game.answer(q.correctAnswer.id)
    }

    assertEquals(numOfQuestions, game.finalScore)
  }

  //@Test
  def noRightAnswersGivesZeroScore {
    (1 to numOfQuestions) foreach {
      _ =>
        val q = game.nextQuestion
        game.answer(q.wrongAnswers(0).id)
    }

    assertEquals(0, game.finalScore)
  }

  //@Test
  def cannotAnswerWithInvalidAnswer {
    try {
      game.nextQuestion
      game.answer("Ponni")
      fail()
    } catch {
      case _ =>
    }
  }
  */
}
