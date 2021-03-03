create table cars (
  id serial primary key,
  marka text,
  model text,
  engine_id int not null references engine(id)
);

create table drivers (
  id serial primary key,
  name text
);

create table history_owner (
   id serial primary key,
   driver_id int not null references drivers(id),
   car_id int not null references cars(id)
);

create table engine (
  id serial primary key,
  name text
);