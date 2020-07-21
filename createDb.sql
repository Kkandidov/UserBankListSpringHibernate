-- table creation users
CREATE TABLE users(
                      user_id	SERIAL PRIMARY KEY,
                      name		CHARACTER VARYING(30)	NOT NULL,
                      surname	CHARACTER VARYING(30)   NOT NULL
);

-- table creation accounts
CREATE TABLE accounts(
                         account_id	SERIAL PRIMARY KEY,
                         account	DECIMAL(10,2)	    NOT NULL,
                         user_id	INTEGER				NOT NULL,
                         CONSTRAINT	fk_user_id		FOREIGN KEY (user_id)	REFERENCES	users	(user_id)	ON DELETE CASCADE
);
