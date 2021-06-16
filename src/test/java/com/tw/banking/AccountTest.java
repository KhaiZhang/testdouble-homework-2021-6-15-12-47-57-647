package com.tw.banking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class AccountTest {

    @Test
    void should_deposit_when_account_add_amount() {
        //given
        Printer printer = new Printer(new Console());
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        TransactionRepository spyTxnRepo = Mockito.spy(transactionRepository);
        Account account = new Account(spyTxnRepo, printer);

        //when
        account.deposit(100);

        //then
        Mockito.verify(spyTxnRepo).addDeposit(100);
    }

    @Test
    void should_withdraw_when_account_decrease_amount() {
        //given
        Printer printer = new Printer(new Console());
        TransactionRepository transactionRepository = new TransactionRepository(new Clock());
        TransactionRepository spyTxnRepo = Mockito.spy(transactionRepository);
        Account account = new Account(spyTxnRepo, printer);

        //when
        account.withdraw(100);

        //then
        Mockito.verify(spyTxnRepo).addWithdraw(100);
    }
}