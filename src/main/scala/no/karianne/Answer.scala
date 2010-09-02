package no.karianne

class Answer(val id : String, val text : String)

object Answer {
  def apply(id : String, text : String) = new Answer(id, text)
}



/*
class Answer(val id : String, val text : String)

object Answer {
  def apply(id : String, text : String) = new Answer(id, text)
}

*/