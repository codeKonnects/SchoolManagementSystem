package services;

import model.Books;
import model.LibraryUsers;

import java.util.Map;

public interface LibrarianDuties {
    void addBookToShelf(Books books, int numberOfCopies);
    void returnBookToShelf(Books books);
    void releaseBookToUserOnPriority();
    void userBookRequest(LibraryUsers libraryUsers, Books books);
    void releaseBookOnFirstCome();

    Map<String, Integer> getLibraryBookList();
}
