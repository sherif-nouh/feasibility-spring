package com.feas.service.model;

import java.math.BigInteger;

public class MessageDto {
	private Long  messageId;
	private String messageTxt;
	private BigInteger messageType;
	private String title;
	private Long replyToMessageId;
	public String getMessageTxt() {
		return messageTxt;
	}
	public void setMessageTxt(String messageTxt) {
		this.messageTxt = messageTxt;
	}
	public BigInteger getMessageType() {
		return messageType;
	}
	public void setMessageType(BigInteger messageType) {
		this.messageType = messageType;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getReplyToMessageId() {
		return replyToMessageId;
	}
	public void setReplyToMessageId(Long replyToMessageId) {
		this.replyToMessageId = replyToMessageId;
	}
	public Long getMessageId() {
		return messageId;
	}
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}
	

}
