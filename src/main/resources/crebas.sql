/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/4 21:23:15                            */
/*==============================================================*/


drop table if exists file;

drop table if exists recycle;

drop table if exists user;

drop table if exists user_img;

/*==============================================================*/
/* Table: file                                                  */
/*==============================================================*/
create table file
(
   fid                  bigint not null,
   parent               bigint,
   name                 varchar(255),
   size                 bigint,
   c_ctime              bigint,
   c_mtime              bigint,
   s_ctime              bigint,
   s_mtime              bigint,
   creator              bigint,
   reserved_1           bigint,
   reserved_2           bigint,
   reserved_3           varchar(255),
   reserved_4           varchar(255),
   primary key (fid)
);

/*==============================================================*/
/* Table: recycle                                               */
/*==============================================================*/
create table recycle
(
   fid                  bigint not null,
   parent               bigint,
   name                 varchar(255),
   size                 bigint,
   c_ctime              bigint,
   c_mtime              bigint,
   s_ctime              bigint,
   s_mtime              bigint,
   creator              bigint,
   deleted_time         bigint,
   reserved_2           bigint,
   reserved_3           varchar(255),
   reserved_4           varchar(255),
   primary key (fid)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   uid                  bigint not null,
   aid                  varchar(255),
   name                 varchar(255),
   nickName             varchar(255),
   email                varchar(255),
   phone                varchar(255),
   psw                  varchar(255),
   ctime                bigint,
   mtime                bigint,
   reserved_1           int,
   reserved_2           bigint,
   reserved_3           bigint,
   reserved_4           varchar(255),
   reserved_5           varchar(255),
   primary key (uid)
);

/*==============================================================*/
/* Table: user_img                                              */
/*==============================================================*/
create table user_img
(
   uid                  bigint not null,
   img                  mediumblob,
   ctime                bigint,
   mtime                bigint,
   primary key (uid)
);

