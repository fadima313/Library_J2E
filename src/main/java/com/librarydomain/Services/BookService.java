package com.librarydomain.Services;

import com.librarydomain.Entities.Book;
import com.librarydomain.Entities.User;

import com.librarydomain.Repositories.BookRepository;
import com.librarydomain.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId);
        User user = userRepository.findById(userId).orElse(null);

        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        if (book.isBorrowed()) {
            throw new RuntimeException("Book already borrowed");
        }
        if (user == null) {
            throw new RuntimeException("User not found");
        }

        book.setBorrowedBy(user);
        book.setBorrowed(true);
        return save(book);
    }

    public Book returnBook(Long bookId) {
        Book book = findById(bookId);

        if (book == null) {
            throw new RuntimeException("Book not found");
        }
        if (!book.isBorrowed()) {
            throw new RuntimeException("Book not borrowed");
        }

        book.setBorrowedBy(null);
        book.setBorrowed(false);
        return save(book);
    }
}