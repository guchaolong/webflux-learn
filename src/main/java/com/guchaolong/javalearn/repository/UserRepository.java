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
package com.guchaolong.javalearn.repository;

import com.guchaolong.javalearn.entity.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/11/29 1:57
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {

    Flux<User> findByAgeBetween(int start, int end);

    //年龄在30-60之间的
    @Query("{'age':{'$gte':30,'$lte':60}}")
    Flux<User> findByAge30a60();
}
