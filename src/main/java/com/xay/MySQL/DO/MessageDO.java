package com.xay.MySQL.DO;

import com.xay.Domain.MessageDomain;

import java.sql.Timestamp;

/**
 * Created by Administrator on 2017/5/26.
 */
public class MessageDO {
    private int message_id;
    private String from_username;
    private String to_username;
    private String message_content;
    private Timestamp time;
    private int read;

    public MessageDO(int message_id, String from_username, String to_username, String message_content, Timestamp time, int read) {
        this.message_id = message_id;
        this.from_username = from_username;
        this.to_username = to_username;
        this.message_content = message_content;
        this.time = time;
        this.read = read;
    }

    public MessageDO(MessageDomain messageDomain) {
        this.from_username = messageDomain.getFrom();
        this.to_username = messageDomain.getTo();
        this.message_content = messageDomain.getMessageContent();
    }

    public MessageDO() {
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getFrom_username() {
        return from_username;
    }

    public void setFrom_username(String from_username) {
        this.from_username = from_username;
    }

    public String getTo_username() {
        return to_username;
    }

    public void setTo_username(String to_username) {
        this.to_username = to_username;
    }

    public String getMessage_content() {
        return message_content;
    }

    public void setMessage_content(String message_content) {
        this.message_content = message_content;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public int getRead() {
        return read;
    }

    public void setRead(int read) {
        this.read = read;
    }
}
