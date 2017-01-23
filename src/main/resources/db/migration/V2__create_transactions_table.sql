CREATE TABLE `transactions` (
  `id`              INT     NOT NULL AUTO_INCREMENT,
  `version`         INT     NULL DEFAULT 0,
  `user_id`         INT     NULL,
  `action`          ENUM('HIT', 'STAND') NULL,
  `user_card`       VARCHAR(50),
  `user_points`     INT NULL,
  `dealer_card`     VARCHAR(50),
  `dealer_points`   INT NULL,
  `bet`             INT NULL,
  `result`          ENUM('WIN', 'LOST') NOT NULL,
  `created`         TIMESTAMP NULL DEFAULT NOW(),
  `modified`        TIMESTAMP NULL DEFAULT NOW(),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_user_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

