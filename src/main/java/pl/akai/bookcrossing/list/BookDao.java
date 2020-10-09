package pl.akai.bookcrossing.list;

import pl.akai.bookcrossing.model.Book;

public interface BookDao {

    Book findFirstBookWithId(int bookId);

}
