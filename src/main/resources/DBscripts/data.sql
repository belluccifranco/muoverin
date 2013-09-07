INSERT INTO cuentaHosting (id_cuentaHosting, url, usuario, password)
VALUES (1, 'https://g.api.mega.co.nz', 'belluccifranco@gmail.com', 'mega01');

INSERT INTO artista (id_artista, nombre)
VALUES (1, 'AC DC');

INSERT INTO album (id_album, nombre, anio, cantCanciones, id_cuentaHosting)
VALUES (1, 'Black Ice', 2008, 15, 1);

INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, url, letra, id_artista, id_album)
VALUES (1, 01, 'Rock and Roll Train', '4:21', 'https://mega.co.nz/#!AY4EkCwL!A2GGQlFV0keoyGXHYIarFCiiuUdaIua_qsNhuBQcr68', '', 1, 1);

INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, url, letra, id_artista, id_album)
VALUES (2, 02, 'Skies On Fire', '3:34', 'https://mega.co.nz/#!wcpwzJAZ!ClvMGB-tyqCJ7RahB67ugzqDOqMcSfQ3owgabxIL1CM', '', 1, 1);
