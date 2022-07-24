create table hotel.booking_guest
(
    idbgi uuid primary key default gen_random_uuid(),
    booking_id uuid not null,
    guest_id uuid not null,
    added_at timestamp not null
);
