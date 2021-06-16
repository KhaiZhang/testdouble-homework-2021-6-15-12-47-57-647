package com.tw.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

class TransactionRepositoryTest {

    @Test
    void should_add_amount_when_transaction_add_deposit() {
        //given
        Clock mockClock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(mockClock);
        Mockito.when(mockClock.todayAsString()).thenReturn("06/16/2021");

        //when
        transactionRepository.addDeposit(100);

        //then
        Assertions.assertEquals("06/16/2021", transactionRepository.allTransactions().get(0).date());
        Assertions.assertEquals(100, transactionRepository.allTransactions().get(0).amount());
    }

    @Test
    void should_decrease_amount_when_transaction_withdraw() {
        //given
        Clock mockClock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(mockClock);
        Mockito.when(mockClock.todayAsString()).thenReturn("06/16/2021");

        //when
        transactionRepository.addWithdraw(100);

        //then
        Assertions.assertEquals("06/16/2021", transactionRepository.allTransactions().get(0).date());
        Assertions.assertEquals(-100, transactionRepository.allTransactions().get(0).amount());
    }

    @Test
    void should_get_all_transaction_when_transaction_repository_get_all_transaction() {
        //given
        Clock mockClock = mock(Clock.class);
        TransactionRepository transactionRepository = new TransactionRepository(mockClock);
        Mockito.when(mockClock.todayAsString()).thenReturn("06/16/2021");

        //when
        transactionRepository.addDeposit(100);
        List<Transaction> actualTransactions = transactionRepository.allTransactions();

        //then
        Assertions.assertTrue(actualTransactions.size() == 1);
        Assertions.assertEquals("06/16/2021", transactionRepository.allTransactions().get(0).date());
        Assertions.assertEquals(100, transactionRepository.allTransactions().get(0).amount());
    }
}