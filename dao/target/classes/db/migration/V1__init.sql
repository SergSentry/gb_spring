create table users (
  id                    bigserial,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  email                 varchar(50) unique,
  primary key (id)
);

create table permissions (
  id                    serial,
  name                  varchar(100) not null,
  primary key (id)
);

CREATE TABLE users_permissions (
  user_id               bigint not null,
  permission_id            int not null,
  primary key (user_id, permission_id),
  foreign key (user_id) references users (id),
  foreign key (permission_id) references permissions (id)
);

insert into permissions (name)
values
('PERMISSION_ALL'), ('PERMISSION_READ_USER_INFO');

insert into users (username, password, email)
values
('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
('admin', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'admin@gmail.com');

insert into users_permissions (user_id, permission_id)
values
(1, 2),
(2, 1),
(2, 2);