package mymatching


sealed trait Notification

sealed case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification

sealed case class VoiceRecording(contactName: String, link: String) extends Notification

class MatchTest(val callerObj: String, message: String) extends  SMS(callerObj, message) {

//  private lazy val name: String = _

}

object MatchTest extends {

  private def showNotification(note: Notification): Unit = {
    note match {
      case SMS(caller, message) => println(s"Caller: $caller - Msg: $message")
      case Email(sender, title, message) => println(s"Sender: $sender - " +
          s"Title: $title: $message" +
          s"Msg: $message")
      case VoiceRecording(contactName, link) => println(s"Caller: $contactName - Msg: $link")
    }


  }
  def main(args: Array[String]): Unit = {
    val email: Email = Email("Jack", "Hello", "Email body: Hello Jack")
    val sms: SMS = SMS("Jack", "Sms body: Hello Jack")
    val voice: VoiceRecording = VoiceRecording("Jack", "Voice body: Hello Jack")
    showNotification(sms)
  }



}


