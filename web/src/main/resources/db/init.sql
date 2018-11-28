drop table auth_user;
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

);


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









------------------------------------------------------------------
create table auth_role
(
pk_role char(20)  not null,
roleCode varchar2(100)  not null,
roleName varchar2(100)  not null,
roleType varchar2(100),
memo varchar2(100),
enable char(1),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_role PRIMARY KEY ( pk_role )
);




comment on column auth_role.pk_role is '主键';
comment on column auth_role.roleCode is '角色编码';
comment on column auth_role.roleName is '角色名称';
comment on column auth_role.roleType is '角色类型';
comment on column auth_role.memo is '备注';
comment on column auth_role.enable is '是否锁定';
comment on column auth_role.creator is '创建人';
comment on column auth_role.creationTime is '创建时间';
comment on column auth_role.modifier is '修改人';
comment on column auth_role.modifyTime is '修改时间';
comment on column auth_role.ts is '时间戳';
comment on column auth_role.dr is '删除标志';
--------------------------------------------------------------------------
drop table auth_power;
create table auth_power
(
pk_power char(20)  not null,
powerCode varchar2(100)  not null,
powerName varchar2(100)  not null,
powerType varchar2(100),
url varchar2(100),
memo varchar2(100),
pk_parent char(20),
route varchar2(100),
isDir char(1),

enable char(1),
creator varchar2(100),
creationTime char(19),
modifier varchar2(100),
modifyTime char(19),
ts char(19),
dr char(1),

  constraint pk_power PRIMARY KEY ( pk_power )

);



comment on column auth_power.pk_power is '主键';
comment on column auth_power.powerCode is '功能编码';
comment on column auth_power.powerName is '功能名称';
comment on column auth_power.powerType is '功能类型';
comment on column auth_power.url is '地址';
comment on column auth_power.memo is '备注';
comment on column auth_power.enable is '是否锁定';
comment on column auth_power.pk_parent is '上级节点';
comment on column auth_power.route is '路径';
comment on column auth_power.isDir is '是否目录';

comment on column auth_power.creator is '创建人';
comment on column auth_power.creationTime is '创建时间';
comment on column auth_power.modifier is '修改人';
comment on column auth_power.modifyTime is '修改时间';
comment on column auth_power.ts is '时间戳';
comment on column auth_power.dr is '删除标志';





--------------------------------------------------

create table auth_user_role
(
pk_user_role char(20),
pk_user char(20),
pk_role char(20),
ts char(19),
dr char(1),

 constraint pk_user_role PRIMARY KEY ( pk_user_role )
 );


comment on column auth_user_role.pk_user_role is '主键';
comment on column auth_user_role.pk_user is '用户主键';
comment on column auth_user_role.pk_role is '角色主键';
comment on column auth_user_role.ts is '时间戳';
comment on column auth_user_role.dr is '删除标志';



-------------------------------------------------------------

create table auth_role_power
(
pk_role_power char(20),
pk_power char(20),
pk_role char(20),
ts char(19),
dr char(1),

 constraint pk_role_power PRIMARY KEY ( pk_role_power )

 );

comment on column auth_role_power.pk_role_power is '主键';
comment on column auth_role_power.pk_power is '功能主键';
comment on column auth_role_power.pk_role is '角色主键';
comment on column auth_role_power.ts is '时间戳';
comment on column auth_role_power.dr is '删除标志';


