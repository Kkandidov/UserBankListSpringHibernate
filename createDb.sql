-- database creation 
CREATE SCHEMA `accounts_users` DEFAULT CHARACTER SET utf8;

-- table creation users
CREATE TABLE users(
	user_id		INT				NOT NULL	AUTO_INCREMENT,
	name		VARCHAR(45)		NOT NULL,
	surname		VARCHAR(45)		NOT NULL,

	CONSTRAINT	pk_users_id	PRIMARY KEY	(user_id)
)ENGINE = InnoDB;

-- table creation accounts
CREATE TABLE accounts(
	account_id	INT				NOT NULL	AUTO_INCREMENT,
	account		DECIMAL(10,2)	NOT NULL,
	user_id		INT				NOT NULL,

	CONSTRAINT	pk_accounts_id	PRIMARY KEY	(account_id),
	CONSTRAINT	fk_user_id		FOREIGN KEY (user_id)	REFERENCES	users	(user_id)	ON DELETE CASCADE
)ENGINE = InnoDB;
