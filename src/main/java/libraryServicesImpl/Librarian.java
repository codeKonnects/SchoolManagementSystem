package libraryServicesImpl;

import model.Books;
import model.LibraryUsers;
import services.LibrarianDuties;

import java.util.*;

public class Librarian implements LibrarianDuties {
    private final static Map<String, Integer> libraryBookList = new HashMap<>();

    private final static Map<String, Enum> bookBorrowers = new HashMap<>();

    private final static Queue<LibraryUsers> libraryUsersQueue = new LinkedList<>();

    private final static Queue<LibraryUsers> ratedLibraryUsersQueue = new PriorityQueue(new Comparator<LibraryUsers>(){
                @Override
                public int compare(LibraryUsers user1, LibraryUsers user2) {
                    if (user1.getPriority() < user2.getPriority()) {
                        return -1;
                    }
                    else if (user1.getPriority() > user2.getPriority()) {
                        return 1;
                    }else {
                        return 0;
                    }
                }
            });

    public Map<String, Enum> getBookBorrowers() {
        return bookBorrowers;
    }



    public Queue<LibraryUsers> getLibraryUsersQueue() {
        return libraryUsersQueue;
    }

    public Queue<LibraryUsers> getRatedLibraryUsersQueue() {
        return ratedLibraryUsersQueue;
    }
    @Override
    public Map<String, Integer> getLibraryBookList() {
        return libraryBookList;
    }


    public Librarian() {
    }


    @Override
    public void addBookToShelf(Books books, int numberOfCopies) {
        if (this.getLibraryBookList().containsKey(books.getLibraryBooks().name())){
            this.getLibraryBookList().put(books.getLibraryBooks().name(),
                    this.getLibraryBookList().get(books.getLibraryBooks().name()) + numberOfCopies);
        }else{
            this.getLibraryBookList().put(books.getLibraryBooks().name(), numberOfCopies);
        }

    }

    @Override
    public void returnBookToShelf(Books books) {
        if (this.getLibraryBookList().containsKey(books.getLibraryBooks().name())){
            this.getLibraryBookList().put(books.getLibraryBooks().name(),
                    this.getLibraryBookList().get(books.getLibraryBooks().name()) +1);
        }else {
            this.getLibraryBookList().put(books.getLibraryBooks().name(), 1);
        }

    }

    @Override
    public void releaseBookToUserOnPriority() {
        if (!(ratedLibraryUsersQueue.isEmpty())){
            final LibraryUsers libraryUsers = this.getRatedLibraryUsersQueue().remove();
            final Enum bookBorrowed = this.getBookBorrowers().get(libraryUsers.getFullName());
            final int bookCopies = this.getLibraryBookList().get(bookBorrowed.toString());
            if (bookCopies > 0){
                System.out.println(libraryUsers.getLibraryUsersRating() +
                        " " + libraryUsers.getFullName() + " ,has been issued " + bookBorrowed +" successfully");
                this.getLibraryBookList().put(bookBorrowed.name(), bookCopies-1);
            }else {
                System.out.println("Book has been taken!");
            }
        }

    }

    @Override
    public void userBookRequest(LibraryUsers libraryUsers, Books books) {
        if (libraryUsers != null && !this.getLibraryUsersQueue().contains(libraryUsers) &&
        this.getLibraryBookList().containsKey(books.getLibraryBooks().name())){
            this.getLibraryUsersQueue().add(libraryUsers);
            this.getBookBorrowers().put(libraryUsers.getFullName(), books.getLibraryBooks());
            this.getRatedLibraryUsersQueue().add(libraryUsers);
        }

    }

    @Override
    public void releaseBookOnFirstCome() {
        if (!(libraryUsersQueue.isEmpty())){
           final LibraryUsers libraryUsers = this.getLibraryUsersQueue().remove();
           final Enum bookBorrowed = this.getBookBorrowers().get(libraryUsers.getFullName());
           final int bookCopies = this.getLibraryBookList().get(bookBorrowed.toString());
           if(bookCopies > 0){
               System.out.println(libraryUsers.getLibraryUsersRating() + " " + libraryUsers.getFullName() +
                       " , has been issued " + bookBorrowed + " successfully");
               this.getLibraryBookList().put(bookBorrowed.name(), bookCopies -1);
           }else{
               System.out.println("Book has been taken!");
           }
        }

    }
}
