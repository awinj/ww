drop table auth_user
create table auth_user
(
pk_user char(20) not null ,
userCode varchar2(100)  not null,
userName varchar2(100)  not null,
password varchar2(100),
isLocked char(1),
telephone varchar2(100),
email varchar2(100),
sex varchar2(100),
city varchar2(100),
sign varchar2(100),
score number(18,8),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_user PRIMARY KEY ( pk_user )

)


comment on column auth_user.pk_user is '主键';
comment on column auth_user.userCode is '用户编码';
comment on column auth_user.userName is '用户名';
comment on column auth_user.password is '密码';
comment on column auth_user.isLocked is '是否锁定';
comment on column auth_user.telephone is '手机';
comment on column auth_user.email is '邮箱';
comment on column auth_user.sex is '性别';
comment on column auth_user.city is '城市';
comment on column auth_user.sign is '签名';
comment on column auth_user.score is '分数';
comment on column auth_user.creator is '创建人';
comment on column auth_user.creationTime is '创建时间';
comment on column auth_user.modifier is '修改人';
comment on column auth_user.modifyTime is '修改时间';
comment on column auth_user.ts is '时间戳';
comment on column auth_user.dr is '删除标志';
