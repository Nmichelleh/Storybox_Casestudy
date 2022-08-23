package com.book.store.dao;

import com.book.store.enitity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookDAO extends JpaRepository<Book,Long> {
    public Book findById(@Param("id") Integer id);

    @Query(value = "select * from book ", nativeQuery = true)
    public List<Book> allbook();

    @Query(value = "select * from book r where lower(r.book_name) like lower(concat('%', :book_name,'%'))", nativeQuery = true)
    public List<Book> findByName(@Param("book_name")String course);

    public void removeBookById(int id);
}
