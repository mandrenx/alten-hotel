#!/bin/bash

set -e
set -u

function create_database() {
    local username='alten-hotel-app';
    local hotel_user='hotel-user-svc';
    local hotel_pswd='hotel-pswd-svc';
    local dbname='alten-hotel';
    local schema='hotel';

    echo " Creating user '$username' and database '$dbname' and schema '$schema'"
    psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
        CREATE ROLE "$username";
        CREATE DATABASE "$dbname" WITH OWNER '$username';
        GRANT ALL PRIVILEGES ON DATABASE "$dbname" TO "$username";
        CREATE USER "$hotel_user" WITH ENCRYPTED PASSWORD "$hotel_pswd";
        GRANT CONNECT ON DATABASE "$dbname" TO "$hotel_user";
        GRANT "$username" TO "$hotel_user";
EOSQL
    psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" -d "$dbname" <<-EOSQL
        CREATE SCHEMA $schema AUTHORIZATION "$username";
        CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;
        ALTER ROLE "$username" SET search_path TO $schema, public;
        ALTER ROLE "$hotel_user" SET search_path TO $schema, public;

        CREATE TABLE $schema.flyway_schema_history (
           installed_rank integer                      PRIMARY KEY
           , version        character varying(50)
           , description    character varying(200)       not null
           , type           character varying(20)        not null
           , script         character varying(1000)      not null
           , checksum       integer
           , installed_by   character varying(100)       not null
           , installed_on   timestamp without time zone  not null default now()
           , execution_time integer                      not null
           , success        boolean                      not null
          );

        ALTER TABLE $schema.flyway_schema_history OWNER TO "$username";
EOSQL
}
