package model;

import libraryconstants.LibraryBooks;

import java.util.Objects;

public class Books {
    private LibraryBooks libraryBooks;

    public Books(LibraryBooks libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public LibraryBooks getLibraryBooks() {
        return libraryBooks;
    }
}

//    @Override
//    public boolean equals(Object userBookRequest){
//        if(userBookRequest == this) return true;
//        if( userBookRequest == null || getClass() != userBookRequest.getClass()) return false;
//        Books libraryBook = (Books) userBookRequest;
//        return libraryBooks == libraryBook.libraryBooks;
//    }
//    public int hashCode(){
//        return Objects.hash(libraryBooks);
//    }
//}
