package com.solidtech.emailsender.service;

import com.solidtech.emailsender.dao.AttachmentDao;
import com.solidtech.emailsender.dao.MailDao;
import com.solidtech.emailsender.dto.AttachmentDto;
import com.solidtech.emailsender.dto.MailDto;
import com.solidtech.emailsender.model.Attachment;
import com.solidtech.emailsender.model.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("mailService")
public class MailServiceImpl implements  MailService {

    @Autowired
    private MailDao mailDao;

    @Autowired
    private AttachmentDao attachmentDao;

    @Autowired
    JavaMailSender mailSender;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void sendSimpleEmail(Mail mail) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("to_1@gmail.com", "to_2@gmail.com", "to_3@yahoo.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        mailSender.send(msg);

    }

    @Override
    public void sendEmailWithAttachment(Mail mail) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {

            // true = multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setSubject(mail.getMailSubject());
            mimeMessageHelper.setFrom(new InternetAddress(mail.getMailFrom(), "technicalkeeda.com"));
            mimeMessageHelper.setTo(mail.getMailTo());
            mimeMessageHelper.setCc("infos.solidapp@gmail.com");

            // true = text/html
            mimeMessageHelper.setText(mail.getMailContent(), true);

            // Attachment
            mimeMessageHelper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

            mailSender.send(mimeMessageHelper.getMimeMessage());

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public void sendEmail(MailDto mailDto) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {

            // true = multipart message
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            if (!mailDto.getMailSubject().isEmpty())
                mimeMessageHelper.setSubject(mailDto.getMailSubject());

            if (!mailDto.getMailFrom().isEmpty())
                mimeMessageHelper.setFrom(new InternetAddress(mailDto.getMailFrom(), "solidtech.tech"));

            if (!mailDto.getMailTo().isEmpty())
                mimeMessageHelper.setTo(mailDto.getMailTo());

            if (!mailDto.getMailCc().isEmpty())
                mimeMessageHelper.setCc("infos.solidapp@gmail.com");

            // true = text/html
            mimeMessageHelper.setText(mailDto.getMailContent(), true);

            // Attachment
            if(!mailDto.getAttachmentDtos().isEmpty()){
                for (AttachmentDto aDto: mailDto.getAttachmentDtos()){
                    mimeMessageHelper.addAttachment(aDto.getName(), new ClassPathResource(aDto.getFile()));
                }
            }

            mailSender.send(mimeMessageHelper.getMimeMessage());

            Mail mail = mailDto.getMailFromDto();
tocu
            Mail mailSave = mailDao.save(mail);

            List<AttachmentDto> attachmentDtos = mailDto.getAttachmentDtos();

            List<Attachment> attachments = new ArrayList<>();

            for (AttachmentDto adto:attachmentDtos) {
                Attachment attachment = adto.getAttachmentFromDto();
                attachment.setMail(mailSave);
                attachments.add(attachment);
            }

            attachmentDao.saveAll(attachments);

            log.info("Mail Saved Success");

        } catch (MessagingException e) {
            log.error("Messaging error ", e.getMessage());
        } catch (UnsupportedEncodingException e) {
            log.error("UnsupportedEncodingException error ", e.getMessage());
        } catch (Exception e) {
            log.error("Other Exception error ", e.getMessage());
        }
    }
}
