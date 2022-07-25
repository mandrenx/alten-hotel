insert into hotel.booking (status, accommodation, entry_at, exit_at, registered_at)
values ('CANCELED', 'COUPLE', now(), now(), now()),
       ('CONFIRMED', 'COUPLE_SINGLE', now(), now(), now()),
       ('UNFILLED', 'COUPLE_SINGLE', now(), now(), now()),
       ('UNFILLED', 'COUPLE', now(), now(), now()),
       ('UNDER_PROCESSING', 'SINGLE', now(), now(), now());