package ru.vood.synchronizedExample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountSynch {
    private int id;
    private long balance;

    private Lock lock = new ReentrantLock();
}
