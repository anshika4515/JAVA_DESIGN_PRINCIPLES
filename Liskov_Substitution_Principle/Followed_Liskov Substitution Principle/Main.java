
import java.util.ArrayList;
import java.util.List;

interface DepositOnlyAccount {

    void deposit(double amount);
}

interface WithdrawalAccount extends DepositOnlyAccount {

    void withdraw(double amount);
}

class SavingAccount implements WithdrawalAccount {

    private double balance;

    public SavingAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited" + amount + "in savings Account" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn" + amount + "from savings Acoount" + balance);
        } else {
            System.out.println("Insufficient funds in Saving Account");
        }
    }
}

class CurrentAccount implements WithdrawalAccount {

    private double balance = 0;

    public CurrentAccount() {
        balance = 0;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited" + amount + "in current Account" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn" + amount + "from current Acoount" + balance);
        } else {
            System.out.println("Insufficient funds in Current Account");
        }
    }
}

class FixedAccount implements DepositOnlyAccount {

    private double balance;

    public FixedAccount() {
        balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited" + amount + "in Fixed  Account" + balance);
    }
}

class BankClient {

    private List<WithdrawalAccount> withdrawalAccounts;
    private List<DepositOnlyAccount> depositOnlyAccounts;

    public BankClient(List<WithdrawalAccount> withdrawalAccounts, List<DepositOnlyAccount> depositOnlyAccounts) {
        this.withdrawalAccounts = withdrawalAccounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }

    public void processTransactions() {
        for (WithdrawalAccount acc : withdrawalAccounts) {
            acc.deposit(1000);
            acc.withdraw(500);
        }

        for (DepositOnlyAccount acc : depositOnlyAccounts) {
            acc.deposit(5000);
        }
    }

}

class Main {

    public static void main(String[] args) {
        List<WithdrawalAccount> withdrawalAccounts = new ArrayList<>();
        withdrawalAccounts.add(new SavingAccount());
        withdrawalAccounts.add(new CurrentAccount());

        List<DepositOnlyAccount> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedAccount());

        BankClient client = new BankClient(withdrawalAccounts, depositOnlyAccounts);
        client.processTransactions();
    }
}
