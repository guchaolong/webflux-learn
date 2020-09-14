package com.guchaolong.javalearn.test;

import reactor.core.publisher.Flux;

import java.util.Arrays;

/**
 * Description:
 *
 * @author AA
 * @date 2020/9/14 8:07
 */
public class Test {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        integerFlux.subscribe(System.out::print);

        Flux<String> tFlux = Flux.fromIterable(Arrays.asList("hello", "world"));
        tFlux.subscribe(System.out::print);


    }
}
