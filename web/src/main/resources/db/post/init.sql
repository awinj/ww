CREATE TABLE pst_post
(
pk_post char(20)  not null,
title varchar2(100)  not null,
content varchar2(100),
photo varchar2(100),
photoposi varchar2(100)  not null,
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_post PRIMARY KEY ( pk_post )

);
comment on column pst_post.pk_post is '主键';
comment on column pst_post.title is '主题';
comment on column pst_post.content is '内容';
comment on column pst_post.photo is '图片';
comment on column pst_post.photoposi is '图片位置';
comment on column pst_post.creator is '创建人';
comment on column pst_post.creationTime is '创建时间';
comment on column pst_post.modifier is '修改人';
comment on column pst_post.modifyTime is '修改时间';
comment on column pst_post.ts is '时间戳';
comment on column pst_post.dr is '删除标志';


---------------------------------------------------------------------------
CREATE TABLE pst_comment
(
pk_comment char(20)  not null,
title varchar2(100)  not null,
content varchar2(100),
photo varchar2(100),
photoposi varchar2(100)  not null,
pk_parent char(20),
route varchar2(100),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_comment PRIMARY KEY ( pk_comment )

);
comment on column pst_comment.pk_comment is '主键';
comment on column pst_comment.title is '主题';
comment on column pst_comment.content is '内容';
comment on column pst_comment.photo is '图片';
comment on column pst_comment.photoposi is '图片位置';
comment on column pst_comment.pk_parent is '父节点';
comment on column pst_comment.route is '路由';
comment on column pst_comment.creator is '创建人';
comment on column pst_comment.creationTime is '创建时间';
comment on column pst_comment.modifier is '修改人';
comment on column pst_comment.modifyTime is '修改时间';
comment on column pst_comment.ts is '时间戳';
comment on column pst_comment.dr is '删除标志';
