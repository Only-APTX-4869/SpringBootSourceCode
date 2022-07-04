-- ----------------------------
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
create database mysql;
use mysql;
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
-- Table structure for ji_fen
-- ----------------------------
DROP TABLE IF EXISTS `ji_fen`;
CREATE TABLE `ji_fen`  (
                           `name` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
                           `id` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
                           `sub` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ji_fen
-- ----------------------------
INSERT INTO `ji_fen` VALUES ('牛刀小试', '1', '2');
INSERT INTO `ji_fen` VALUES ('牛运当头', '2', '3');
INSERT INTO `ji_fen` VALUES ('牛劲十足', '3', '4');
INSERT INTO `ji_fen` VALUES ('牛运享通', '4', '5');
INSERT INTO `ji_fen` VALUES ('牛气冲天', '5', '6');
INSERT INTO `ji_fen` VALUES ('牛转乾坤', '6', '');

SET FOREIGN_KEY_CHECKS = 1;

