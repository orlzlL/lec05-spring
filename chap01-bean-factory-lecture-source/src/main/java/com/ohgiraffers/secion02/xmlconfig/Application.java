package com.ohgiraffers.secion02.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.lang.reflect.Member;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context
                = new GenericXmlApplicationContext("section02/xmlconfig/spring-context.xml");

        MemberDTO member = (MemberDTO)context.getBean("member");
        System.out.println("member = " + member);

    }
}
