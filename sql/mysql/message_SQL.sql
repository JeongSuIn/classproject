-- 입력 sql
INSERT INTO `open`.`guestbook_message` (guest_name, password, message) VALUES ('test','1234','안녕하세요');
-- INSERT INTO guestbook_message (guest_name, password, message, writedate) VALUES (?,?,?);

-- 질의 sql
SELECT * FROM open.guestbook_message;
-- SELECT * FROM open.guestbook_message;

-- 삭제 sql
DELETE FROM `open`.`guestbook_message` WHERE message_id=1;
-- DELETE FROM `open`.`guestbook_message` WHERE message_id=?;