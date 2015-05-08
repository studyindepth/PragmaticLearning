package hibernate.transaction_concurrency.well;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao<E> implements CrubDao<E> {
    private SessionFactory session;

    public AbstractDao(SessionFactory sf) {
        this.session = sf;
    }

    protected Session getSession() {
        return session.getCurrentSession();
    }

    @Override
    public E save(E e) {
        getSession().save(e);
        return e;
    }

    @Override
    public E update(E e) {
        getSession().update(e);
        return e;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<E> findAll() {
        return ((Iterator<E>) getSession().createCriteria(getEntityType()).list());
    }

    protected abstract Class<?> getEntityType();
}
