package com.librarydomain.Entities;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Isbn")
    private String Isbn;
    @Column(name = "title")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "borrowed")
    private boolean borrowed;
    //year of publication
    @Column(name = "year_of_publication")
    private int year_of_publication;
    //publisher
    @Column(name = "publisher")
    private String publisher;

    //lien image url
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowedBy;

    public Book() {
    }

    public Book(Long id, String Isbn, String title, String author, boolean borrowed, int year_of_publication, String publisher, String imageUrl, User borrowedBy) {
        this.id = id;
        this.Isbn = Isbn;
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;
        this.year_of_publication = year_of_publication;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.borrowedBy = borrowedBy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return Isbn;
    }

    public void setIsbn(String Isbn) {
        this.Isbn = Isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public int getYear_of_publication() {
        return year_of_publication;
    }

    public void setYear_of_publication(int year_of_publication) {
        this.year_of_publication = year_of_publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    @Override

    public String toString() {
        return "Book{" +
                "id=" + id +
                ", Isbn='" + Isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", borrowed=" + borrowed +
                ", year_of_publication=" + year_of_publication +
                ", publisher='" + publisher + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", borrowedBy=" + borrowedBy +
                '}';
    }




}
