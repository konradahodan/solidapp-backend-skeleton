package com.solidtech.emailsender.dto;


import com.solidtech.emailsender.model.Attachment;
import com.solidtech.emailsender.model.Mail;

import java.util.ArrayList;
import java.util.List;

public class MailDto {

    private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType;
    private List< AttachmentDto > attachmentDtos;

    public MailDto(String mailFrom, String mailTo, String mailCc, String mailBcc, String mailSubject, String mailContent, String contentType, List<AttachmentDto> attachmentDtos) {
        this.mailFrom = mailFrom;
        this.mailTo = mailTo;
        this.mailCc = mailCc;
        this.mailBcc = mailBcc;
        this.mailSubject = mailSubject;
        this.mailContent = mailContent;
        this.contentType = contentType;
        this.attachmentDtos = attachmentDtos;
    }

    public Mail getMailFromDto(){
        Mail mail = new Mail();
        mail.setMailFrom(mailFrom);
        mail.setMailTo(mailTo);
        mail.setMailCc(mailCc);
        mail.setMailBcc(mailBcc);
        mail.setMailSubject(mailSubject);
        mail.setMailContent(mailContent);

        return mail;
    }


    public String getMailFrom() {
        return mailFrom;
    }

    public void setMailFrom(String mailFrom) {
        this.mailFrom = mailFrom;
    }

    public String getMailTo() {
        return mailTo;
    }

    public void setMailTo(String mailTo) {
        this.mailTo = mailTo;
    }

    public String getMailCc() {
        return mailCc;
    }

    public void setMailCc(String mailCc) {
        this.mailCc = mailCc;
    }

    public String getMailBcc() {
        return mailBcc;
    }

    public void setMailBcc(String mailBcc) {
        this.mailBcc = mailBcc;
    }

    public String getMailSubject() {
        return mailSubject;
    }

    public void setMailSubject(String mailSubject) {
        this.mailSubject = mailSubject;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public List<AttachmentDto> getAttachmentDtos() {
        return attachmentDtos;
    }

    public void setAttachmentDtos(List<AttachmentDto> attachmentDtos) {
        this.attachmentDtos = attachmentDtos;
    }

    @Override
    public String toString() {
        return "MailDto{" +
                "mailFrom='" + mailFrom + '\'' +
                ", mailTo='" + mailTo + '\'' +
                ", mailCc='" + mailCc + '\'' +
                ", mailBcc='" + mailBcc + '\'' +
                ", mailSubject='" + mailSubject + '\'' +
                ", mailContent='" + mailContent + '\'' +
                ", contentType='" + contentType + '\'' +
                ", attachmentDtos=" + attachmentDtos +
                '}';
    }
}
