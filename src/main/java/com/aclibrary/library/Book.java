package com.aclibrary.library;
import jakarta.persistence.*;
@Entity @Table(name="books")
public class Book {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String title; @Column(nullable=false) private String author;
 @Column(nullable=false,unique=true) private String isbn; private String category; private int totalCopies; private int availableCopies; private String shelfLocation;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getTitle(){return title;} public void setTitle(String v){title=v;} public String getAuthor(){return author;} public void setAuthor(String v){author=v;} public String getIsbn(){return isbn;} public void setIsbn(String v){isbn=v;} public String getCategory(){return category;} public void setCategory(String v){category=v;} public int getTotalCopies(){return totalCopies;} public void setTotalCopies(int v){totalCopies=v;} public int getAvailableCopies(){return availableCopies;} public void setAvailableCopies(int v){availableCopies=v;} public String getShelfLocation(){return shelfLocation;} public void setShelfLocation(String v){shelfLocation=v;}
}
