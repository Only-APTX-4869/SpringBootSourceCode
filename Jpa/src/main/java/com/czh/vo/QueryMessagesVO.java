package com.czh.vo;

import com.czh.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class QueryMessagesVO {

    /**
     * 信息实体节点
     */
    private List<Message> messages;

    /**
     * Item节点
     */
    private final List<Item> items = new ArrayList();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Item {
        private String id;
        private String name;
        private Double price;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addItems(Collection<Item> items) {
        items.forEach(this::addItem);
    }


}
