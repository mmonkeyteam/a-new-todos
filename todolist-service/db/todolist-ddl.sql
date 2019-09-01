
CREATE TABLE `todolist` (
  `todolist_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`todolist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `label` (
  `label_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `properties` json DEFAULT NULL COMMENT 'General properties in JSON format.',
  PRIMARY KEY (`label_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `status` (
  `status_code` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`status_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `type` (
  `type_code` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  PRIMARY KEY (`type_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `priority` int(11) NOT NULL COMMENT 'The priority of the activity. Ascending order.',
  `creation_date` timestamp NOT NULL,
  `completition_date` timestamp NULL DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT NULL COMMENT 'Logical deletion.',
  `todolist_id` int(11) NOT NULL,
  `label_id` int(11) NOT NULL,
  `status_code` int(11) NOT NULL,
  `type_code` int(11) NOT NULL,
  `properties` json DEFAULT NULL COMMENT 'General properties in JSON format.',
  PRIMARY KEY (`activity_id`),
  KEY `activity_FK_1` (`label_id`),
  KEY `activity_FK_2` (`type_code`),
  KEY `activity_FK_3` (`status_code`),
  KEY `activity_FK` (`todolist_id`),
  CONSTRAINT `activity_FK` FOREIGN KEY (`todolist_id`) REFERENCES `todolist` (`todolist_id`),
  CONSTRAINT `activity_FK_1` FOREIGN KEY (`label_id`) REFERENCES `label` (`label_id`),
  CONSTRAINT `activity_FK_2` FOREIGN KEY (`type_code`) REFERENCES `type` (`type_code`),
  CONSTRAINT `activity_FK_3` FOREIGN KEY (`status_code`) REFERENCES `status` (`status_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci