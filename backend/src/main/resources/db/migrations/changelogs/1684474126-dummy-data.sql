
insert into genre (id,name) values (1,'Action'),(2,'Romantic'),(3,'Horror');


insert into movie (id,title,description,release_year,created_at,updated_at) values
                                                   (10000,'Breaking Bad','You know business and i know chemistry',2014,current_date,current_date),
                                                   (10001,'The Shawshank Redemption','One of my favorite movie',2014,current_date,current_date),
                                                   (10002,'Miracle in Cell No. 7','Must watch this movie',2014,current_date,current_date);



insert into movie_genre (movie_id,genre_id) values (10000,1), (10000,2),(10001,1), (10001,3),(10002,2), (10002,1);
