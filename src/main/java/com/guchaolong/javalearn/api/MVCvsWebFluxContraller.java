/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2019/7/31 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@RestController
public class MVCvsWebFluxContraller {

    @GetMapping("/hello1/{latency}")
    public String hello(@PathVariable(value = "latency") long latency) {
        try {
            TimeUnit.MILLISECONDS.sleep(latency);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

    @GetMapping("/hello2/{latency}")
    public Mono<String> hello2(@PathVariable(value = "latency") long latency) {
        return Mono.just("hello2").delayElement(Duration.ofMillis(latency));
    }

}