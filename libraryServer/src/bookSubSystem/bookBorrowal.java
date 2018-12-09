/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookSubSystem;

/**
 *
 * @author Shehab
 */
public class bookBorrowal {
    public int borrowalNumber;
    public String checkOutDate;
    public String checkInDate;
    public String deadlineCheckIn;
    public double fine;
    public String bookId;
    public String studentId;
    public boolean isApproved;

    public bookBorrowal() {
    }

    public bookBorrowal(int borrowalNumber, String checkOutDate, String checkInDate, String deadlineCheckIn, double fine, String bookId, String studentId, boolean isApproved) {
        this.borrowalNumber = borrowalNumber;
        this.checkOutDate = checkOutDate;
        this.checkInDate = checkInDate;
        this.deadlineCheckIn = deadlineCheckIn;
        this.fine = fine;
        this.bookId = bookId;
        this.studentId = studentId;
        this.isApproved = isApproved;
    }
    
  
    public void approveBorrow(boolean approved){
    this.setIsApproved(approved);
    }

    public int getBorrowalNumber() {
        return borrowalNumber;
    }

    public void setBorrowalNumber(int borrowalNumber) {
        this.borrowalNumber = borrowalNumber;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getDeadlineCheckIn() {
        return deadlineCheckIn;
    }

    public void setDeadlineCheckIn(String deadlineCheckIn) {
        this.deadlineCheckIn = deadlineCheckIn;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean isIsApproved() {
        return isApproved;
    }

    public void setIsApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    
    
}
