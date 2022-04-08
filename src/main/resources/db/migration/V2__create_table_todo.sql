CREATE TABLE public.todo (
	id SERIAL NOT NULL PRIMARY KEY,
	name varchar(100) NOT NULL,
	status varchar(10) NOT NULL
);