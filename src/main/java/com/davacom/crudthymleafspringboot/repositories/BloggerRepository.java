package com.davacom.crudthymleafspringboot.repositories;

import com.davacom.crudthymleafspringboot.models.BlogUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloggerRepository extends JpaRepository<BlogUser, Long> {
    BlogUser findByEmailAndPassword(String email, String password);
}
