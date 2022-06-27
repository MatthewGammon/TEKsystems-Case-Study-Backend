CREATE TABLE IF NOT EXISTS `capes`
(
    `cape_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `cape_name` varchar(255) NOT NULL,
    PRIMARY KEY (`cape_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `chest_gear`
(
    `chest_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `chest_name` varchar(255) NOT NULL,
    PRIMARY KEY (`chest_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `food`
(
    `food_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `food_name` varchar(255) NOT NULL,
    PRIMARY KEY (`food_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `head_gear`
(
    `head_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `head_name` varchar(255) NOT NULL,
    PRIMARY KEY (`head_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `main_hand`
(
    `main_hand_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `main_hand_name` varchar(255) NOT NULL,
    PRIMARY KEY (`main_hand_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `mounts`
(
    `mount_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `mount_name` varchar(255) NOT NULL,
    PRIMARY KEY (`mount_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `off_hand`
(
    `off_hand_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `off_hand_name` varchar(255) NOT NULL,
    PRIMARY KEY (`off_hand_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `potions`
(
    `potion_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `potion_name` varchar(255) NOT NULL,
    PRIMARY KEY (`potion_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS `shoes`
(
    `shoe_id`   bigint(20)   NOT NULL AUTO_INCREMENT,
    `shoe_name` varchar(255) NOT NULL,
    PRIMARY KEY (`shoe_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

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
    `time_of_death`    varchar(255) NOT NULL,
    PRIMARY KEY (`regear_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 59
  DEFAULT CHARSET = latin1;

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
) ENGINE = InnoDB
  AUTO_INCREMENT = 38
  DEFAULT CHARSET = latin1;