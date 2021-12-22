CREATE TABLE `news` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `thumbnail` text DEFAULT "",
  `title` varchar(100) UNIQUE NOT NULL,
  `short_description` varchar(200) DEFAULT "",
  `content` longtext NOT NULL,
  `user_id` int,
  `created_date` datetime,
  `modified_date` datetime,
  `status` int,
  `publish_date` timestamp,
  `category_id` bigint,
  `is_hot` int DEFAULT 2
);

CREATE TABLE `category` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(50)
);

CREATE TABLE `user` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `username` varchar(100) UNIQUE NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) UNIQUE NOT NULL,
  `created_date` datetime,
  `created_by` varchar(100),
  `modified_date` datetime,
  `modified_by` varchar(100),
  `role_id` bigint
);

CREATE TABLE `role` (
  `id` bigint PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(50)
);

ALTER TABLE `news` ADD FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

ALTER TABLE `news` ADD FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

ALTER TABLE `user` ADD FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
