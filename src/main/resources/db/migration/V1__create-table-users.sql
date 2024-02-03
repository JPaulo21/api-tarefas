CREATE TABLE users (
  id INTEGER SERIAL NOT NULL,
   username VARCHAR(255) NOT NULL,
   password VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   birth_date TIMESTAMP WITHOUT TIME ZONE,
   enable BOOLEAN NOT NULL,
   role VARCHAR(255) NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users ADD CONSTRAINT un_users_email UNIQUE (email);

ALTER TABLE users ADD CONSTRAINT un_users_username UNIQUE (username);