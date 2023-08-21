
create table movie
(
    id                bigint generated by default as identity not null,
    title             varchar(255)                            not null,
    release_year      integer                                 not null,
    description       varchar(255)                            not null,
    created_at timestamp without time zone not null,
    updated_at timestamp without time zone not null,
    constraint pk_movie primary key (id)
);

create table movie_genre (
    genre_id bigint not null,
    movie_id bigint not null,
    primary key (genre_id, movie_id)
)