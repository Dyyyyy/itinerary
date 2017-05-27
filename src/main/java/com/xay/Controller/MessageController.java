package com.xay.Controller;

import com.xay.Domain.BaseResult;
import com.xay.Domain.MessageDomain;
import com.xay.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/5/26.
 */
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping(value = "messages", method = RequestMethod.POST)
    public BaseResult<Object> postJourney(@RequestBody MessageDomain messageDomain){
        return messageService.postMessage(messageDomain);
    }

    @RequestMapping(value = "messages", method = RequestMethod.GET)
    public BaseResult<Object> getContactByUsername(@RequestParam("username") String username){
        return messageService.getContactByUsername(username);
    }

    @RequestMapping(value = "messages/bilateral", method = RequestMethod.GET)
    public BaseResult<Object> getMessage(@RequestParam("usernameFrom") String usernameFrom, @RequestParam("usernameTo") String usernameTo){
        return messageService.getMessage(usernameFrom, usernameTo);
    }
}
