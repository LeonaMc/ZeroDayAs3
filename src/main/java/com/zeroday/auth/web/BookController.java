package com.zeroday.auth.web;

import com.zeroday.auth.exception.AuthorNotFoundException;
import com.zeroday.auth.exception.BookNotFoundException;
import com.zeroday.auth.model.Author;
import com.zeroday.auth.model.Book;


import com.zeroday.auth.repository.BookRepository;
import com.zeroday.auth.repository.AuthorshipRepository;
import com.zeroday.auth.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorshipRepository authorshipRepository;

    @Autowired
    AuthorRepository authorRepository;

    @RequestMapping({"/list"})
    public String viewHomePage(Model model) {
        List<Book> listBooks = bookRepository.findAll();
        model.addAttribute("listBooks", listBooks);
        return "staffWelcome";
    }

    @GetMapping({"/staffWelcome"})
    public String staffWelcome(Model model) {
        return "staffWelcome";
    }

    // Delete a Note
    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable(value = "id") Long bookId, Model model) throws BookNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));

        bookRepository.delete(book);

        return viewHomePage(model);

    }
    // Create a new Note
    @RequestMapping("/new")
    public String createBook() {
        return "bookform";
    }

    // Create a new Note
    @PostMapping("/books")
    public String createNote(@ModelAttribute("book")  Book book, Model model) {
        bookRepository.save(book);
        return viewHomePage(model);
    }

    // Update a Note
    @RequestMapping(value = "staffWelcome", method = RequestMethod.POST)
    public String updateNote( @ModelAttribute("book")  Book book, Model model) throws BookNotFoundException {

        bookRepository.save(book);

        return viewHomePage(model);
    }

    // Get a Single Note
    @GetMapping("/books/{id}")
    public String getNoteById(@PathVariable(value = "id") Long bookId, Model model)
            throws BookNotFoundException, AuthorNotFoundException {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        model.addAttribute("book", book);

        List<Long> author_ids = authorshipRepository.findAuthorByBookId(book.getId());
        List<Author> authors = new ArrayList<Author>();
        for (Long author_id : author_ids) {
            Author author = authorRepository.findById(author_id)
                    .orElseThrow(() -> new AuthorNotFoundException(author_id));
            authors.add(author);
        }

        model.addAttribute("authors", authors);
        return "editform";
    }

    // Create a new Note
    @RequestMapping("/newgrade")
    public String createGrade() {
        return "newgrade";
    }

    // Create a new Note
    @RequestMapping("/listgrades")
    public String listGrades() {
        return "listgrades";
    }

}
