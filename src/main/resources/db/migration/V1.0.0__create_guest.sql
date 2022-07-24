create table hotel.guest
(
    idgst uuid primary key default gen_random_uuid(),
    firstname varchar(50) not null,
    lastname varchar(50) not null,
    email varchar(30) not null,
    phone varchar(15) not null,
    entry_type varchar(10) not null,
    people_qnt integer not null,
    registered_at timestamp not null,
    updated_at timestamp
);

create table ValuesEntity
(
    value varchar(255) not null,
    primary key (value)
);
