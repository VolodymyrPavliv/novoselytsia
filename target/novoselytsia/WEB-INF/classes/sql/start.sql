create table if not exists `users` (
  `id` int primary key  auto_increment,
  `email` varchar(100) not null unique,
  `first_name` varchar(200) not null,
  `last_name` varchar(200) not null,
  `age` int not null,
  `password` varchar(200) not null,
  `filename` varchar(100)
);

create table if not exists `roles` (
  `id` int primary key auto_increment,
  `name` varchar(50) not null unique
);

create table if not exists `user_roles` (
  `id` int primary key auto_increment,
  `user_id` int not null,
  `role_id` int not null,
        foreign key (user_id)
            references users(`id`)
            on update restrict on delete cascade,
        foreign key (role_id)
            references roles(`id`)
            on update restrict on delete cascade
);

create table if not exists `news` (
  `id` int primary key auto_increment,
  `user_id` int,
  `title` varchar(100) not null,
  `text` varchar(550) not null,
  `publication_date` datetime not null,
  `last_modified` datetime,
  `filename` varchar(100),

  foreign key (user_id)
    references users(`id`)
        on update restrict on delete cascade
);

create table if not exists `places` (
    `id` int primary key auto_increment,
    `name` varchar(100) not null,
    `description` varchar(550),
    `location` varchar(100),
    `filename` varchar(100)
);