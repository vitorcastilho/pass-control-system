create table passcontrol.pass (
	id BIGSERIAL NOT NULL PRIMARY KEY,
	type CHAR NOT NULL,
	number NUMERIC(4) NOT NULL,
	is_active boolean NOT NULL DEFAULT TRUE
);