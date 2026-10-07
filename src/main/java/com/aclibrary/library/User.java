package com.aclibrary.library;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity @Table(name="users")
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false) private String name;
 @Column(nullable=false,unique=true) private String email;
 @JsonProperty(access=JsonProperty.Access.WRITE_ONLY) @Column(nullable=false) private String password;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private Role role=Role.STUDENT;
 @Column(nullable=false) private boolean active=true;
 public Long getId(){return id;} public void setId(Long v){id=v;} public String getName(){return name;} public void setName(String v){name=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;} public Role getRole(){return role;} public void setRole(Role v){role=v;} public boolean isActive(){return active;} public void setActive(boolean v){active=v;}
}
