CREATE TABLE IF NOT EXISTS `builds`
(
    `build_id`     bigint(20)   NOT NULL AUTO_INCREMENT,
    `build_name`   varchar(255) NOT NULL,
    `build_role`   varchar(255) NOT NULL,
    `cape`         varchar(255) NOT NULL,
    `chest_gear`   varchar(255) NOT NULL,
    `food`         varchar(255) NOT NULL,
    `head_gear`    varchar(255) NOT NULL,
    `main_hand`    varchar(255) NOT NULL,
    `minimum_ip`   int(11)      NOT NULL,
    `minimum_tier` int(11)      NOT NULL,
    `mount`        varchar(255) NOT NULL,
    `off_hand`     varchar(255) DEFAULT NULL,
    `potion`       varchar(255) NOT NULL,
    `shoes`        varchar(255) NOT NULL,
    PRIMARY KEY (`build_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.capes
CREATE TABLE IF NOT EXISTS `capes`
(
    `cape_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `cape_name` varchar(255) NOT NULL,
    PRIMARY KEY (`cape_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.chest_gear
CREATE TABLE IF NOT EXISTS `chest_gear`
(
    `chest_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `chest_name` varchar(255) NOT NULL,
    PRIMARY KEY (`chest_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.food
CREATE TABLE IF NOT EXISTS `food`
(
    `food_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `food_name` varchar(255) NOT NULL,
    PRIMARY KEY (`food_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 9
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.head_gear
CREATE TABLE IF NOT EXISTS `head_gear`
(
    `head_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `head_name` varchar(255) NOT NULL,
    PRIMARY KEY (`head_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.main_hand
CREATE TABLE IF NOT EXISTS `main_hand`
(
    `main_hand_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `main_hand_name` varchar(255) NOT NULL,
    PRIMARY KEY (`main_hand_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 114
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.mounts
CREATE TABLE IF NOT EXISTS `mounts`
(
    `mount_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `mount_name` varchar(255) NOT NULL,
    PRIMARY KEY (`mount_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 25
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.off_hand
CREATE TABLE IF NOT EXISTS `off_hand`
(
    `off_hand_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `off_hand_name` varchar(255) NOT NULL,
    PRIMARY KEY (`off_hand_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 17
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.potions
CREATE TABLE IF NOT EXISTS `potions`
(
    `potion_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `potion_name` varchar(255) NOT NULL,
    PRIMARY KEY (`potion_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 8
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.regears
CREATE TABLE IF NOT EXISTS `regears`
(
    `regear_id`        bigint(20)   NOT NULL AUTO_INCREMENT,
    `character_name`   varchar(255) NOT NULL,
    `chest_equivalent` int(11)      NOT NULL,
    `chest_gear`       varchar(255) NOT NULL,
    `chest_tier`       varchar(255) NOT NULL,
    `event_id`         varchar(255) NOT NULL,
    `guild_name`       varchar(255) NOT NULL,
    `head_equivalent`  int(11)      NOT NULL,
    `head_gear`        varchar(255) NOT NULL,
    `head_tier`        varchar(255) NOT NULL,
    `item_power`       int(11)      NOT NULL,
    `main_equivalent`  int(11)      NOT NULL,
    `main_hand`        varchar(255) NOT NULL,
    `main_tier`        varchar(255) NOT NULL,
    `shoes`            varchar(255) NOT NULL,
    `shoes_equivalent` int(11)      NOT NULL,
    `shoes_tier`       varchar(255) NOT NULL,
    `status`           varchar(255) DEFAULT NULL,
    `time_of_death`    varchar(255) NOT NULL,
    PRIMARY KEY (`regear_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.roles
CREATE TABLE IF NOT EXISTS `roles`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 3
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.shoes
CREATE TABLE IF NOT EXISTS `shoes`
(
    `shoe_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `shoe_name` varchar(255) NOT NULL,
    PRIMARY KEY (`shoe_id`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 31
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.users
CREATE TABLE IF NOT EXISTS `users`
(
    `id`       bigint(20)   NOT NULL AUTO_INCREMENT,
    `email`    varchar(255) NOT NULL,
    `password` varchar(255) NOT NULL,
    `username` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UKr43af9ap4edm43mmtq01oddj6` (`username`),
    UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`)
) ENGINE = MyISAM
  AUTO_INCREMENT = 4
  DEFAULT CHARSET = latin1;

-- Data exporting was unselected.

-- Dumping structure for table tidal_regears_dev.user_roles
CREATE TABLE IF NOT EXISTS `user_roles`
(
    `user_id` bigint(20) NOT NULL,
    `role_id` int(11)    NOT NULL,
    PRIMARY KEY (`user_id`, `role_id`),
    KEY `FKh8ciramu9cc9q3qcqiv4ue8a6` (`role_id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = latin1;