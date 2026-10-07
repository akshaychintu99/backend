package com.aclibrary.library;
import jakarta.persistence.*;
@Entity @Table(name="fines")
public class Fine {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) private User student; @ManyToOne(optional=false) private Book book; private int overdueDays; private double amount; @Enumerated(EnumType.STRING) private FineStatus status=FineStatus.PENDING;
 public Long getId(){return id;} public User getStudent(){return student;} public void setStudent(User v){student=v;} public Book getBook(){return book;} public void setBook(Book v){book=v;} public int getOverdueDays(){return overdueDays;} public void setOverdueDays(int v){overdueDays=v;} public double getAmount(){return amount;} public void setAmount(double v){amount=v;} public FineStatus getStatus(){return status;} public void setStatus(FineStatus v){status=v;}
}
