package hibernate.transaction_concurrency.well;

public interface DaoCommand<T> {
    T execute(DaoManager<? extends CrubDao<?>> manager);
}
