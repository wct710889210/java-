package com.wct.rpc.service.impl;

import com.wct.rpc.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class AlertServiceImpl implements AlertService {

    @Autowired
    private JmsOperations jmsOperations;

    @Override
    public void sendStringMsg(final String msg) {
        jmsOperations.send("wct.alert.queue", new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(msg);
            }
        });
    }
}
