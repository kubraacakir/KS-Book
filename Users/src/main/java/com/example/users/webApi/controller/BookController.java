package com.example.users.webApi.controller;

import com.example.users.business.abstracts.BookService;
import com.example.users.model.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
@CrossOrigin
public class BookController {
    private final BookService bookService;
    @GetMapping("/get/{categoryId}")
    public ResponseEntity<Set<BookDto>> getBookWithCategoryId(@PathVariable UUID categoryId) {
        return new ResponseEntity<>(bookService.getBookWithCategoryId(categoryId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDto> saveBook(@RequestBody BookDto bookDto) {
        return new ResponseEntity<>(bookService.saveBook(bookDto), HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Set<BookDto>> getAllBook(){
        return new ResponseEntity<>(bookService.getAllBook(),HttpStatus.OK);
    }
}
