package ru.vood.synchronizedExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class MainLock {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().setName("Vood Main;");
        Thread.sleep(10000);

        ExecutorService executorService = Executors.newCachedThreadPool();
        AccountSynch account = new AccountSynch(1, 100, new ReentrantLock());
        AccountSynch account2 = new AccountSynch(2, 200, new ReentrantLock());

        Pay pay = new Pay(account, account2, 50);
        Pay pay2 = new Pay(account2, account, 20);

        executorService.submit(pay);
        executorService.submit(pay2);
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        System.out.println("acc1->" + account.getBalance() + "  acc1->" + account2.getBalance());

    }
}
