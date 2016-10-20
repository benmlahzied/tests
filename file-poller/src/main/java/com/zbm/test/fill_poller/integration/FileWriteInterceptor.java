package com.zbm.test.fill_poller.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;

import com.jayway.jsonpath.internal.filter.FilterCompiler;

@MessageEndpoint
public class FileWriteInterceptor implements org.springframework.messaging.support.ChannelInterceptor {
	
	@Autowired
	private FileCopyDAO copyDao;

	@Override
	public void afterReceiveCompletion(Message<?> arg0, MessageChannel arg1, Exception arg2) {
	}

	@Override
	public void afterSendCompletion(Message<?> arg0, MessageChannel arg1, boolean arg2, Exception arg3) {
	}

	@Override
	public Message<?> postReceive(Message<?> arg0, MessageChannel arg1) {
		return arg0;
	}

	@Override
	public void postSend(Message<?> arg0, MessageChannel arg1, boolean arg2) {
		copyDao.addFileCopy();
		// save to DB, we can also check the file in the destination folder 
	}

	@Override
	public boolean preReceive(MessageChannel arg0) {
		return true;
	}

	@Override
	public Message<?> preSend(Message<?> arg0, MessageChannel arg1) {
		return arg0;
	}
}
