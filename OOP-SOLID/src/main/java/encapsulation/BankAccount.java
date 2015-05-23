package encapsulation;

import java.math.BigDecimal;
import java.util.Objects;

public class BankAccount {

	private AccountBalance balance;

	private BankAccountStatus status;

	public BankAccount(BigDecimal initBalance) {

	}

	public void withDraw(AccountNumber amount) {
		amount = Objects.requireNonNull(amount);
		validateAccountState();
		balance.substract(amount);
	}

	public void deposite(AccountNumber amount) {
		amount = Objects.requireNonNull(amount);
		validateAccountState();
		balance.add(amount);
	}

	private void validateAccountState() {
		if (isDeactive()) {
			throw new IllegalAccountStateException();
		}
	}

	public boolean isActive() {
		return status == BankAccountStatus.ACTIVE;
	}

	public boolean isDeactive() {
		return status == BankAccountStatus.DEACTIVE;
	}

	public static enum BankAccountStatus {
		ACTIVE, DEACTIVE
	}

	public static class AccountNumber {
		protected BigDecimal value;

		public AccountNumber(BigDecimal value) {
			this.value = value;
		}

		public boolean isPositive() {
			return compareToZero() > 0;
		}

		public boolean isNegative() {
			return !isPositive();
		}

		public boolean isZero() {
			return compareToZero() == 0;
		}

		private int compareToZero() {
			return value.compareTo(BigDecimal.ZERO);
		}

		public BigDecimal getValue() {
			return value;
		}

		public void substract(AccountNumber amount) {
			value = value.subtract(amount.getValue());
		}

		public void add(AccountNumber amount) {
			value = value.add(amount.getValue());
		}

		public boolean isGreaterThan(AccountNumber amount) {
			return compareTo(amount) > 0;
		}

		public boolean isLessThan(AccountNumber amount) {
			return !isGreaterThan(amount);
		}

		public boolean isEqual(AccountNumber amount) {
			return value.equals(amount.getValue());
		}

		private int compareTo(AccountNumber amount) {
			return value.compareTo(amount.getValue());
		}

	}

	public static class AccountBalance extends AccountNumber {

		public AccountBalance(BigDecimal value) {
			super(value);
		}

		@Override
		public void substract(AccountNumber amount) {
			validateBeforeSubtracting(amount);
			super.substract(amount);
		}

		private void validateBeforeSubtracting(AccountNumber amount) {
			if (isLessThan(amount)) {
				throw new InsufficientAmountOfMoneyException();
			}
		}

		@Override
		public void add(AccountNumber amount) {
			validateBeforeAdding(amount);
			super.add(amount);
		}

		private void validateBeforeAdding(AccountNumber amount) {
			if (amount.isNegative()) {
				throw new IllegalArgumentException();
			}
		}

	}

}
