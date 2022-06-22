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
}
