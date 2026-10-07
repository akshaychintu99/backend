package com.aclibrary.library;
import jakarta.persistence.*; import java.time.LocalDate;
@Entity @Table(name="book_issues")
public class Issue {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) private Book book; @ManyToOne(optional=false) private User student; private LocalDate issueDate; private LocalDate dueDate; private LocalDate returnDate;
 public Long getId(){return id;} public Book getBook(){return book;} public void setBook(Book v){book=v;} public User getStudent(){return student;} public void setStudent(User v){student=v;} public LocalDate getIssueDate(){return issueDate;} public void setIssueDate(LocalDate v){issueDate=v;} public LocalDate getDueDate(){return dueDate;} public void setDueDate(LocalDate v){dueDate=v;} public LocalDate getReturnDate(){return returnDate;} public void setReturnDate(LocalDate v){returnDate=v;}
}
