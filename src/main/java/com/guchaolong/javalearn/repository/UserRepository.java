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
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/11/29 1:57
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User,String> {
}
