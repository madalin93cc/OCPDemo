package daopattern;

/**
 * Created by Madalin.Colezea on 9/17/2015.
 */
public interface BookDAO {

    Book findByIsbn(String isbn);
    Book update(Book book);
    Book delete(Book book);

}
