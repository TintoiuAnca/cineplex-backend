<!------------------------Movie Table------------------------------------------>


CREATE TABLE
    movie
    (
        id_m INTEGER PRIMARY KEY AUTOINCREMENT,
        age_recommandation INT,
        cinema_date DATE ,
        description VARCHAR,
        director VARCHAR,
        distribution VARCHAR,
        format VARCHAR,
        gendre VARCHAR,
        name VARCHAR,
        rating DOUBLE,
        time TIME  
    );

CREATE TABLE
    hibernate_sequence
    (
        next_val BIGINT
    );

INSERT INTO movie (id_m, age_recommandation, cinema_date, description, director, distribution ,format,gendre ,name ,rating ,time)  
  VALUES (1, 13, '2019-04-15', 'A young woman falls for a guy with a dark secret and the two embark on a rocky relationship. Based on the novel by Anna Todd', 'Jenny Gage', ' Josephine Langford, Hero Fiennes Tiffin, Khadijha Red Thunder', '2D', 'drama,romance','After',5.5,'01:15');
INSERT INTO movie (id_m, age_recommandation, cinema_date, description, director , distribution ,format,gendre ,name  ,rating ,time) 
  VALUES (2, 18, '2019-05-17', 'A hopeless romantic ambivalent about his future in medical school falls for a hard-luck young woman who does not believe in love.', 'Ry Russo-Young', 'Yara Shahidi, Anais Lee, Charles Melton', '2D', 'Drama, Romance','The sun is also a star',5.5,'01:10');
INSERT INTO hibernate_sequence (next_val) VALUES (3);


<!--------------------UserType-------------------------------------------->


CREATE TABLE
USER_TYPE
(
id_tp BIGINT NOT NULL,
type_name VARCHAR,
PRIMARY KEY(id_tp)
);

CREATE TABLE
    hibernate_sequence_usertype
    (
        next_val BIGINT
    );
	
INSERT INTO USER_TYPE(id_tp,type_name) VALUES (1,'pensionar');
INSERT INTO USER_TYPE(id_tp,type_name) VALUES (2,'adult');
INSERT INTO USER_TYPE(id_tp,type_name) VALUES (3,'student');
INSERT INTO USER_TYPE(id_tp,type_name) VALUES (4,'copil');

INSERT INTO hibernate_sequence_usertype (next_val) VALUES (5);

{
        "age_recommandation":13,
        "cinema_date" :"2019-04-15",
        "description" :"A young woman falls for a guy with a dark secret and the two embark on a rocky relationship. Based on the novel by Anna Todd",
        "director" :"Jenny Gage",
        "distribution" :"osephine Langford, Hero Fiennes Tiffin, Khadijha Red Thunder",
        "format" :"2D",
        "gendre" :"drama,romance",
        "name" :"After",
        "rating" :5.5,
        "time": "01:15"
}

{
        "age_recommandation":18,
        "cinema_date" :"2019-05-17",
        "description" :"A hopeless romantic ambivalent about his future in medical school falls for a hard-luck young woman who does not believe in love.",
        "director" :"Ry Russo-Young",
        "distribution" :"Yara Shahidi, Anais Lee, Charles Melton",
        "format" :"2D",
        "gendre" :"Drama, Romance",
        "name" :"The sun is also a star",
        "rating" :5.5,
        "time": "01:10"
}

{
	"type_name":"pensionar"
}

{
	"type_name":"student"
}

