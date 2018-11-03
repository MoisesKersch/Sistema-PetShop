package com.petshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.petshop.models.Message;
import com.petshop.repositories.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService
{
	private final MessageRepository messageRepository;
	
	public MessageServiceImpl(MessageRepository messageRepository)
	{
		this.messageRepository = messageRepository;	
	}
	
	@Override
	public List<Message> getMessage()
	{
		return messageRepository.findAll();
	}
}
