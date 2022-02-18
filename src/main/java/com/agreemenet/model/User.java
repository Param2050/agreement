package com.agreemenet.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public class User extends BaseCollection{

    @Id
    private String userId;
    private String username;
    @Indexed
    private String mobile;
    private String emailId;

    public User() {
    }

    public User(String userId, String username, String mobile, String emailId) {
        this.userId = userId;
        this.username = username;
        this.mobile = mobile;
        this.emailId = emailId;
    }
}
