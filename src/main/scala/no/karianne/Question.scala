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
}

/*
case class Question(text: String, correctAnswer: Answer, wrongAnswers: List[Answer]) {

  override def equals(other: Any) = {
    other match {
      case Question(x, _, _) => x == this.text
      case _ => false
    }
  }

  override def hashCode = text.length

  override def toString = {
    val builder = new StringBuilder
    builder.append("Q: ")
    builder.append(text)
    builder.append("\n")
    answers foreach {
      answer =>
        builder.append(answer.id)
        builder.append(": ")
        builder.append(answer.text)
        builder.append("    ")
    }

    builder.toString
  }
}
*/