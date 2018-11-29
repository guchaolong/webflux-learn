/**
 * <p>
 * For more information about , welcome to http://www.guchaolong.com
 * <p>
 * project: java-learn
 * <p>
 * Revision History:
 * Date          Version       Name            Description
 * 2018/11/29 1.0          guchaolong          Creation File
 */
package com.guchaolong.javalearn.api;

import com.guchaolong.javalearn.entity.User;
import com.guchaolong.javalearn.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/11/29 1:42
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    /**
     * 以数组形式返回
     */
    @GetMapping("/list")
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * 像流一样返回
     */
    @GetMapping(value = "/stream/list",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getStreamUser(){
        return userRepository.findAll();
    }
}