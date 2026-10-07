package com.aclibrary.library;
import org.springframework.web.bind.annotation.*; import org.springframework.http.*;
@RestController @RequestMapping("/api/books") public class BookController{
 private final BookRepository repo; BookController(BookRepository r){repo=r;}
 @GetMapping public Iterable<Book> all(){return repo.findAll();}
 @GetMapping("/{id}") public ResponseEntity<Book> one(@PathVariable Long id){return repo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());}
 @PostMapping public Book create(@RequestBody Book b){return repo.save(b);}
 @PutMapping("/{id}") public ResponseEntity<Book> update(@PathVariable Long id,@RequestBody Book b){return repo.findById(id).map(x->{x.setTitle(b.getTitle());x.setAuthor(b.getAuthor());x.setIsbn(b.getIsbn());x.setCategory(b.getCategory());x.setTotalCopies(b.getTotalCopies());x.setAvailableCopies(b.getAvailableCopies());x.setShelfLocation(b.getShelfLocation());return ResponseEntity.ok(repo.save(x));}).orElse(ResponseEntity.notFound().build());}
 @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){if(!repo.existsById(id))return ResponseEntity.notFound().build();repo.deleteById(id);return ResponseEntity.noContent().build();}
}
