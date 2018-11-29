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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
     * 以数组形式一次性返回数据
     */
    @GetMapping("/list")
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    /**
     * 以SSE形式多次返回
     */
    @GetMapping(value = "/stream/list", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getStreamUser() {
        return userRepository.findAll();
    }

    /**
     * 新增
     */
    @PostMapping("/create")
    public Mono<User> createUser(@RequestBody User user) {
        //在spring data jpa中，新增和修改都是save 有id就是修改，没有id就是新增
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable("id") String id) {
        //删除操作，deleteById()是没有返回值的，就不能判断数据是否存在
        //userRepository.deleteById(id);

        /**
         * 首先根据id查找，flatMap对数据进行删除操作，删除了就返回200，
         * 如果根据id没有找到，即defaultIfEmpty，就返回404
         *
         * （当要操作数据，并且返回一个Mono时，用flatMap
         * 如果不操作数据，只是转换数据，就使用map)
         */
        return userRepository.findById(id).flatMap(user ->
                userRepository.delete(user).then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK))))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * 修改
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> updateUser(@PathVariable("id") String id,
                                                 @RequestBody User user) {

        return userRepository.findById(id).flatMap(u -> {
            u.setAge(18);
            u.setName("gull");
            return userRepository.save(u);
        }).map(user1 -> new ResponseEntity<User>(user1, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<User>(HttpStatus.NOT_FOUND));
        //flatMap操作数据   map转换数据
    }


    /**
     * 根据id查找
     */
    @GetMapping("/getById/{id}")
    public Mono<ResponseEntity<User>> findById(@PathVariable("id") String id) {

        return userRepository.findById(id).map(user -> new ResponseEntity<User>(user, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}