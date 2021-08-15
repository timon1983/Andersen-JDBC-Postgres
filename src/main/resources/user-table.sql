CREATE TABLE IF NOT EXISTS users(
                    user_id serial not null,
                    primary key(user_id),
                    first_name varchar(45) not null,
                    last_name varchar(45) not null,
                    age int not null);
