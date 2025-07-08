#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
    CREATE DATABASE restaurant;
    CREATE DATABASE payments;
    CREATE DATABASE sales;
EOSQL
