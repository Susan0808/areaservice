CREATE TABLE request (
  id bigint unsigned PRIMARY KEY AUTO_INCREMENT,
  featureid varchar(100),
  coordinate varchar(23),
  requesttime timestamp
);