drop table if exists auctions cascade;
drop table if exists bids cascade;

drop sequence if exists auctions_id_seq;
drop sequence if exists bids_id_seq;

create sequence auctions_id_seq start 1 increment 1;
create sequence bids_id_seq start 1 increment 1;

create table auctions (
    id bigint primary key default nextval('auctions_id_seq'),
    title varchar not null,
    seller varchar not null,
    category varchar not null,
    description varchar,
    condition varchar not null,
    created_at timestamp default now(),
    updated_at timestamp default now()
);

create table bids (
    id bigint primary key default nextval('bids_id_seq'),
    username varchar not null,
    price float not null check(price > 0),
    created_at timestamp default now(),
    updated_at timestamp default now(),
    auction bigint not null references auctions (id) on delete cascade
);
