package com.wct.rpc.mian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        JmsTemplate jmsTemplate = (JmsTemplate)context.getBean("jmsTemplate");
        jmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage("test");
            }
        });

        System.out.print("sended\n");

//        ObjectMessage objectMessage = (ObjectMessage)jmsTemplate.receive();
//        try {
//            String msg = (String)objectMessage.getObject();
//            System.out.print("msg:"+msg+"\n");
//        } catch (JMSException e) {
//            e.printStackTrace();
//        }
    }
}
