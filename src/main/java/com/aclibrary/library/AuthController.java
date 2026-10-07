package com.aclibrary.library;
import java.util.Map; import org.springframework.http.*; import org.springframework.web.bind.annotation.*; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@RestController @RequestMapping("/api/auth")
public class AuthController {
 private final UserRepository repo; private final BCryptPasswordEncoder encoder;
 public AuthController(UserRepository r,BCryptPasswordEncoder e){repo=r;encoder=e;}
 @PostMapping("/login") public ResponseEntity<?> login(@RequestBody Map<String,String> p){User u=repo.findByEmail(p.get("email")).orElse(null);if(u==null||!u.isActive()||u.getRole()!=Role.valueOf(p.getOrDefault("role","STUDENT"))||!encoder.matches(p.getOrDefault("password",""),u.getPassword()))return ResponseEntity.status(401).body(Map.of("message","Invalid email, password, role or disabled account"));return ResponseEntity.ok(Map.of("id",u.getId(),"name",u.getName(),"email",u.getEmail(),"role",u.getRole().name()));}
}
