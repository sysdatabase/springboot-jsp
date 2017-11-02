insert into t_user(username,password) values('admin','admin');
insert into t_role(name) values('管理员');
insert into t_permission(name,url,parent_id,description) values('首页','/welcome',0,'系统首页');
insert into t_user_role values(1,1);
insert into t_role_permission values(1,1);