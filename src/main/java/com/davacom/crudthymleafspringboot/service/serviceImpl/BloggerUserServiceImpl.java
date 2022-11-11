package com.davacom.crudthymleafspringboot.service.serviceImpl;

import com.davacom.crudthymleafspringboot.dto.BlogerDto;
import com.davacom.crudthymleafspringboot.exception.UserNotFoundException;
import com.davacom.crudthymleafspringboot.models.BlogUser;
import com.davacom.crudthymleafspringboot.repositories.BloggerRepository;
import com.davacom.crudthymleafspringboot.service.BloggerUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BloggerUserServiceImpl implements BloggerUserService {
    private final BloggerRepository bloggerRepository;

    @Override
    public BlogUser create(BlogerDto userDto) {
        BlogUser user = new BlogUser();
        BeanUtils.copyProperties(userDto,user);
        return bloggerRepository.save(user);
    }

    @Override
    public BlogUser login(String email, String password) {
        BlogUser user = bloggerRepository.findByEmailAndPassword(email, password);
        if(user == null) {
            throw new UserNotFoundException("User with the  credentials not found!");
        } else {
            return user;
        }
    }

}
