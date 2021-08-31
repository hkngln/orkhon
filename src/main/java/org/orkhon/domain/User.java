package org.orkhon.domain;

import java.util.List;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private List<BorrowItem> takenBorrowedItems;
    List<BorrowItem> givenBorrowedItems;

    public List<BorrowItem> getGivenBorrowedItems() {
        return givenBorrowedItems;
    }

    public List<BorrowItem> getTakenBorrowedItems() {
        return takenBorrowedItems;
    }
}
