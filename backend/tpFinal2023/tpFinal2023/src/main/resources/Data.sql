
CREATE TABLE Recursos (
  id INT PRIMARY KEY,
  nombre VARCHAR(255)
);
CREATE TABLE espacio_fisico (
  id INT PRIMARY KEY,
  nombre VARCHAR(255)
);

insert into Recursos(id, nombre)values (1, 'Proyector');
insert into Recursos(id, nombre)values (2, 'Dispenser');



insert into espacio_fisico(id, nombre)values (1, 'sum');
insert into espacio_fisico(id, nombre)values (2, 'lab1');
