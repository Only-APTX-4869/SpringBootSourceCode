-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
                         `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
                         `name` varchar(2550) COMMENT '姓名',
                         `age` int  COMMENT '年纪',
                         `address` varchar(2550) COMMENT '地址',
                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `idx_id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;
-- ----------------------------
# hibernate_sequence.nextval
insert into person(id,name,age,address) values(1,'汪云飞',32,'合肥');
insert into person(id,name,age,address) values(2,'xx',31,'北京');
insert into person(id,name,age,address) values(3,'yy',30,'上海');
insert into person(id,name,age,address) values(4,'zz',29,'南京');
insert into person(id,name,age,address) values(5,'aa',28,'武汉');
insert into person(id,name,age,address) values(6,'bb',27,'合肥');

-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
                          `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '留言钥匙',
                          `message` varchar(2550) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '留言内容',
                          `id` int NOT NULL AUTO_INCREMENT COMMENT '唯一id',
                          `credat` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
                          PRIMARY KEY (`id`) USING BTREE,
                          INDEX `idx_id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------

