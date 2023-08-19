package com.netflix.movieapp.service;

import com.netflix.movieapp.constant.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class BaseService {

    private LocaleMessageService messageService;

    @Autowired
    public void setMessageService(LocaleMessageService messageService) {
        this.messageService = messageService;
    }

    public String getMessage(ResponseMessages key) {
        return messageService.getLocalMessage(key);
    }
}
