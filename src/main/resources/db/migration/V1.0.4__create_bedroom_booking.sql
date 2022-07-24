create table hotel.bedroom_booking
(
    idbbi uuid primary key default gen_random_uuid(),
    bedroom_id uuid not null,
    booking_id uuid not null,
    added_at timestamp not null
);
