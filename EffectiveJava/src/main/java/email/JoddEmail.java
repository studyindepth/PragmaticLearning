package email;

import jodd.mail.Email;
import jodd.mail.SendMailSession;
import jodd.mail.SmtpServer;
import jodd.mail.SmtpSslServer;

public class JoddEmail {
	public static void main(String[] args) {
		Email email = Email.create().from("toan.do@ntq-solution.com.vn").to("nam.nguyen@ntq-solution.com.vn")
				.to("toan.do@ntq-solution.com.vn").subject("Hell!").addHtml("<b>HTML</b> message");
		SmtpServer<?> smtpServer = SmtpSslServer.create("smtp.gmail.com", 465).authenticateWith("dovantoanhp@gmail.com",
				"developer");
		SendMailSession session = smtpServer.createSession();
		session.open();
		session.sendMail(email);
		session.close();
	}
}
