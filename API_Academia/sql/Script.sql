/*DQL - Alguns exemplos*/

create database academia;

drop table turma;

select * from turma;

select horario + duracao from turma;

select * from instrutor;

select * from atividade;

select horario as hr from turma order by turmaid desc limit 1;

SELECT horario + duracao from turma;


/*DDL - CRIANDO TABELAS*/

create table instrutor (
instrutorid serial not null,
rg varchar(14),
nome varchar(45),
nascimento timestamp,
primary key(instrutorid)
);

create table atividade (
atividadeid serial not null,
nome varchar(45),
primary key(atividadeid)
);

create table turma (
turmaid serial not null,
horario timestamp,
duracao time,
dataInicio timestamp,
dataFim timestamp,
instrutorid int,
atividadeid int,
primary key(turmaId),
foreign key(instrutorid) references instrutor(instrutorid),
foreign key(atividadeid) references atividade(atividadeid)
); 


/*DDL - CRIANDO FUNÇÃO*/

create function data_inicio_turma()
returns trigger as $$
begin
	new.datainicio = new.horario;
	return new;
end
$$ language 'plpgsql';



create function data_fim_turma()
returns trigger as $$
begin
	new.datafim = new.horario + new.duracao;
	return new;
end
$$ language 'plpgsql';

/*DDL - CRIANDO TRIGGER*/

create trigger data_inicio_nova
before insert
on turma
for each row
execute procedure data_inicio_turma();


create trigger datafim_nova
before insert
on turma
for each row
execute procedure data_fim_turma();




/*DML - INSERINDO VALORES (MELHOR FAZER PELA API)*/

insert into instrutor(rg, nome, nascimento)
values(
250021,
'Ben',
'2016-06-22 19:10:25-07'
);

insert into atividade(nome)
values('Judo');

insert into turma(horario, duracao, instrutorid, atividadeid)
values(
'2025-03-13 12:00:00-00',
'6:00:00',
1,
1
);