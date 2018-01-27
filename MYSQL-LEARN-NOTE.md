## 1. 查看是否开启evevt与开启evevt。
```mysql
SHOW VARIABLES LIKE '%event_scheduler%';
SET GLOBAL event_scheduler = 1;
```

## 2. 创建测试表test
```mysql
DROP TABLE IF EXISTS test;  
CREATE TABLE test  
(
id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
TIME DATETIME NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;
```
### 3.创建evevt要调用的存储过程test_proce
```mysql
DELIMITER //
DROP PROCEDURE IF EXISTS test_proce//
CREATE PROCEDURE test_proce()
BEGIN
INSERT INTO test(TIME) VALUES(NOW());
END//
DELIMITER ;
```
### 4.创建事件test_event（其作用：每隔一秒自动调用test_proce()存储过程）
```mysql
DROP EVENT IF EXISTS test_event;
CREATE EVENT test_event
ON SCHEDULE EVERY 1 SECOND
ON COMPLETION PRESERVE DISABLE
DO CALL test_proce();
```
### 5、开启事件test_event
```mysql
alter event test_event on completion preserve enable;
```

## 6、关闭事件test_event
```mysql
alter event test_event on completion preserve disable;
```
### 7、查看表test
```mysql
select * from test;
```

