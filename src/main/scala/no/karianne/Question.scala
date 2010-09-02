package no.karianne

case class Question(text : String, correctAnswer : (String, String), wrongAnswers : Map[String, String]) {

  override def equals(other : Any) = {
    other match {
      case Question(text, _, _) => text == this.text
      case _ => false
    }
  }

  def answers = wrongAnswers + correctAnswer

  def isValid(answer : String) = {

    answers get answer match {
      case Some(_) => true
      case None => false
    }

    // Enklere: answers.exists(_._1 == answer)
  }

  def isCorrect(answer : String) = answer == correctAnswer._1

  override def toString = {
    val builder = new StringBuilder
    builder.append("Q: ")
    builder.append(text)
    builder.append("\n")
    answers foreach {
      answer =>
        builder.append(answer._1)
        builder.append(": ")
        builder.append(answer._2)
        builder.append("    ")
    }

    builder.toString
  }
}