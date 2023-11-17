package com.library.edurekaproj.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String ISBN;
    @ManyToOne
    private Long authorId;
    @Enumerated(EnumType.STRING)
    private BookStatus status;


        public Book() {
                
        }

        public Book(String title, String ISBN, Long authorId) {
            this.title = title;
            this.ISBN = ISBN;
            this.authorId = authorId;
        }
    

        public void setId(long id) {
            this.id = id;
        }
        public long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getISBN() {
            return ISBN;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }
        public void setAuthor(Long authorId) {
            this.authorId = authorId;
        }
        public Long getAuthorId() {
            return authorId;
        }

}

enum BookStatus {
    AVAILABLE,
    BORROWED
}