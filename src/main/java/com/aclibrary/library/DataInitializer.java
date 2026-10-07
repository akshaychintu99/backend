package com.aclibrary.library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {
 @Bean CommandLineRunner seed(UserRepository users, BookRepository books, BCryptPasswordEncoder encoder){return args->{
   if(users.count()==0){
    users.save(user("M. Akshay","admin@aclibrary.test","Admin@123",Role.ADMIN,encoder));
    users.save(user("Ravi Library","ravi.library@aclibrary.test","Staff@123",Role.STAFF,encoder));
    users.save(user("M. Akshay","akshay@aclibrary.test","Student@123",Role.STUDENT,encoder));
   }
   if(books.count()==0){books.save(book("Java Programming","Herbert Schildt","9780071808552","Programming",5,5,"A-01"));books.save(book("Database System Concepts","Silberschatz","9780073523323","Database",4,4,"B-02"));books.save(book("Computer Networks","Andrew S. Tanenbaum","9780132126953","Networking",3,3,"C-01"));}
 };}
 private User user(String n,String e,String p,Role r,BCryptPasswordEncoder enc){User u=new User();u.setName(n);u.setEmail(e);u.setPassword(enc.encode(p));u.setRole(r);u.setActive(true);return u;}
 private Book book(String t,String a,String i,String c,int total,int avail,String shelf){Book b=new Book();b.setTitle(t);b.setAuthor(a);b.setIsbn(i);b.setCategory(c);b.setTotalCopies(total);b.setAvailableCopies(avail);b.setShelfLocation(shelf);return b;}
}
