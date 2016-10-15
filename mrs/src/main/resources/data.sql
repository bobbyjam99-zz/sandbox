-- 会議室
INSERT INTO meeting_room (room_name) VALUES ('東京');
INSERT INTO meeting_room (room_name) VALUES ('神田');
INSERT INTO meeting_room (room_name) VALUES ('秋葉原');

-- 会議室の予約可能日
-- room_id=1の予約可能日
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 1);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 1);
-- room_id=2の予約可能日
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE, 2);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE + 1, 2);
INSERT INTO reservable_room (reserved_date, room_id) VALUES (CURRENT_DATE - 1, 2);

-- ダミーユーザー

-- 認証確認用テストユーザ