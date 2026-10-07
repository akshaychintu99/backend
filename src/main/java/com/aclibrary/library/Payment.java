package com.aclibrary.library;
import jakarta.persistence.*; import java.time.LocalDateTime;
@Entity @Table(name="payments")
public class Payment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id; @ManyToOne(optional=false) private Fine fine; @ManyToOne(optional=false) private User student; private double amount; private String method; private String reference; @Enumerated(EnumType.STRING) private PaymentStatus status=PaymentStatus.SUCCESS; private LocalDateTime paidAt=LocalDateTime.now();
 public Long getId(){return id;} public Fine getFine(){return fine;} public void setFine(Fine v){fine=v;} public User getStudent(){return student;} public void setStudent(User v){student=v;} public double getAmount(){return amount;} public void setAmount(double v){amount=v;} public String getMethod(){return method;} public void setMethod(String v){method=v;} public String getReference(){return reference;} public void setReference(String v){reference=v;} public PaymentStatus getStatus(){return status;} public void setStatus(PaymentStatus v){status=v;} public LocalDateTime getPaidAt(){return paidAt;} public void setPaidAt(LocalDateTime v){paidAt=v;}
}
