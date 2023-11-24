package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        ReactiveSources.intNumbersFlux().subscribe(e -> System.out.println(e),
//                e -> System.out.println(e.getMessage()), () -> System.out.println("complete"));
//
//        ReactiveSources.userFlux().subscribe(e -> System.out.println(e),
//                e -> System.out.println(e.getMessage()),
//                () -> System.out.println("complete"));
        // Subscribe to a flux using an implementation of BaseSubscriber

        ReactiveSources.intNumbersFlux().subscribe(
                new MySubscriber<>()
        );
        System.out.println("Press a key to end");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("subscribe happend");
        request(2);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(2);
    }


}

