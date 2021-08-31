package org.orkhon.domain;

import java.util.Date;

public class BorrowItem extends Entity<Long>{
    public int bookId;
    public int borrowTakerId;
    public int borrowGiverId;
    public Date borrowDate;
    public Date plannedReturnDate;
    public Date realReturnDate;
}
