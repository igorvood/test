package ru.vood.SpringRestClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ru.vood.SpringRestClient.rest.Emploers;
import ru.vood.SpringRestClient.rest.RESTClientExample;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@SpringBootApplication
public class SpringRestExampleApplication implements Callable<Emploers> {
    private static ApplicationContext context;

    public static void main(String[] args) throws Exception {
        context = SpringApplication.run(SpringRestExampleApplication.class, args);


        final long time = new Date().getTime();
        List<Future<Emploers>> futureList = new ArrayList<>();

        final ForkJoinPool forkJoinPool = new ForkJoinPool();

        for (int i = 0; i < 1050000; i++) {
            //FutureTask<User> futureTask = new FutureTask(application.gitHubLookupService);
            FutureTask<Emploers> futureTask = new FutureTask(new SpringRestExampleApplication());
            futureList.add(futureTask);

            forkJoinPool.submit(futureTask);
            //new Thread(futureTask).start();
            System.out.println(i);
        }
        int i = 0;
        while (true) {
            final Optional<Future<Emploers>> first = futureList.stream().filter(userFuture -> userFuture.isDone() == false).findFirst();

            if (first.isPresent() == false) {
                break;
            }
            if (i % 10000000 == 0) {
                final long count = futureList.stream()
                        .filter(userFuture -> userFuture.isDone() == false)
                        .count();
                System.out.println(("осталось отработать " + count));
                i = 0;
/*
                final Optional<Future<Emploers>> first1 = futureList.stream()
                        .filter(userFuture -> userFuture.isDone() == true)
                        .findFirst();
                System.out.println("result=>"+first1.get().get().toString());
*/

            }
            //System.out.println(("осталось отраотать " + i));
            i++;
        }

        final long time1 = new Date().getTime();


        System.out.println("getStealCount = " + forkJoinPool.getStealCount() + " time =" + (time1 - time));
    }

    @Bean
    public RestTemplate geRestTemplate() {
        return new RestTemplate();
    }

    @Override
    public Emploers call() throws Exception {
/*
        Random random = new Random();
        Thread.sleep(random.nextInt(1000));
*/
        final RESTClientExample restClient = (RESTClientExample) context.getBean("restClient");

        final Emploers allEmployeesO = restClient.getAllEmployeesO();
        System.out.println(Thread.currentThread().getName() + " " + allEmployeesO);
        return allEmployeesO;
    }

}
