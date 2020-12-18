DROP TABLE test1;

CREATE TABLE user(
    id BIGINT NOT NULL,
    username VARCHAR NOT NULL,



);
user_id BIGINT NOT NULL,
    role VARCHAR(100) NOT NULL,
CONTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES "user"(id)
--- create appropriate fields for exercise