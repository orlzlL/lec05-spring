package com.ohgiraffers.section01.common;

import java.util.List;

public interface BookDAO {

    List<BookDTO> findAllBook();        // 하위클래스에서 구현 및 동작 (동적바인딩)

    BookDTO searchBookBySequence(int sequence);
}
