package com.librarydomain.Repositories;

import com.librarydomain.Entities.Book;
import com.librarydomain.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByTitle(String title);
}