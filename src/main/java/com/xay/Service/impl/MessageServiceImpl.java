package com.xay.Service.impl;

import com.xay.Domain.BaseResult;
import com.xay.Domain.MessageDomain;
import com.xay.MySQL.DO.AccountDO;
import com.xay.MySQL.DO.MessageDO;
import com.xay.MySQL.Mapper.MessageMapper;
import com.xay.MySQL.Mapper.AccountMapper;
import com.xay.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/26.
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;
    @Autowired
    private AccountMapper accountMapper;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public BaseResult<Object> postMessage(MessageDomain messageDomain) {
//        AccountDO accountDO = accountMapper.getCustomerByUsername(messageDomain.getTo());
//        if (accountDO != null){
//            messageMapper.postMessage(new MessageDO(messageDomain));
//            return new BaseResult<>();
//        }
//        return new BaseResult<>(500, "No user found");

        messageMapper.postMessage(new MessageDO(messageDomain));
        return new BaseResult<>();
    }

    @Override
    public BaseResult<Object> getContactByUsername(String username){
        String[] messageDOS1 = messageMapper.getContactByFromUsername(username);
        String[] messageDOS2 = messageMapper.getContactByToUsername(username);
        String[] messageDOS = new String[messageDOS1.length + messageDOS2.length];

        System.arraycopy(messageDOS1, 0, messageDOS, 0, messageDOS1.length);
        System.arraycopy(messageDOS2, 0, messageDOS, messageDOS1.length, messageDOS2.length);

        Set<String> set = new HashSet<>();
        Collections.addAll(set, messageDOS);
        return new BaseResult<>(set);
    }

    @Override
    public BaseResult<Object> getMessage(String usernameFrom, String usernameTo){
        MessageDO[] messageDOS = messageMapper.getMessage(usernameFrom, usernameTo);
        MessageDomain[] messageDomains = new MessageDomain[messageDOS.length];
        if (messageDomains.length == 0){
            return new BaseResult<>(500, "No message found");
        }
        for (int i = 0; i < messageDOS.length; i++){
            messageDomains[i] = new MessageDomain(messageDOS[i], simpleDateFormat.format(messageDOS[i].getTime()));
        }
        return new BaseResult<>(messageDomains);
    }
}
