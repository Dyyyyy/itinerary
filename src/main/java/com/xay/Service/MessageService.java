package com.xay.Service;

import com.xay.Domain.BaseResult;
import com.xay.Domain.MessageDomain;

/**
 * Created by Administrator on 2017/5/26.
 */
public interface MessageService {
    /**
     * 新建信息
     * @param messageDomain
     * @return
     */
    BaseResult<Object> postMessage(MessageDomain messageDomain);

    /**
     * 根据用户名获取所有信息
     * @param username
     * @return
     */
    BaseResult<Object> getContactByUsername(String username);

    /**
     * 根据用户名获取聊天记录
     * @param usernameFrom
     * @param usernameTo
     * @return
     */
    BaseResult<Object> getMessage(String usernameFrom, String usernameTo);
}
