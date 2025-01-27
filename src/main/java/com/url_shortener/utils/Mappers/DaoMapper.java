package com.url_shortener.utils.Mappers;

import com.url_shortener.controller.request.UrlDto;
import com.url_shortener.controller.request.UserDto;
import com.url_shortener.exception.AuthentificationException;
import com.url_shortener.exception.ConverterException;
import com.url_shortener.repository.entity.UrlDao;
import com.url_shortener.repository.entity.UserDao;
import com.url_shortener.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DaoMapper {
    final IdUrlMapper IdUrlMapper;

    public UrlDao map(UrlDto urlDto, UserService userService) throws ConverterException {
        return new UrlDao(
                IdUrlMapper.getId(urlDto.shortUrl())    ,
                urlDto.url(),
                userService.findById(0L).get()
        );
    }

    public UserDao map(UserDto userDto, UserService userService) throws AuthentificationException {
        return userService.Authentificate(userDto);
    }

}
