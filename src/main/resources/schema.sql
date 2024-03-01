create table if not exists books (
     id bigserial not null,
     title varchar not null,
     author varchar not null,
     price double precision,
     primary key (id)
);