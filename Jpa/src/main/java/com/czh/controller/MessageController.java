package com.czh.controller;

import com.czh.entity.Message;
import com.czh.service.MessageService;
import com.czh.vo.MessageVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
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
        Long credat = messageVo.getCredat().getTime();
        if (messageVo == null
                || StringUtils.isBlank(messageVo.getPassword())
                || StringUtils.isBlank(messageVo.getMessage())) throw new Exception("参数错误" + messageVo);
        message = new Message(messageVo.getPassword(), messageVo.getMessage(), messageVo.getCredat());
        Jedis jedis = new Jedis("localhost");
        if (jedis.exists(credat.toString())) throw new Exception("请勿重复提交");
        jedis.set(credat.toString(), credat.toString());
        jedis.expire(credat.toString(), 60);// 设置key过期时间60秒
        return messageService.save(message);
    }

    @GetMapping("/getMsg")
    public List<Message> getMsg(@RequestBody Message message) throws Exception {
        if (message == null || StringUtils.isBlank(message.getPassword()))
            throw new Exception("参数错误" + message);
        return messageService.findByPassword(message.getPassword());
    }
    /**
     * 测试排序
     */
    @RequestMapping("/sort")
    public List<Message> sort() {
        List<Message> messagesSort =new ArrayList<>();
        return messagesSort;
    }
}
