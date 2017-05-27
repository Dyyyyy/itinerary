package com.xay.Domain;

import com.xay.MySQL.DO.MessageDO;

/**
 * Created by Administrator on 2017/5/26.
 */
public class MessageDomain {
    private Integer messageId;
    private String from;
    private String to;
    private String messageContent;
    private String time;
    private Integer read;

    public MessageDomain(String from, String to, String messageContent) {
        this.from = from;
        this.to = to;
        this.messageContent = messageContent;
    }
    public MessageDomain(MessageDO messageDO, String createTime){
        this.from = messageDO.getFrom_username();
        this.to = messageDO.getTo_username();
        this.messageContent = messageDO.getMessage_content();
        this.time = createTime;
    }

    public MessageDomain() {
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getRead() {
        return read;
    }

    public void setRead(Integer read) {
        this.read = read;
    }
}
