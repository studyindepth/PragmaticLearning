package hibernate.transaction_concurrency.well;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction;
import org.hibernate.engine.transaction.spi.TransactionCoordinator;
import org.hibernate.engine.transaction.spi.TransactionFactory;

public class WellJDBCTransactionFactory implements TransactionFactory<JdbcTransaction> {

    @Override
    public JdbcTransaction createTransaction(TransactionCoordinator transactionCoordinator) {
        return new JdbcTransaction(transactionCoordinator);
    }

    @Override
    public boolean canBeDriver() {
        return true;
    }

    @Override
    public ConnectionReleaseMode getDefaultReleaseMode() {
        return ConnectionReleaseMode.ON_CLOSE;
    }

    @Override
    public boolean compatibleWithJtaSynchronization() {
        return false;
    }

    @Override
    public boolean isJoinableJtaTransaction(TransactionCoordinator transactionCoordinator, JdbcTransaction transaction) {
        return false;
    }

}
