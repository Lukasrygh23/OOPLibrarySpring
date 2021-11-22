DROP TABLE IF EXISTS `book` CASCADE;
CREATE TABLE `book` 
(
	`book_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`book_name` VARCHAR(255) NOT NULL,
	`author_name` VARCHAR(255)
);
DROP TABLE IF EXISTS `t_license` CASCADE;
CREATE TABLE `t_license`
(
	`license_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`recipient_username` VARCHAR(255),
	`return_date` DATE,
	`book_book_id` BIGINT,
	FOREIGN KEY (`book_book_id`) REFERENCES `book`(`book_id`)
);