package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor")
public class BookService {

    //@Autowired --> 필드 주입
    // 생성자 주입과 필드 주입의 가장 큰 차이점
    //필드 주입 할 떄 final 달면 절대 초기화가 안 될 것 (필드 주입은 final을 걸 수 없음 JVM이 초기화한 null값 이후에 초기화가 안 됨)
    private final BookDAO bookDAO;

    /* 설명.
     *  BookDAO 타입의 빈 객체를 생성자를 통해 주입 받는다.
     *  (@Autowired를 생성자에 작성하고 주입받을 타입의 bean을 매개변수로 작성한다.) (기본생성자 x)
     *
     * 설명.
     *  생성자 주입의 이점
     *  1. 필드에 final 키워드를 사용할 수 있다.
     *  2. 순환참조를 스프링 시작(컨테이너 생성 시)과 동시에 확인하고 에러를 발생시켜 준다.
     *  3. 중간에 값이 오염되지 않음을 확신을 가지고 쓸 수 있다. (불변성)
     *  4. 테스트 코드 작성 시 테스트 코드에 @Autowired 또는 주입받는 대상의 setter 등을 추가하지 않고 순수 자바 코드로 테스트 가능하다.
    **/


    // jvm, 명시적, 명시자블록, 생성자에의한 초기화 가 있는데 필드주입을 하면 불안함
    // 1. 생성자주입하면 반드시 의도한 객체가 주입되므로 final을 붙일 수 있게 되고 이 이후에 오염될 일이 없음
    // 2. 생성자에 의한 초기화를 하면 bookDAO type이 존재하지 않으면 spring container가 켜질 때부터 에러가 남 (처음부터 안 켜지도록 막아줌)
    // 근데 필드초기화하면 코드가 동작하다가 null값이 들어갔다가 null pointer exception이 발생할 수 있음
    // 3. 생성자에의한 초기화를 하면 순환참조도 막을 수가 있다
    @Autowired      // 생성자 주입
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBook(){
        return bookDAO.findAllBook();
    }

    public BookDTO searchBookBySequence(int sequence) {
        return bookDAO.searchBookBySequence(sequence);
    }
}
