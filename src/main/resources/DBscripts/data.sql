--CUENTAS HOSTING
INSERT INTO cuentaHosting (id_cuentaHosting, url, usuario, password)
VALUES (1, 'https://g.api.mega.co.nz', 'belluccifranco@gmail.com', 'mega01');

--CUENTAS USUARIO
INSERT INTO cuentaUsuario (id_cuentaUsuario, email, pin, cantidadIntentos)
VALUES (1, 'vinilo@vinilo.com', 12345678, 0);

--ARTISTAS
INSERT INTO artista (id_artista, nombre)
VALUES (1, 'AC DC');

--ALBUMES
INSERT INTO album (id_album, nombre, anio, cantCanciones, id_cuentaHosting)
VALUES (1, 'Black Ice', 2008, 15, 1);

--CANCIONES
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, url, letra, id_artista, id_album)
VALUES (1, 01, 'Rock and Roll Train', '4:21', 'https://mega.co.nz/#!AY4EkCwL!A2GGQlFV0keoyGXHYIarFCiiuUdaIua_qsNhuBQcr68', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, url, letra, id_artista, id_album)
VALUES (2, 02, 'Skies On Fire', '3:34', 'https://mega.co.nz/#!wcpwzJAZ!ClvMGB-tyqCJ7RahB67ugzqDOqMcSfQ3owgabxIL1CM', '', 1, 1);

--LISTAS DE REPRODUCCION
INSERT INTO listaReproduccion(id_listaReproduccion, nombre, id_cuentaUsuario)
VALUES (1, 'My Hard Rock playlist', 1);

INSERT INTO listaReproduccion_cancion(id_listaReproduccion, id_cancion)
VALUES (1, 1);
INSERT INTO listaReproduccion_cancion(id_listaReproduccion, id_cancion)
VALUES (1, 2);