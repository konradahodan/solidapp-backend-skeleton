package com.solidtech.emailsender.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "mails")
@EntityListeners(AuditingEntityListener.class)
public class Mail {
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "mail_from") // , nullable = false
    @NotBlank(message = "MailFrom is Not Null")
    private String mailFrom;

    @Column(name = "mail_to", nullable = false)
    @NotBlank(message = "MailTo is Not Null")
    private String mailTo;

    @Column(name = "mail_cc")
    private String mailCc;

    @Column(name = "mail_bcc")
    private String mailBcc;

    @Column(name = "mail_subject", nullable = false)
    @NotBlank(message = "MailSubject is Not Null")
    private String mailSubject;

    @Column(name = "mail_content", nullable = false)
    @NotBlank(message = "MailContent is Not Null")
    private String mailContent;

    @Column(name = "content_type")
    private String contentType;

    // @Column(name = "attachements")
    // private List< Object > attachments;

    public Mail() {
        contentType = "text/html";
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

    /*public List<Object> getAttachments() {
        return attachments;
    }

     */

    /*
    public void setAttachments(List<Object> attachments) {

        this.attachments = attachments;
    }

     */
}
