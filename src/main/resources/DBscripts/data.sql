--HOSTING ACCOUNTS
INSERT INTO hostingAccount (id_hostingAccount, url, username, password)
VALUES (1, 'https://g.api.mega.co.nz', 'cuentavinilo01@gmail.com', 'Ninguna01');

--USER ACCOUNTS
INSERT INTO userAccount (id_userAccount, username, password)
VALUES (1, 'customer@vinilo.com', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO userAccount (id_userAccount, username, password)
VALUES (2, 'admin@vinilo.com', 'e10adc3949ba59abbe56e057f20f883e');

--USER ROLES
INSERT INTO userRole (id_userRole, name)
VALUES (1, 'ROLE_CUSTOMER');
INSERT INTO userRole (id_userRole, name)
VALUES (2, 'ROLE_ADMIN');

--USER ACCOUNTS <> USER ROLES
INSERT INTO userAccount_userRole (id_userAccount, id_userRole)
VALUES (1, 1);
INSERT INTO userAccount_userRole (id_userAccount, id_userRole)
VALUES (2, 2);

--ARTISTS
INSERT INTO artist (id_artist, name)
VALUES (1, 'AC DC');
INSERT INTO artist (id_artist, name)
VALUES (2, 'Led Zeppelin');

--ALBUMS
INSERT INTO album (id_album, name, releaseYear, numberOfSongs)
VALUES (1, 'Highway to Hell', 1979, 10);
INSERT INTO album (id_album, name, releaseYear, numberOfSongs)
VALUES (2, 'Presense', 1976, 7);

--SONGS
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (1, 01, 'Highway to Hell', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (2, 02, 'Girls Got Rhythm', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (3, 03, 'Walk All Over You', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (4, 04, 'Touch Too Much', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (5, 05, 'Beating Around The Bush', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (6, 06, 'Shot Down in Flames', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (7, 07, 'Get it Hot', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (8, 08, 'If You Want Blood (You ve Got It)', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (9, 09, 'Love Hungry Man', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (10, 10, 'Night Prowler', '', '', 1, 1);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (11, 01, 'Achilles Last Stand', '', '', 2, 2);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (12, 02, 'For Your Life', '', '', 2, 2);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (13, 03, 'Royal Orleans', '', '', 2, 2);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (14, 04, 'Nobodys Fault But Mine', '', '', 2, 2);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (15, 05, 'Candy Store Rock', '', '', 2, 2);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (16, 06, 'Hots On For Nowhere', '', '', 2, 2);
INSERT INTO song (id_song, track, name, duration, lyric, id_artist, id_album)
VALUES (17, 07, 'Tea For One', '', '', 2, 2);

--LINKS
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (1, 'https://mega.co.nz/#!ilhghR7D!bXAvBGk_Z-7nFWZeHr0meC5Ce_4yFqHF38AnVmO7gew', 1, 1);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (2, 'https://mega.co.nz/#!ipQ1HabR!eFikkFla4rIOqPpCJVgxlCSNaRoQGCadYk17qgBrFFY', 1, 2);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (3, 'https://mega.co.nz/#!u05HDKSC!DauTn0lUVaUOjauoxXXqpk5Y4qYi3wVCA46XLZbontk', 1, 3);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (4, 'https://mega.co.nz/#!yhATDbxL!Ujkb-jqdxc_r5RxNOVls-0Upik15bIiPp_W36hI6uO4', 1, 4);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (5, 'https://mega.co.nz/#!DhRw1IjJ!aA30wnfpF7Z97DRRnZrSRHq51VpWoVI1UCj45YH-j4w', 1, 5);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (6, 'https://mega.co.nz/#!n8AzSLSb!XJOUBCWK9K6Tux9W6JM_GGTswUQVuutzo2Fb8L2TGpw', 1, 6);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (7, 'https://mega.co.nz/#!HshkSBrL!LbhwQz1kgPTSA8i-85rGmBVdEUwJwFIh-isoa7-JYW8', 1, 7);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (8, 'https://mega.co.nz/#!esYkBQbQ!FdxakAVWP6A5sHWb4DOCj01i31UPkyMKV0by9Pb6Hps', 1, 8);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (9, 'https://mega.co.nz/#!XghGjAYB!HMKf-Vt3hB9WICSa0Tak7Xxywo5TsX2FF8NMI8mo7Dk', 1, 9);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (10, 'https://mega.co.nz/#!Tw4B0ZjL!WThKG0EqXIvrLeyzWVMT6ia_m1pec3NA18yeTnyBD1A', 1, 10);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (11, 'https://mega.co.nz/#!OkxT2CQQ!VNGQzxRoTqbVLSGhnrTxjVVX_C1NHHJhjHgDwtzeUx0', 1, 11);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (12, 'https://mega.co.nz/#!Osw2WTwD!fl6NTE1LbX7yq20hoLW9d1naZKt3g6ta6O_oucXNVTg', 1, 12);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (13, 'https://mega.co.nz/#!20gSAAqa!ZwJG4QRJKJ75GLiueYfATivpz_laKt2Z2LMWQX2esH8', 1, 13);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (14, 'https://mega.co.nz/#!v8wCXSIb!fdgHRHilmQW1olzTxZkiLlwkMsIyGZyKz3SwSpOnC8Q', 1, 14);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (15, 'https://mega.co.nz/#!614k1BSQ!GzwglVZX0lO99bnl5IQcRArpwCVTYMnn7GERSJgNCyI', 1, 15);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (16, 'https://mega.co.nz/#!TtpwiYIT!X9dvM0nA5XBI4nOlObLBOW_vKK52WsFJFG34WT6sSDY', 1, 16);
INSERT INTO link (id_link, url, id_hostingAccount, id_song)
VALUES (17, 'https://mega.co.nz/#!e95BlaID!aHdUkANGbgrHpi8eXk_gMUytaDMttmb3o52gwHLiXHU', 1, 17);
