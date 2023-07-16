package in.ineuron.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class PurchaseServiceImpl implements IPurchaseOrderService {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public String purchaseOrder(String[] items, double[] prices, String[] toEmails) {

		double billAmount = 0;

		for (double price : prices) {
			billAmount = +price;
		}

		String message = Arrays.toString(items) + "with prices " + Arrays.toString(prices)
				+ "are purchased with  a total bill amount :" + billAmount;

		try {
			String status = sendEmail(message, toEmails);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}

	private String sendEmail(String message, String[] toEmails) throws MessagingException {
		System.out.println("mail sender Impl class is ::" + mailSender.getClass().getName());

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);

		messageHelper.setFrom("xlogan4567@gmail.com");
		messageHelper.setTo("safvanpmcz8@gmail.com");
		messageHelper.setBcc(toEmails);
		messageHelper.setSentDate(new Date());
		messageHelper.setSubject("open to view");
		messageHelper.setText("Hey, I am safvan. This is a plain text email");
		messageHelper.addAttachment("ineuron.jpeg", new ClassPathResource("ineuron.jpg"));

		// sending mail
		mailSender.send(mimeMessage);

		return "mail sent";
	}

}
