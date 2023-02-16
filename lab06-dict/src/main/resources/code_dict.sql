/*
 Navicat Premium Data Transfer

 Source Server         : 10.10.3.14
 Source Server Type    : MySQL
 Source Server Version : 50740 (5.7.40)
 Source Host           : 10.10.3.14:30713
 Source Schema         : purchase-dev

 Target Server Type    : MySQL
 Target Server Version : 50740 (5.7.40)
 File Encoding         : 65001

 Date: 16/02/2023 11:01:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for code_dict
-- ----------------------------
DROP TABLE IF EXISTS `code_dict`;
CREATE TABLE `code_dict`  (
  `pk_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dict_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'code',
  `dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '名称',
  `dict_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'value',
  `dict_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典分类',
  `level` int(3) NOT NULL COMMENT '层级',
  `sort` int(11) NOT NULL DEFAULT 1 COMMENT '排序',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `fk_user_create` bigint(20) NULL DEFAULT 0 COMMENT '创建人',
  `gmt_create` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `fk_user_modified` bigint(20) NULL DEFAULT 0 COMMENT '修改人',
  `gmt_modified` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否启用',
  PRIMARY KEY (`pk_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of code_dict
-- ----------------------------
INSERT INTO `code_dict` VALUES (1, '', '性别', '1', 'sex', 1, 1, NULL, 0, '2023-02-16 09:19:01', 0, '2023-02-16 09:19:16', 1);
INSERT INTO `code_dict` VALUES (2, 'MALE', '男', '1', 'sex', 2, 1, NULL, 0, '2023-02-16 09:20:15', 0, '2023-02-16 09:45:34', 1);
INSERT INTO `code_dict` VALUES (3, 'FEMALE', '女', '2', 'sex', 2, 1, NULL, 0, '2023-02-16 09:20:53', 0, '2023-02-16 09:45:40', 1);

SET FOREIGN_KEY_CHECKS = 1;
