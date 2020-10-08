import java.util.Properties;    
import javax.mail.*;    
import javax.mail.internet.*;

public class SendingEmail {
	
	private String userEmail;
	private String myHash;
	
	public SendingEmail(String userEmail, String myHash) {
		super();
		this.userEmail = userEmail;
		this.myHash = myHash;
	}
	
	
	public void sendMail()
	{
		String email="samikshasingh883@gmail.com";
		String pword="9890098900";
		Properties properties=new Properties();
		
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		
		Session session=Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email,pword);
			}
		});
		
		
		try
		{
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(userEmail));
			message.setSubject("Email verification Link");
			message.setText("verification link");
			message.setText("your verification link: : "+"http://localhost:8090/EmpTask/ActivateAccount?key1="+userEmail+"&key2="+myHash);
	        Transport.send(message);		
		}
		
		catch(Exception ex)
		{
			System.out.println("Sending email "+ex);
		}
	}
	
	
	

}
