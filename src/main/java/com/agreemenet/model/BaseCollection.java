package com.agreemenet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseCollection {

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;
    @Version
    private Long version;

    @Override
    public String toString() {
        return "{\"_class\":\"BaseCollection\", " +
                "\"createdAt\":" + (createdAt == null ? "null" : createdAt) + ", " +
                "\"lastModifiedAt\":" + (lastModifiedAt == null ? "null" : lastModifiedAt) + ", " +
                "\"createdBy\":" + (createdBy == null ? "null" : "\"" + createdBy + "\"") + ", " +
                "\"lastModifiedBy\":" + (lastModifiedBy == null ? "null" : "\"" + lastModifiedBy + "\"") + ", " +
                "\"version\":" + (version == null ? "null" : "\"" + version + "\"") +
                "}";
    }

}