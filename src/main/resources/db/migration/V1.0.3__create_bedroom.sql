create table hotel.bedroom
(
    idrm uuid primary key default gen_random_uuid(),
    floor integer not null,
    apt_numb varchar(10) not null,
    status varchar(20) not null
);
