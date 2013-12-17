--CUENTAS HOSTING
INSERT INTO cuentaHosting (id_cuentaHosting, url, usuario, password)
VALUES (1, 'https://g.api.mega.co.nz', 'cuentavinilo01@gmail.com', 'Ninguna01');

--CUENTAS USUARIO
INSERT INTO cuentaUsuario (id_cuentaUsuario, nombreUsuario, contrasenia)
VALUES (1, 'customer@vinilo.com', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO cuentaUsuario (id_cuentaUsuario, nombreUsuario, contrasenia)
VALUES (2, 'admin@vinilo.com', 'e10adc3949ba59abbe56e057f20f883e');

--ROLES
INSERT INTO rol (id_rol, rol)
VALUES (1, 'ROLE_CUSTOMER');
INSERT INTO rol (id_rol, rol)
VALUES (2, 'ROLE_ADMIN');

--CUENTAS USUARIO <> ROLES
INSERT INTO cuentaUsuario_rol (id_cuentaUsuario, id_rol)
VALUES (1, 1);
INSERT INTO cuentaUsuario_rol (id_cuentaUsuario, id_rol)
VALUES (2, 2);

--ARTISTAS
INSERT INTO artista (id_artista, nombre)
VALUES (1, 'AC DC');

--ALBUMES
INSERT INTO album (id_album, nombre, anio, cantCanciones)
VALUES (1, 'Highway to Hell', 1979, 10);

--CANCIONES
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (1, 01, 'Highway to Hell', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (2, 02, 'Girls Got Rhythm', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (3, 03, 'Walk All Over You', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (4, 04, 'Touch Too Much', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (5, 05, 'Beating Around The Bush', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (6, 06, 'Shot Down in Flames', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (7, 07, 'Get it Hot', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (8, 08, 'If You Want Blood (You ve Got It)', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (9, 09, 'Love Hungry Man', '', '', 1, 1);
INSERT INTO cancion (id_cancion, nroOrden, nombre, duracion, letra, id_artista, id_album)
VALUES (10, 10, 'Night Prowler', '', '', 1, 1);

--LINKS
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (1, 'https://mega.co.nz/#!ilhghR7D!bXAvBGk_Z-7nFWZeHr0meC5Ce_4yFqHF38AnVmO7gew', 1, 1);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (2, 'https://mega.co.nz/#!ipQ1HabR!eFikkFla4rIOqPpCJVgxlCSNaRoQGCadYk17qgBrFFY', 1, 2);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (3, 'https://mega.co.nz/#!u05HDKSC!DauTn0lUVaUOjauoxXXqpk5Y4qYi3wVCA46XLZbontk', 1, 3);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (4, 'https://mega.co.nz/#!yhATDbxL!Ujkb-jqdxc_r5RxNOVls-0Upik15bIiPp_W36hI6uO4', 1, 4);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (5, 'https://mega.co.nz/#!DhRw1IjJ!aA30wnfpF7Z97DRRnZrSRHq51VpWoVI1UCj45YH-j4w', 1, 5);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (6, 'https://mega.co.nz/#!n8AzSLSb!XJOUBCWK9K6Tux9W6JM_GGTswUQVuutzo2Fb8L2TGpw', 1, 6);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (7, 'https://mega.co.nz/#!HshkSBrL!LbhwQz1kgPTSA8i-85rGmBVdEUwJwFIh-isoa7-JYW8', 1, 7);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (8, 'https://mega.co.nz/#!esYkBQbQ!FdxakAVWP6A5sHWb4DOCj01i31UPkyMKV0by9Pb6Hps', 1, 8);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (9, 'https://mega.co.nz/#!XghGjAYB!HMKf-Vt3hB9WICSa0Tak7Xxywo5TsX2FF8NMI8mo7Dk', 1, 9);
INSERT INTO link (id_link, url, id_cuentaHosting, id_cancion)
VALUES (10, 'https://mega.co.nz/#!Tw4B0ZjL!WThKG0EqXIvrLeyzWVMT6ia_m1pec3NA18yeTnyBD1A', 1, 10);
