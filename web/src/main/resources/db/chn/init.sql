CREATE TABLE chn_author
(
pk_author char(20)  not null,
name varchar2(100)  not null,
record varchar2(100)  not null,
address varchar2(100),
cantact varchar2(100),
url varchar2(100),
email varchar2(100),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_author PRIMARY KEY ( pk_author )
  );


comment on column chn_author.pk_author is '主键';
comment on column chn_author.name is '名称';
comment on column chn_author.record is '备案号';
comment on column chn_author.address is '地址';
comment on column chn_author.cantact is '联系方式';
comment on column chn_author.url is '官网地址';
comment on column chn_author.email is '邮箱';
comment on column chn_author.creator is '创建人';
comment on column chn_author.creationTime is '创建时间';
comment on column chn_author.modifier is '修改人';
comment on column chn_author.modifyTime is '修改时间';
comment on column chn_author.ts is '时间戳';
comment on column chn_author.dr is '删除标志';

--------------------------------------------------------------------

CREATE TABLE chn_china
(
pk_china char(20)  not null,
title varchar2(100)  not null,
code varchar2(100)  not null,
pk_author char(20),
kilneye varchar2(100),
times varchar2(100),
model varchar2(100),
num varchar2(100),
memo varchar2(100),
keyword varchar2(100),
syskeyword varchar2(100),
price number(18,8),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_china PRIMARY KEY ( pk_china )

);

comment on column chn_china.pk_china is '主键';
comment on column chn_china.title is '标题';
comment on column chn_china.code is '编号';
comment on column chn_china.pk_author is '作者';
comment on column chn_china.kilneye is '窑口';
comment on column chn_china.times is '年代';
comment on column chn_china.model is '造型';
comment on column chn_china.num is '数量';
comment on column chn_china.memo is '简介';
comment on column chn_china.keyword is '关键词';
comment on column chn_china.syskeyword is '系统关键词';
comment on column chn_china.price is '单价';
comment on column chn_china.creator is '创建人';
comment on column chn_china.creationTime is '创建时间';
comment on column chn_china.modifier is '修改人';
comment on column chn_china.modifyTime is '修改时间';
comment on column chn_china.ts is '时间戳';
comment on column chn_china.dr is '删除标志';

-------------------------------------------------------

CREATE TABLE chn_know
(
pk_know char(20)  not null,
title varchar2(100)  not null,
code varchar2(100),
pk_author char(20),
kilneye varchar2(100),
times varchar2(100),
model varchar2(100),
journalnum varchar2(100),
memo varchar2(100),
keyword varchar2(100),
syskeyword varchar2(100),
price number(18,8),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_know PRIMARY KEY ( pk_know )

);
comment on column chn_know.pk_know is '主键';
comment on column chn_know.title is '标题';
comment on column chn_know.code is '编号';
comment on column chn_know.pk_author is '作者';
comment on column chn_know.kilneye is '窑口';
comment on column chn_know.times is '年代';
comment on column chn_know.model is '造型';
comment on column chn_know.journalnum is '期刊号';
comment on column chn_know.memo is '简介';
comment on column chn_know.keyword is '关键词';
comment on column chn_know.syskeyword is '系统关键词';
comment on column chn_know.price is '单价';
comment on column chn_know.creator is '创建人';
comment on column chn_know.creationTime is '创建时间';
comment on column chn_know.modifier is '修改人';
comment on column chn_know.modifyTime is '修改时间';
comment on column chn_know.ts is '时间戳';
comment on column chn_know.dr is '删除标志';

----------------------------------------------------
CREATE TABLE chn_resource
(
pk_resource char(20)  not null,
permtype varchar2(100)  not null,
secourcetype varchar2(100)  not null,
title char(20)  not null,
content varchar2(100)  not null,
price number(18,8),
orderno smallint,
billtype varchar2(100),
pk_china char(20),
pk_know char(20),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_resource PRIMARY KEY ( pk_resource )

);
comment on column chn_resource.pk_resource is '主键';
comment on column chn_resource.permtype is '权限类型';
comment on column chn_resource.secourcetype is '资源类型';
comment on column chn_resource.title is '标题';
comment on column chn_resource.content is '内容';
comment on column chn_resource.price is '单价';
comment on column chn_resource.orderno is '排序号';
comment on column chn_resource.billtype is '数量';
comment on column chn_resource.pk_china is '所属陶瓷';
comment on column chn_resource.pk_know is '所属知识';
comment on column chn_resource.creator is '创建人';
comment on column chn_resource.creationTime is '创建时间';
comment on column chn_resource.modifier is '修改人';
comment on column chn_resource.modifyTime is '修改时间';
comment on column chn_resource.ts is '时间戳';
comment on column chn_resource.dr is '删除标志';


-------------------------------------------------------
CREATE TABLE chn_user_resource
(
pk_user_resource char(20)  not null,
name varchar2(100)  not null,
content varchar2(100)  not null,
endtime char(19),
pk_resource char(20),
pk_user char(20),
ts char(19),
dr char(1),

  constraint pk_user_resource PRIMARY KEY ( pk_user_resource )

);
comment on column chn_user_resource.pk_user_resource is '主键';
comment on column chn_user_resource.name is '资源名称';
comment on column chn_user_resource.content is '资源内容';
comment on column chn_user_resource.endtime is '有效期';
comment on column chn_user_resource.pk_resource is '资源主键';
comment on column chn_user_resource.pk_user is '用户主键';
comment on column chn_user_resource.ts is '时间戳';
comment on column chn_user_resource.dr is '删除标志';


-------------------------------------------------------------------------
CREATE TABLE chn_order
(
pk_order char(20)  not null,
title varchar2(100)  not null,
memeo varchar2(100),
amount char(19)  not null,
state smallint  not null,
creator varchar2(100),
creationTime char(19),
ts char(19),
dr char(1),

  constraint pk_order PRIMARY KEY ( pk_order )

);
comment on column chn_order.pk_order is '主键';
comment on column chn_order.title is '标题';
comment on column chn_order.memeo is '备注';
comment on column chn_order.amount is '总金额';
comment on column chn_order.state is '订单状态';
comment on column chn_order.creator is '创建人';
comment on column chn_order.creationTime is '创建时间';
comment on column chn_order.ts is '时间戳';
comment on column chn_order.dr is '删除标志';

----------------------------------------------------------
CREATE TABLE chn_order_b
(
pk_order_b char(20)  not null,
pk_order char(20)  not null,
pk_resource varchar2(100)  not null,
name varchar2(100),
content varchar2(100),
endtime char(19),
price number(18,8)  not null,
num number(18,8)  not null,
amount number(18,8)  not null,
creator varchar2(100),
creationTime char(19),
ts char(19),
dr char(1),

  constraint pk_order_b PRIMARY KEY ( pk_order_b )

);
comment on column chn_order_b.pk_order_b is '主键';
comment on column chn_order_b.pk_order is '主表主键';
comment on column chn_order_b.pk_resource is '资源主键';
comment on column chn_order_b.name is '资源名称';
comment on column chn_order_b.content is '资源内容';
comment on column chn_order_b.endtime is '有效期';
comment on column chn_order_b.price is '单价';
comment on column chn_order_b.num is '数量';
comment on column chn_order_b.amount is '金额';
comment on column chn_order_b.creator is '创建人';
comment on column chn_order_b.creationTime is '创建时间';
comment on column chn_order_b.ts is '时间戳';
comment on column chn_order_b.dr is '删除标志';


------------------------------------------------------------------

