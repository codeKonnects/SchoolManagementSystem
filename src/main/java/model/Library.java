package model;

import libraryServicesImpl.Librarian;
import libraryconstants.LibraryBooks;
import libraryconstants.LibraryUsersRating;

public class Library {
    public static void main(String[] args) {
        Librarian librarian = new Librarian();


        Books javaHead = new Books(LibraryBooks.JAVA_HEAD);
        Books thePilgrimage = new Books(LibraryBooks.THE_PILGRIMAGE);
        Books creativeDesign = new Books(LibraryBooks.CREATIVE_DESIGN);
        Books grokkingAlgorithm = new Books(LibraryBooks.GROKKING_ALGORITHM);
        Books algorithmAndDataStructure = new Books(LibraryBooks.ALGORITHM_AND_DATA_STRUCTURE);
        Books introductionToIt = new Books(LibraryBooks.INTRODUCTION_TO_IT);

        LibraryUsers demi = new LibraryUsers("Demilade", 002, LibraryUsersRating.JUNIOR_STUDENT);
        LibraryUsers david = new LibraryUsers("David", 001, LibraryUsersRating.SENIOR_STUDENT);
        LibraryUsers warith = new LibraryUsers("Warith", 003, LibraryUsersRating.TEACHER);
        LibraryUsers uche = new LibraryUsers("Uchenna", 004, LibraryUsersRating.JUNIOR_STUDENT);
        LibraryUsers segun = new LibraryUsers("Segun", 005, LibraryUsersRating.SENIOR_STUDENT);
        LibraryUsers james = new LibraryUsers("James", 006, LibraryUsersRating.TEACHER);

        librarian.addBookToShelf(javaHead, 2);
        librarian.addBookToShelf(thePilgrimage, 3);
        librarian.addBookToShelf(creativeDesign, 1);
        librarian.addBookToShelf(grokkingAlgorithm, 2);
        librarian.addBookToShelf(algorithmAndDataStructure, 5);
        librarian.addBookToShelf(introductionToIt, 1);
       // librarian.addBookToShelf(introductionToIt, 5);

        System.out.println(librarian.getLibraryBookList());



        librarian.userBookRequest(demi, javaHead);
        librarian.userBookRequest(james, introductionToIt);
        librarian.userBookRequest(warith, thePilgrimage);
        librarian.userBookRequest(segun, grokkingAlgorithm);
        librarian.userBookRequest(uche, algorithmAndDataStructure);
        librarian.userBookRequest(david, algorithmAndDataStructure);



        librarian.releaseBookOnFirstCome();
        librarian.releaseBookOnFirstCome();
        librarian.releaseBookOnFirstCome();
        librarian.releaseBookOnFirstCome();
        librarian.releaseBookOnFirstCome();
        librarian.releaseBookOnFirstCome();

        System.out.println(librarian.getLibraryBookList());
        System.out.println(librarian.getBookBorrowers());
        librarian.returnBookToShelf(introductionToIt);
        System.out.println(librarian.getLibraryBookList());








//        librarian.releaseBookToUserOnPriority();
//        librarian.releaseBookToUserOnPriority();
//        librarian.releaseBookToUserOnPriority();
//        librarian.releaseBookToUserOnPriority();
//        librarian.releaseBookToUserOnPriority();
//        librarian.releaseBookToUserOnPriority();


        //System.out.println(librarian.getLibraryBookList());







    }
}
