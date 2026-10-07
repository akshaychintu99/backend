package com.aclibrary.library;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="book_requests")
public class BookRequest {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @ManyToOne(optional=false) private Book book; @ManyToOne(optional=false) private User student;
 @Enumerated(EnumType.STRING) private RequestStatus status=RequestStatus.PENDING; private LocalDateTime requestedAt=LocalDateTime.now();
 public Long getId(){return id;} public Book getBook(){return book;} public void setBook(Book v){book=v;} public User getStudent(){return student;} public void setStudent(User v){student=v;} public RequestStatus getStatus(){return status;} public void setStatus(RequestStatus v){status=v;} public LocalDateTime getRequestedAt(){return requestedAt;} public void setRequestedAt(LocalDateTime v){requestedAt=v;}
}
