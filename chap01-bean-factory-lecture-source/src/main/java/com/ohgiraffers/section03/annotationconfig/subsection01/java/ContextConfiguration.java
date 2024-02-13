package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/* 설명. 설정용 클래스도 bean으로 관리되며 이름(bean의 id)을 부여할 수 있다. */
@Configuration("configurationSection03")
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {


}
