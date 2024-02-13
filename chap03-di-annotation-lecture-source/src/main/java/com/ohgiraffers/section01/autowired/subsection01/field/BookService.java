package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Componnnt         // <-- 계층의 의미가 있다.
@Service            // 여기가 서비스 계층임을 나타냄 (딱히 기능은 없음), Component Scan 범위 내에 있으면 Bean으로 관리됨
public class BookService {

    /* 설명.
     *  아래의 세 가지는 ComponentScan 범위 안에 어노테이션들이 달렸을 때 유효하다.
     *  1. @Service에 의해서 BookService 타입의 bookService bean이 관리된다.
     *  2. BookDAOImpl에 있는 @Repository에 의해서 bookDAOImpl bean이 관리된다. (BookDAO 타입이기도 하다.)
     *  3. @Autowired에 의해서 BookDAO 타입의 빈이 BookService의 필드인 bookDAO 필드에 주입된다.(대입된다.)
    **/
    @Autowired
    private BookDAO bookDAO;        // ComponentScan 범위 안에 BookDAO 타입의 bean이 대입됨

    public BookService() {
    }

    /* 설명. 도서 목록 전체 조회 */
    public List<BookDTO> findAllBook(){
        return bookDAO.findAllBook();
    }

}
