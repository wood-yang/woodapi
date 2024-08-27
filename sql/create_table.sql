# 数据库初始化
-- 创建库
create database if not exists woodapi;

-- 切换库
use woodapi;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userAccount  varchar(256)                           not null comment '账号',
    userPassword varchar(512)                           not null comment '密码',
    unionId      varchar(256)                           null comment '微信开放平台id',
    mpOpenId     varchar(256)                           null comment '公众号openId',
    userName     varchar(256)                           null comment '用户昵称',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userProfile  varchar(512)                           null comment '用户简介',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user/admin/ban',
    `accessKey`  varchar(512)                           NULL DEFAULT '' COMMENT 'accessKey',
    `secretKey`  varchar(512)                           NULL DEFAULT '' COMMENT 'secretKey',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    index idx_unionId (unionId)
) comment '用户' collate = utf8mb4_unicode_ci;

CREATE TABLE interfaceInfo
(
    `id`             bigint PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `name`           varchar(256)       NOT NULL DEFAULT '' COMMENT '接口名称',
    `description`    varchar(512)       NULL     DEFAULT '' COMMENT '接口描述',
    `url`            varchar(512)       NOT NULL DEFAULT '' COMMENT '接口地址',
    `method`         varchar(256)       NOT NULL DEFAULT '' COMMENT '接口类型',
    `status`         tinyint            NOT NULL DEFAULT 0 COMMENT '状态(0 - 关闭 1 - 打开)',
    `requestHeader`  text               NULL COMMENT '请求头',
    `responseHeader` text               NULL COMMENT '响应头',
    `userId`         bigint             NOT NULL COMMENT '创建人 id',
    `createTime`     datetime           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`     datetime           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `isDeleted`      tinyint            NOT NULL DEFAULT 0 COMMENT '是否删除',
    KEY `id_index` (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ="接口信息";

CREATE TABLE user_interfaceInfo
(
    `id`              bigint PRIMARY KEY NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `userId`          bigint             NOT NULL COMMENT '调用用户 id',
    `interfaceInfoId` bigint             NOT NULL COMMENT '调用接口 id',
    `totalNum`        int                         default 0 NOT NULL COMMENT '总调用次数',
    `leftNum`         int                         default 0 NOT NULL COMMENT '剩余调用次数',
    `status`          int                         default 0 NOT NULL COMMENT '是否允许调用(0 - 允许 1 - 不允许)',
    `createTime`      datetime           NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `updateTime`      datetime           NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
    `isDeleted`       tinyint            NOT NULL DEFAULT 0 COMMENT '是否删除',
    KEY `id_index` (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci COMMENT ="用户调用接口信息"