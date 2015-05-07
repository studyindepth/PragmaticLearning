package hibernate.transaction_concurrency.well;

import java.util.Iterator;

public interface CrubDao<E> {
    E save(E e);

    E update(E e);

    Iterator<E> findAll();
}
