package com.davacom.crudthymleafspringboot.service;

import com.davacom.crudthymleafspringboot.dto.BlogerDto;
import com.davacom.crudthymleafspringboot.exception.UserNotFoundException;
import com.davacom.crudthymleafspringboot.models.BlogUser;
import com.davacom.crudthymleafspringboot.repositories.BloggerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

public interface BloggerUserService {

    BlogUser create(BlogerDto userDto);
    BlogUser login(String email, String password);

}
