package hibernate.transaction_concurrency;

import java.util.Collection;

import org.hibernate.Session;

public class CrubDao<E> {
    Session getSession() {
        Session session = SessionManager.getSession();
        System.out.println(session.hashCode() + " : " + getClass() + " : " + Thread.currentThread());
        return session;
    }

    public E save(E e) {
        getSession().save(e);
        return e;
    }

    public E update(E e) {
        getSession().update(e);
        return e;
    }

    @SuppressWarnings("unchecked")
    public E find(long id, Class<E> type) {
        return (E) getSession().get(type, id);
    }

    @SuppressWarnings("unchecked")
    public Collection<E> findAll(Class<E> type) {
        return getSession().createCriteria(type).list();
    }
}
