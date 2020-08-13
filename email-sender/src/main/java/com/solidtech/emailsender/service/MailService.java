package com.solidtech.emailsender.service;

import com.solidtech.emailsender.dto.MailDto;
import com.solidtech.emailsender.model.Mail;

public interface MailService {
    public void sendSimpleEmail(Mail mail);

    public void sendEmailWithAttachment(Mail mail);

    public void sendEmail(MailDto mailDto);
}
