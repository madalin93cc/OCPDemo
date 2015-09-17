import daopattern.BookDAO;
import daopattern.InMemoryBookDAO;

/**
 * Created by Madalin.Colezea on 9/17/2015.
 */
public class FactoryMethodPattern {

    public static void main(String[] args) {
        Factory factory = new FactoryImpl();
        BookDAO bookDAO = factory.getDao();
    }
}

abstract class Factory {
    public BookDAO getDao() {
        if (true) return new InMemoryBookDAO();
        else {
            return getAnotherImplementation();
        }
    }

    protected abstract BookDAO getAnotherImplementation();
}

class FactoryImpl extends Factory{

    @Override
    protected BookDAO getAnotherImplementation() {
        return null; // other implementation
    }
}
