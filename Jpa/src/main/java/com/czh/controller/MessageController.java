package com.czh.controller;

import com.czh.entity.Message;
import com.czh.service.MessageService;
import com.czh.vo.MessageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * 樱花岛留言板接口
 */
@RestController
@RequestMapping("/sakura")
public class MessageController extends Exception {
    final MessageService messageService;

    //构造器 注入
    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/addMsg")
    public Message save(@RequestBody MessageVo messageVo) throws Exception {
        Message message = new Message();
        String redisKey = messageVo.getMessage() + messageVo.getPassword().toString();
        if (messageVo == null
                || StringUtils.isBlank(messageVo.getPassword())
                || StringUtils.isBlank(messageVo.getMessage())) throw new Exception("参数错误" + messageVo);
        message = new Message(messageVo.getPassword(), messageVo.getMessage(), messageVo.getCredat());
        Jedis jedis = new Jedis("localhost");
        if (jedis.exists(redisKey)) throw new Exception("请勿重复提交");
        jedis.set(redisKey, redisKey);
        jedis.expire(redisKey, 60);// 设置key过期时间60秒
        return messageService.save(message);
    }

    @PostMapping("/getMsg")
    public List<Message> getMsg(@RequestBody Message message) throws Exception {
        if (message == null || StringUtils.isBlank(message.getPassword()))
            throw new Exception("参数错误" + message);
        return messageService.findByPassword(message.getPassword());
    }

}
