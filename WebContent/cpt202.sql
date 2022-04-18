DROP DATABASE `shopping-mall`;

CREATE DATABASE `shopping-mall`;

USE `shopping-mall`;

CREATE TABLE user (
    uid VARCHAR(50) PRIMARY KEY,
    nick_name VARCHAR(25),
    payment_method_index int
);

CREATE INDEX payment_method_index ON user (payment_method_index);

CREATE TABLE payment_method (
    p_id INT PRIMARY KEY AUTO_INCREMENT,
    bank_account VARCHAR(50),
    p_index int,
    FOREIGN KEY (p_index) REFERENCES user(payment_method_index)
);

CREATE TABLE commodity (
    commodity_id VARCHAR(50) PRIMARY KEY, # UUID for commodity
    commodity_index bigint UNIQUE AUTO_INCREMENT, # 用于分页
    title VARCHAR(50),
    description VARCHAR(200),
    cover VARCHAR(512),
    price FLOAT
);

CREATE TABLE favorite (
    favorite_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    owner VARCHAR(50),
    commodity_index VARCHAR(50),
    FOREIGN KEY (commodity_index) REFERENCES commodity(commodity_id),
    FOREIGN KEY (owner) REFERENCES user(uid)
);

# 新增商品
INSERT into commodity VALUES (
  '${commodity-id}',
    0, # 自增
  '${commodity-title}',
  '${description}',
  '${coverImage-url}',
  0.1 #价格
);

# 分页拉取商品列表, n 为上一次拉取的列表的最后一个商品的index:
SELECT * FROM commodity
WHERE commodity.commodity_index > n,
LIMIT 100;

# 创建一个用户, 注意需要首先自行生成一个uid和一个payment_uid
INSERT into user VALUES (
    '${uid}',
    '${nick_name}',
    '${payment_uid}'
);

INSERT INTO payment_method VALUES (
    0, # 自增
    '${back_account}',
    '${payment_uid}'
);

# 查询某个用户(user.uid = "xxx-xxx-xxx")的所有支付方式
SELECT * FROM
    user INNER JOIN payment_method
    ON user.payment_method_index = payment_method.p_index
    WHERE user.uid = "xxx-xxx-xxx"
    GROUP BY user.uid;

# uid="xxx" 的用户 将 commodity_id = "yyy" 的商品加入收藏
INSERT INTO favorite VALUES (
    0,
    'xxx',
    'yyy'
);

# uid="xxx" 的用户的收藏夹
SELECT * FROM favorite INNER JOIN commodity
ON favorite.commodity_index = commodity.commodity_id
WHERE favorite.owner = 'xxx';