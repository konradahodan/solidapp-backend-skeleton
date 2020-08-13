package com.solidtech.emailsender.dao;

import com.solidtech.emailsender.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailDao extends JpaRepository<Mail, Long> {
}
