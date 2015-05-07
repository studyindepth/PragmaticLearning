package hibernate.transaction_concurrency.well;

import java.util.Iterator;

import org.hibernate.Session;

public abstract class AbstractDao<E> implements CrubDao<E> {
    private Session session;

    public AbstractDao(Session session) {
        this.session = session;
    }

    protected Session getSession() {
        return session;
    }

    @Override
    public E save(E e) {
        session.save(e);
        return e;
    }

    @Override
    public E update(E e) {
        session.update(e);
        return e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> findAll() {
        return ((Iterator<E>) session.createCriteria(getEntityType()).list());
    }

    protected abstract Class<?> getEntityType();
}
