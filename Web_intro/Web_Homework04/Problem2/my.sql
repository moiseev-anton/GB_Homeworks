CREATE TABLE students (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name TEXT NOT NULL,
  age INTEGER NOT NULL,
  adress TEXT NOT NULL
);

INSERT INTO students (name, age, adress) VALUES ('Роман', 28, 'Москва');
INSERT INTO students (name, age, adress) VALUES ('Елена', 25, 'С.Петербург');
INSERT INTO students (name, age, adress) VALUES ('Артем', 30, 'Тверь');
INSERT INTO students (name, age, adress) VALUES ('Борис', 36, 'Воронеж');
INSERT INTO students (name, age, adress) VALUES ('Алексей', 21, 'Самара');
INSERT INTO students (name, age, adress) VALUES ('Марина', 32, 'Москва');
INSERT INTO students (name, age, adress) VALUES ('Катерина', 27, 'Новосибирск');
INSERT INTO students (name, age, adress) VALUES ('Стас', 29, 'Москва');
INSERT INTO students (name, age, adress) VALUES ('Иван', 34, 'Курск');
INSERT INTO students (name, age, adress) VALUES ('Ольга', 18, 'Москва');

SELECT name AS "Имя"
FROM students 
WHERE adress = "Москва" 
AND age >= 18 
AND age < 30;