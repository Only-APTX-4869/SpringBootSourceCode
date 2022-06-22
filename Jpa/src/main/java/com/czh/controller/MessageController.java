package com.czh.controller;

import com.czh.entity.Message;
import com.czh.service.MessageService;
import com.czh.vo.MessageVo;
import com.czh.vo.QueryMessagesVO;
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
public class MessageController {

    final MessageService messageService;

    //构造器 注入
    MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/addMsg")
    public Message save(@RequestBody MessageVo messageVo) throws Exception {
        Message m = new Message();
        if (messageVo != null
                || StringUtils.isNotBlank(messageVo.getPassword())
                || StringUtils.isNotBlank(messageVo.getMessage())) {
            m = new Message(messageVo.getPassword(), messageVo.getMessage(), messageVo.getCredat());
            Jedis jedis = new Jedis("localhost");
            if (jedis.exists(messageVo.credat.toString())) throw new Exception("请勿重复提交");
            jedis.set(messageVo.credat.toString(), messageVo.credat.toString());
            return messageService.save(m);
        } else {
            return m;
        }
    }

    @GetMapping("/getMsg")
    public List<Message> getMsg(@RequestBody Message message) {
        if (message != null || StringUtils.isNotBlank(message.getPassword())) {
            return messageService.findByPassword(message.getPassword());
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("/getMsgMore")
    public QueryMessagesVO getMsgMore(@RequestBody Message message) throws Exception{
        QueryMessagesVO vo = new QueryMessagesVO();
        if (message == null || StringUtils.isNotBlank(message.getPassword()))
            throw new Exception("参数错误"+vo) ;
        List<Message> lt = messageService.findByPassword(message.getPassword());
        vo.setMessages(lt);
        for (int i = 0; i < lt.size(); i++)
            vo.addItem(new QueryMessagesVO.Item(String.valueOf(i),
                    "huahua_a", 99.9));
        return vo;
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
