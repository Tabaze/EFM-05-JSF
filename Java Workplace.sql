drop database  dbmodule;
create database dbmodule;
use dbmodule;

create table module(
	code_module int auto_increment primary key,
    titre_mod varchar(500),
    nb_heure  varchar(500),
    filiere varchar(500)
); 