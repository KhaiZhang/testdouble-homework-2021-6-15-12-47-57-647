package com.tw.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
}