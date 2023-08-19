package com.netflix.movieapp.controller;

import com.netflix.movieapp.common.enums.ResponseMessages;
import com.netflix.movieapp.service.LocaleMessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Abdur Rahim Nishad
 * @since 1.0.0
 */
public class BaseController {

    @Autowired
    private LocaleMessageService messageService;

    public String getMessage(ResponseMessages key) {
        return messageService.getLocalMessage(key);
    }
}
