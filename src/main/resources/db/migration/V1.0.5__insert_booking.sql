insert into hotel.booking (status, accommodation, entry_at, exit_at, registered_at)
values ('AVAILABLE', 'COUPLE', now(), now(), now()),
       ('UNAVAILABLE', 'COUPLE_SINGLE', now(), now(), now()),
       ('UNAVAILABLE', 'COUPLE', now(), now(), now()),
       ('UNAVAILABLE', 'COUPLE_SINGLE', now(), now(), now()),
       ('UNAVAILABLE', 'SINGLE', now(), now(), now());