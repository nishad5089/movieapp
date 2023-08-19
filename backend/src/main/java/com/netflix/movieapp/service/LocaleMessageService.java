package com.netflix.movieapp.service;


import com.netflix.movieapp.constant.ResponseMessages;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocaleMessageService {

    private final HttpServletRequest request;
    private final MessageSource messageSource;

    public LocaleMessageService(HttpServletRequest request,
                                MessageSource messageSource) {
        this.request = request;
        this.messageSource = messageSource;
    }

    public Locale getLocale(){
        return request.getLocale();
    }

    public String getLocalMessage(ResponseMessages key) {
        return messageSource.getMessage(key.getMessage(), null, getLocale());
    }

}
