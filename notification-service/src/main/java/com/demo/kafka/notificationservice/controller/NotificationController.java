package com.demo.kafka.notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.notificationservice.producer.Producer;

@RestController
@RequestMapping(value = "/notify")
public class NotificationController {

	private final Producer producer;

	   @Autowired
	   NotificationController(Producer producer) {
	       this.producer = producer;
	   }

	   @PostMapping(value = "/publish")
	   public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
	       this.producer.sendMessage(message);
	   }
}
