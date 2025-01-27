package com.url_shortener.service.impl;

import com.url_shortener.repository.UrlRepository;
import com.url_shortener.repository.entity.UrlDao;
import com.url_shortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;


    @Override
    public boolean create(UrlDao urlDao) {
        if (findById(urlDao.getId()).orElse(null) != null) {
            return false;
        }
        urlRepository.save(urlDao);
        return true;
    }

    @Override
    public Optional<UrlDao> findById(Long id) {
        return urlRepository.findById(id);
    }

    @Override
    public boolean deleteById(Long id) {
        if (findById(id).orElse(null) == null) {
            return false;
        }
        urlRepository.deleteById(id);
        return true;
    }
}
