package com.solidtech.emailsender.dto;

import com.solidtech.emailsender.model.Attachment;

import javax.persistence.Column;
import java.util.List;

public class AttachmentDto {

    private String name;
    private String file;
    private String description;

    public AttachmentDto(String name, String file, String description) {
        this.name = name;
        this.file = file;
        this.description = description;
    }

    public Attachment getAttachmentFromDto(){
        Attachment attachment = new Attachment();
        attachment.setFile(file);
        attachment.setName(name);
        attachment.setDescription(description);
        return attachment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AttachmentDto{" +
                "name='" + name + '\'' +
                ", file='" + file + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
