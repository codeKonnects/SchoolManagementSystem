package model;

import libraryconstants.LibraryUsersRating;

import java.util.Objects;

public class LibraryUsers {
    private String fullName;
    private int libraryId;
    private LibraryUsersRating libraryUsersRating;

    private int priority;

    public LibraryUsers(String fullName, int libraryId, LibraryUsersRating libraryUsersRating) {
        this.fullName = fullName;
        this.libraryId = libraryId;
        this.libraryUsersRating = libraryUsersRating;

        setUserPriority();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(int libraryId) {
        this.libraryId = libraryId;
    }

    public LibraryUsersRating getLibraryUsersRating() {
        return libraryUsersRating;
    }

    public void setLibraryUsersRating(LibraryUsersRating libraryUsersRating) {
        this.libraryUsersRating = libraryUsersRating;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
    public void setUserPriority(){
        if(libraryUsersRating == LibraryUsersRating.TEACHER){
            this.priority = LibraryUsersRating.TEACHER.getPriority();
        }else if(libraryUsersRating == LibraryUsersRating.SENIOR_STUDENT){
            this.priority = LibraryUsersRating.SENIOR_STUDENT.getPriority();
        }else{
            this.priority = LibraryUsersRating.JUNIOR_STUDENT.getPriority();
        }
    }

    @Override
    public boolean equals(Object userRequestingBook){
        if(userRequestingBook == this) return true;
        if(!(userRequestingBook instanceof LibraryUsers)) return false;
        LibraryUsers libraryUser = (LibraryUsers) userRequestingBook;
        return getLibraryId() == libraryUser.getLibraryId() && getPriority() == libraryUser.getPriority()
                && getFullName().equals(libraryUser.getFullName()) &&
                getLibraryUsersRating() == libraryUser.getLibraryUsersRating();
    }
    public int hashCode(){
        return Objects.hash(getLibraryUsersRating(), getLibraryId(), getPriority(), getFullName());
    }
}