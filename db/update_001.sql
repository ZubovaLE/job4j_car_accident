CREATE TABLE accident_types
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE rules
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE accidents
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(100),
    text    VARCHAR(1000),
    address VARCHAR(500),
    accident_type_id INT REFERENCES accident_types (id)
);

CREATE TABLE accident_rules
(
    id          SERIAL PRIMARY KEY,
    accident_id INT REFERENCES accidents (id),
    rule_id     INT REFERENCES rules (id)
);


INSERT INTO accident_types(name)
VALUES ('Две машины'),
       ('Машина и человек'),
       ('Машина и велосипед');

INSERT INTO rules(name)
VALUES ('Статья. 1'),
       ('Статья. 2'),
       ('Статья. 3');