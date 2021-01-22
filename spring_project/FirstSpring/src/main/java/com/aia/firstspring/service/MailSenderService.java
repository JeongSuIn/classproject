package com.aia.firstspring.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender mailSender;

	public boolean simpleMailSend() {

		boolean result = true;

		SimpleMailMessage message = new SimpleMailMessage();
//		SimpleMailMessage message = new SimpleMailMessage(templateMessage);
		message.setTo("jeongsuin0622@gmail.com");
		message.setSubject("발송 테스트 이메일입니다.");
		message.setText("테스트 중입니다.");

		try {
			mailSender.send(message);

		} catch (MailException e) {
			result = false;
		}

		return result;
	}

	public boolean mailSend(String toEmailAddress) {

		boolean result = true;

		MimeMessage message = mailSender.createMimeMessage();

		try {
			// 메일 제목
			message.setSubject("[안내] 회원가입을 축하합니다.", "utf-8");
			String htmlStr = "<h1 style=\"color:coral;\">회원 가입을 축하합니다. </h1>";
			// 메일 내용
			message.setText(htmlStr, "utf-8", "html");
			// 보내는 사람의 이메일: gmail을 사용하는 경우 - 인증된 메일로 적용
			message.setFrom(new InternetAddress("suin9711@naver.com"));
			// 받는 사람 이메일
			message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress, "정수인 님", "utf-8"));
			// 메일 전송
			mailSender.send(message);

		} catch (MessagingException e) {
			result = false;
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}

//	param@ toEmailAddress: 받는 사람의 이메일
//	param@ name: 받는 사람의 이름
//	param@ subject: 메일의 제목 
//	param@ text: 메일 내용
	public boolean mailSend(String toEmailAddress, String name, String subject, String text) {

		boolean result = true;

		MimeMessage message = mailSender.createMimeMessage();

		try {
			// 메일 제목
			message.setSubject(subject, "utf-8");
//			String htmlStr = "<h1 style=\"color:coral;\">회원 가입을 축하합니다. </h1>";
			// 메일 내용
			message.setText(text, "utf-8", "html");
			// 보내는 사람의 이메일: gmail을 사용하는 경우 - 인증된 메일로 적용
			message.setFrom(new InternetAddress("suin9711@naver.com"));
			// 받는 사람 이메일
			message.addRecipient(RecipientType.TO, new InternetAddress(toEmailAddress, name+" 님", "utf-8"));
			// 메일 전송
			mailSender.send(message);

		} catch (MessagingException e) {
			result = false;
			e.printStackTrace();

		} catch (UnsupportedEncodingException e) {
			result = false;
			e.printStackTrace();
		}

		return result;
	}
}
