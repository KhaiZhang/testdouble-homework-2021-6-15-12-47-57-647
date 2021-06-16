package com.tw.banking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class PrinterTest {

    @Test
    void should_print_all_transaction_when_printer_print() {
        //given
        Console console = mock(Console.class);
        Printer printer = new Printer(console);
        List<Transaction> allTransactionList = Arrays.asList(new Transaction("16/06/2021", 1000),
                new Transaction("16/06/2021", 2000));
        Mockito.doNothing().when(console).printLine(anyString());

        //when
        printer.print(allTransactionList);

        //then
        Mockito.verify(console, times(3)).printLine(anyString());
    }
}