drop table if exists address;

drop table if exists brand_info;

drop table if exists computer;

drop table if exists favorite;

drop table if exists good_base_info;

drop table if exists good_grand_info;

drop table if exists goods_type;

drop table if exists mobile_phone;

drop table if exists order_detail;

drop table if exists order_goods;

drop table if exists shopping_cart;

drop table if exists user;

/*==============================================================*/
/* Table: address                                               */
/*==============================================================*/
create table address
(
   address_id           varchar(50),
   address_name         varchar(50),
   address_phone        varchar(50),
   address_prov         varchar(50),
   address_city         varchar(50),
   address_area         varchar(50),
   address_street       varchar(50),
   address_info         varchar(50),
   user_id              varchar(50)
);

alter table address comment '用来管理用户地址的';

/*==============================================================*/
/* Table: brand_info                                            */
/*==============================================================*/
create table brand_info
(
   ID                   int not null,
   brand_id             varchar(50),
   brand_name           varchar(50),
   brand_des            text,
   img                  text,
   primary key (ID)
);

alter table brand_info comment '品牌信息表：苹果，小米，华为，三星，诺基亚这些';

/*==============================================================*/
/* Table: computer                                              */
/*==============================================================*/
create table computer
(
   good_id              varchar(50),
   computer_id          varchar(50),
   computer_name        varchar(50),
   computer_version     varchar(50),
   computer_colour      varchar(50),
   price                varchar(50),
   computer_img_url     varchar(50),
   computer_CPU         varchar(50),
   computer_GPU         varchar(50),
   computer_ROM         varchar(50),
   computer_RAM         varchar(50),
   computer_screen_size varchar(50),
   computer_screen_resolution varchar(50),
   computer_screen_refresh varchar(50),
   material             varchar(50),
   system               varchar(50),
   weight               varchar(50),
   brand_id             varchar(50),
   good_desc            varchar(1000)
);

alter table computer comment '电脑的详细信息';

/*==============================================================*/
/* Table: favorite                                              */
/*==============================================================*/
create table favorite
(
   favorite_id          varchar(50),
   user_id              varchar(50),
   good_id              varchar(50),
   time                 varchar(50)
);

alter table favorite comment '收藏夹，保存用户收藏的商品';

/*==============================================================*/
/* Table: good_base_info                                        */
/*==============================================================*/
create table good_base_info
(
   ID                   char(10),
   good_id              varchar(50),
   good_name            varchar(50),
   good_type_id         varchar(50),
   brand_id             varchar(50),
   good_price           varchar(50),
   screen_size          varchar(50),
   good_desc            varchar(50),
   seller_id            varchar(50),
   stock                int,
   sold                 int,
   up_time              varchar(50),
   detail_table         varchar(50)
);

alter table good_base_info comment '记录商品的基本信息';

/*==============================================================*/
/* Table: good_grand_info                                       */
/*==============================================================*/
create table good_grand_info
(
   ID                   int not null,
   good_type_id         varchar(50),
   brand_id             varchar(50),
   primary key (ID)
);

alter table good_grand_info comment '该表记录商品对应的品牌数据';

/*==============================================================*/
/* Table: goods_type                                            */
/*==============================================================*/
create table goods_type
(
   ID                   int not null,
   good_type_id         varchar(50),
   good_type_name       varchar(50),
   primary key (ID)
);

alter table goods_type comment '商品一级分类表：电脑、手机这些';

/*==============================================================*/
/* Table: mobile_phone                                          */
/*==============================================================*/
create table mobile_phone
(
   good_id              varchar(50),
   computer_id          varchar(50),
   computer_name        varchar(50),
   computer_version     varchar(50),
   computer_colour      varchar(50),
   price                varchar(50),
   computer_img_url     varchar(50),
   computer_CPU         varchar(50),
   computer_GPU         varchar(50),
   computer_ROM         varchar(50),
   computer_RAM         varchar(50),
   computer_screen_size varchar(50),
   computer_screen_resolution varchar(50),
   computer_screen_refresh varchar(50),
   material             varchar(50),
   system               varchar(50),
   weight               varchar(50),
   brand_id             varchar(50),
   good_desc            varchar(50)
);

alter table mobile_phone comment '手机的详细信息';

/*==============================================================*/
/* Table: order_detail                                          */
/*==============================================================*/
create table order_detail
(
   detail_id            varchar(50),
   good_id              varchar(50),
   number               varchar(50),
   order_id             varchar(50)
);

alter table order_detail comment '记录每个订单的详细信息';

/*==============================================================*/
/* Table: order_goods                                           */
/*==============================================================*/
create table order_goods
(
   order_id             varchar(50),
   begin_time           varchar(50),
   end_time             varchar(50),
   state                varchar(50),
   用户id                 varchar(50),
   address_id           varchar(50)
);

alter table order_goods comment '商品订单';

/*==============================================================*/
/* Table: shopping_cart                                         */
/*==============================================================*/
create table shopping_cart
(
   cart_id              varchar(50),
   user_id              varchar(50),
   number               varchar(50),
   good_id              varchar(50)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   user_id              varchar(50),
   user_name            varchar(50),
   password             varchar(50),
   age                  varchar(50),
   sex                  varchar(50),
   profession           varchar(50),
   regtime              varchar(50),
   power                varchar(50)
);
