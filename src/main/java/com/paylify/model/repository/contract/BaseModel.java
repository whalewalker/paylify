package com.paylify.model.repository.contract;

import java.time.LocalDateTime;

public interface  BaseModel {
    long getId();
    void setId(long id);
    LocalDateTime getCreatedAt();
    void setCreatedAt(LocalDateTime createdAt);
    LocalDateTime getUpdatedAt();
    void setUpdatedAt(LocalDateTime updatedAt);
}
