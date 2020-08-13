package com.solidtech.emailsender.web.controller;

import com.solidtech.emailsender.dao.MailDao;
import com.solidtech.emailsender.dto.MailDto;
import com.solidtech.emailsender.model.Mail;
import com.solidtech.emailsender.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MailController {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MailDao mailDao;

    @Autowired
    private MailService mailService;

    @PostMapping("/send/{userId}")
    public Mail sendMail(@PathVariable("userId") long id, @Valid @RequestBody MailDto mailDto) {
        try {
            mailService.sendEmail(mailDto);
        } catch (Exception e){
            log.error("Exception ", e.getMessage());
        }
        return null;
    }

}
