# Order
DROP DATABASE IF EXISTS `order`;
CREATE DATABASE order;
CREATE TABLE order.orders
(
    id               INT(11) NOT NULL AUTO_INCREMENT,
    user_id          VARCHAR(20)    DEFAULT NULL,
    product_id       VARCHAR(20)    DEFAULT NULL,
    amount           DECIMAL(10, 0) DEFAULT NULL,
    status           VARCHAR(100)   DEFAULT NULL,
    create_at        DATETIME       DEFAULT CURRENT_TIMESTAMP,
    update_at        DATETIME       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB AUTO_INCREMENT = 1 DEFAULT CHARSET = utf8;

# Warehouse
DROP DATABASE IF EXISTS warehouse;
CREATE DATABASE warehouse;
CREATE TABLE warehouse.product
(
    id               INT(11)        NOT NULL AUTO_INCREMENT,
    stock            INT(11)        DEFAULT NULL,
    create_at        DATETIME       DEFAULT CURRENT_TIMESTAMP,
    update_at        DATETIME       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;
INSERT INTO warehouse.product (id, stock) VALUES (10000, 10);

# Payment
DROP DATABASE IF EXISTS payment;
CREATE DATABASE payment;
CREATE TABLE payment.account
(
    user_id          VARCHAR(20)    DEFAULT NULL,
    balance          DOUBLE   DEFAULT NULL,
    create_at        DATETIME       DEFAULT CURRENT_TIMESTAMP,
    update_at        DATETIME       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (user_id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;
INSERT INTO payment.account (user_id, balance) VALUES ("bingo", 500);

SELECT auto_increment
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = 'seata_order'
  AND TABLE_NAME = 'undo_log'