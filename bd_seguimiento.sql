/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : bd_seguimiento

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 11/06/2024 21:44:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for estudiantes
-- ----------------------------
DROP TABLE IF EXISTS `estudiantes`;
CREATE TABLE `estudiantes`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `apellidos` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fechaNacimiento` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of estudiantes
-- ----------------------------
INSERT INTO `estudiantes` VALUES (1, 'Hugo', 'Gonzales quispe', 'Hugo@hotmail.com', '2026-09-22');
INSERT INTO `estudiantes` VALUES (2, 'Daniela', 'Lucana Ticona', 'Dania@gmail.com', '2003-02-25');
INSERT INTO `estudiantes` VALUES (3, 'Gus Gus', 'Mamani Mamani', 'Gus@gmail.com', '2006-11-23');
INSERT INTO `estudiantes` VALUES (12, 'atlas', 'smith', 'ia@ggg.com', '2024-06-07');
INSERT INTO `estudiantes` VALUES (13, 'husman', 'condori', 'condori@gmail.com', '2024-06-06');

SET FOREIGN_KEY_CHECKS = 1;
