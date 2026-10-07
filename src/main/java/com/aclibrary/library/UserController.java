package com.aclibrary.library;
import org.springframework.web.bind.annotation.*; import org.springframework.http.*; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@RestController @RequestMapping("/api/users") public class UserController{
 private final UserRepository repo; private final BCryptPasswordEncoder enc; UserController(UserRepository r,BCryptPasswordEncoder e){repo=r;enc=e;}
 @GetMapping public Iterable<User> all(){return repo.findAll();}
 @GetMapping("/{id}") public ResponseEntity<User> one(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
 @PostMapping public ResponseEntity<?> create(@RequestBody User u){if(repo.findByEmail(u.getEmail()).isPresent())return ResponseEntity.badRequest().body(java.util.Map.of("message","Email already exists"));u.setPassword(enc.encode(u.getPassword()));return ResponseEntity.ok(repo.save(u));}
 @PutMapping("/{id}") public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User u){return repo.findById(id).map(x->{x.setName(u.getName());x.setEmail(u.getEmail());x.setRole(u.getRole());x.setActive(u.isActive());if(u.getPassword()!=null&&!u.getPassword().isBlank())x.setPassword(enc.encode(u.getPassword()));return ResponseEntity.ok(repo.save(x));}).orElse(ResponseEntity.notFound().build());}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
}
