FROM postgres:12.7-alpine3.14
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
ENV POSTGRES_DB=LoginDB
COPY ./postgresql.sql /docker-entrypoint-initdb.d/