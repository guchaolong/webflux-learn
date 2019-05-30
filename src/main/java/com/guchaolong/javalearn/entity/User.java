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
package com.guchaolong.javalearn.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Description:
 *
 * @author guchaolong
 * @date 2018/11/29 1:49
 */

@Document(collection = "user")//对应mongondb里的user表
@Data//自动写好setter getter toString
public class User {
    @Id
    private String id;
    private String name;
    private Integer age;
}