INSERT INTO `zerobug`.`roles` (`role_id`, `role`) VALUES ('1', 'ADMIN');
INSERT INTO `zerobug`.`roles` (`role_id`, `role`) VALUES ('2', 'PURCHASER');
INSERT INTO `zerobug`.`roles` (`role_id`, `role`) VALUES ('3', 'STUDENT');

-- username: eden  password: eden
INSERT INTO `zerobug`.`user` (`user_id`, `active`, `email`, `firstname`, `lastname`, `password`, `username`) VALUES ('1000', b'1', 'beden@miu.edi', 'Eden', 'Bereda', '$2a$10$WkNF/qiMb4jjjUgSRMPON.JsUnpdK7J2Q5yUy1zPvgH7Mi9JaXkxW', 'eden');
INSERT INTO `zerobug`.`user_role` (`user_id`, `role_id`) VALUES ('1000', '1');

