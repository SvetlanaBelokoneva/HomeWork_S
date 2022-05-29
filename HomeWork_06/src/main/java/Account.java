public class Account {
    Integer accountNumber;
    private int summ;

    void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    void setAccounts(int accountNumber,  int summ) {
        this.setAccountNumber(accountNumber);
        this.summ = summ;
    }

    @Override
    public String toString() {
        return System.lineSeparator() + "ID счета = " + this.accountNumber + " " +
               "Количество золотых монет = " + this.summ;
    }

   @Override
    public int hashCode() {
        return this.accountNumber == null ? 0 : accountNumber.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (getClass() != other.getClass()) return false;

        Account otherAccount = (Account) other;

        return this.accountNumber.equals(otherAccount.accountNumber);
    }
}
