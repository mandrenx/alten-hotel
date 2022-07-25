create table hotel.booking
(
    idbkg uuid primary key default gen_random_uuid(),
    status varchar(20) not null,
    accommodation varchar(20) not null,
    entry_at timestamp not null,
    exit_at timestamp not null,
    registered_at timestamp not null,
    updated_at timestamp
);
