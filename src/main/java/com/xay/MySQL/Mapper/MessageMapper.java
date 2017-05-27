package com.xay.MySQL.Mapper;

import com.xay.MySQL.DO.MessageDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/5/26.
 */
@Mapper
public interface MessageMapper {
    /**
     * 新建信息
     * @param messageDO
     * @return
     */
    @Insert("INSERT INTO messages(from_username, to_username, message_content) " +
            "VALUES(#{from_username}, #{to_username}, #{message_content})")
    int postMessage(MessageDO messageDO);

    /**
     * 获取用户所有联系人
     * @param username
     * @return
     */
    @Select("SELECT DISTINCT to_username FROM messages WHERE from_username=#{username}")
    String[] getContactByFromUsername(@Param("username")String username);
    @Select("SELECT DISTINCT from_username FROM messages WHERE to_username=#{username}")
    String[] getContactByToUsername(@Param("username")String username);

    /**
     * 获取用户所有聊天记录
     * @param usernameFrom
     * @param usernameTo
     * @return
     */
    @Select("SELECT * FROM messages WHERE from_username=#{usernameFrom} AND to_username=#{usernameTo} OR from_username=#{usernameTo} AND to_username=#{usernameFrom}")
    MessageDO[] getMessage(@Param("usernameFrom")String usernameFrom, @Param("usernameTo")String usernameTo);
}
