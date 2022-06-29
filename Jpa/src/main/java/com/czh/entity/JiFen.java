package com.czh.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ji_fen")
@Data
public class JiFen {
    @Id
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private String sub;
    @Transient
    private JiFen nextJiFen;

    public JiFen(Long id, String name, String sub, JiFen nextJiFen) {
        this.id = id;
        this.name = name;
        this.sub = sub;
        this.nextJiFen = nextJiFen;
    }

    public JiFen() {
    }

    public JiFen(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
