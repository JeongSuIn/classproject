package com.aia.firstspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aia.firstspring.service.MailSenderService;

@Controller
@RequestMapping("/mail")
public class MailSenderController {

	@Autowired
	MailSenderService mailsenderService;
	
	
//	@Autowired
//	private JavaMailSender mailSender;
	
//	@Autowired
//	private SimpleMailMessage templateMessage;
	
	@RequestMapping("/simplemail")		// /mail/simplemail
	public void simpleMailSend() {
		
//		mailsenderService.simpleMailSend();
		mailsenderService.mailSend("suin9711@naver.com");	
		
		// 현재 경로: return "mail/simplemail";
	}
	
}
