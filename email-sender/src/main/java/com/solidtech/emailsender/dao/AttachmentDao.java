package com.solidtech.emailsender.dao;

import com.solidtech.emailsender.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentDao extends JpaRepository<Attachment, Long> {
}
