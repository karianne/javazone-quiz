package no.karianne

case class Question(text : String, val correctAnswer : (String,String),
        val wrongAnswers:Map[String, String]) {

  override def equals(other : Any) = {
    other match {
      case Question(text, _ , _) => text == this.text
      case _ => false
    }
  }

  def answers = wrongAnswers + correctAnswer

  def isValid(answer : String) = {
    answers get answer match {
      case Some(_) => true
      case None => false
    }
  }

  def isCorrect(answer : String) = answer == correctAnswer._1

  override def toString = {
    val builder = new StringBuilder
    builder.append("Q: ")
    builder.append(text)
    builder.append("\n")
    answers foreach {
      answer =>
        builder.append("\t")
        builder.append(answer._1)
        builder.append(": ")
        builder.append(answer._2)
        builder.append("\n")
    }

    builder.toString
  }

}