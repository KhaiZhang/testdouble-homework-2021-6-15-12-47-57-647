package com.tw.banking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

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

    @Test
    void should_print_all_transaction_when_account_print_statement() {
        //given
        Printer printer = mock(Printer.class);
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        Account account = new Account(transactionRepository, printer);
        List<Transaction> allTransactionList = Arrays.asList(new Transaction(LocalDateTime.now().toString(), 1000));
        Mockito.when(transactionRepository.allTransactions()).thenReturn(allTransactionList);
        Mockito.doNothing().when(printer).print(allTransactionList);

        //when
        account.printStatement();

        //then
        Mockito.verify(printer).print(allTransactionList);
    }
}