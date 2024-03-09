SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS genres;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE genres
(
	id char(26) NOT NULL,
	genre_name VARCHAR(20) NOT NULL,
	created_at DATETIME NOT NULL,
	created_by VARCHAR(20) NOT NULL,
	updated_at DATETIME NOT NULL,
	updated_by VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO genres (id, genre_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHCYKWF3Z9N68A94XNNSX', 'FPS', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO genres (id, genre_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHCZ11MGM5S5GG7QV3BBE', 'RPG', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO genres (id, genre_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD1R5GRKMS9NK1FVV4NS', 'ARPG', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO genres (id, genre_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD2CYQX8YSPGH81B0YS6', 'Action', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO genres (id, genre_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD37F1PABFFCQ5XJAXYB', 'Horror', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO genres (id, genre_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3GCEC7AYN3NY8N65DG', 'Party', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS games;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE games
(
	id char(26) NOT NULL,
	game_name VARCHAR(20) NOT NULL,
	genre_id char(26) NOT NULL,
	price int(10) NOT NULL,
	created_at DATETIME NOT NULL,
	created_by VARCHAR(20) NOT NULL,
	updated_at DATETIME NOT NULL,
	updated_by VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(genre_id) REFERENCES genres(id)
);

INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK6ZVBFPQWYWP9N7TDAY', 'R6E', '01F9SNHCYKWF3Z9N68A94XNNSX', 6600, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK78J1MTEFQJTCJ4M57Y', 'Apex', '01F9SNHCYKWF3Z9N68A94XNNSX', 0, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK7DQBJPT3G9X6FV0Q56', 'Tarcov', '01F9SNHCYKWF3Z9N68A94XNNSX', 14500, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK7KYWBDPZQ7MKZ2QEN7', 'WITCHER3', '01F9SNHD1R5GRKMS9NK1FVV4NS', 6300, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK7QNQ96FEJ3Q56WY1RK', 'Spider-Man MM', '01F9SNHD1R5GRKMS9NK1FVV4NS', 6500, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK7S9EYM1H9X5YFMRC8N', 'BIOHAZARD8', '01F9SNHD37F1PABFFCQ5XJAXYB', 7200, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK81YX72K3C0JPW7VE00', 'POKEMON', '01F9SNHCZ11MGM5S5GG7QV3BBE', 6600, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK86G7YV4BHKWAG3SFBM', 'Bomberman', '01F9SNHD2CYQX8YSPGH81B0YS6', 1200, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK8B3ENMGVA8ME3XY6CP', 'DARKSOULS', '01F9SNHD1R5GRKMS9NK1FVV4NS', 4200, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO games (id, game_name, genre_id, price, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNDK8EZ8RSM7TEBQKQ9F0Y', 'Among Us', '01F9SNHD3GCEC7AYN3NY8N65DG', 0, '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS platforms;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE platforms
(
	id char(26) NOT NULL,
	platform_name VARCHAR(20) NOT NULL,
	created_at DATETIME NOT NULL,
	created_by VARCHAR(20) NOT NULL,
	updated_at DATETIME NOT NULL,
	updated_by VARCHAR(20) NOT NULL,
	PRIMARY KEY(id)
);

INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3GY8E0RNHDY1T5PMTV', 'PS4', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3H63J5NW9KYK56QZ0Y', 'PS5', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3HRY9YDTEA9D66WJ7D', 'Switch', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3J0YSE5FHXG0BYTF05', 'Steam', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3JB8SSTWXXNDD9A2NT', 'Origin', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3KPCB6E1DNWNN22Q54', 'UBI', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3LH2QFBZ0DG34G9H0T', 'iOS', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');
INSERT INTO platforms (id, platform_name, created_at, created_by, updated_at, updated_by) VALUES ('01F9SNHD3NRYA9HWEXR7Q44MP1', 'Battlestate Games', '2024-03-08 12:30:30', 'API', '2024-03-08 12:30:30', 'API');

DROP TABLE IF EXISTS games_platforms;

CREATE TABLE games_platforms
(
	id int unsigned AUTO_INCREMENT,
	game_id char(26) NOT NULL,
	platform_id char(26) NOT NULL,
	PRIMARY KEY(id),
	FOREIGN KEY(game_id) REFERENCES games(id),
	FOREIGN KEY(platform_id) REFERENCES platforms(id)
);

INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK6ZVBFPQWYWP9N7TDAY', '01F9SNHD3KPCB6E1DNWNN22Q54');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK78J1MTEFQJTCJ4M57Y', '01F9SNHD3J0YSE5FHXG0BYTF05');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK7DQBJPT3G9X6FV0Q56', '01F9SNHD3NRYA9HWEXR7Q44MP1');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK7KYWBDPZQ7MKZ2QEN7', '01F9SNHD3JB8SSTWXXNDD9A2NT');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK7KYWBDPZQ7MKZ2QEN7', '01F9SNHD3GY8E0RNHDY1T5PMTV');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK7KYWBDPZQ7MKZ2QEN7', '01F9SNHD3HRY9YDTEA9D66WJ7D');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK7KYWBDPZQ7MKZ2QEN7', '01F9SNHD3J0YSE5FHXG0BYTF05');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK7QNQ96FEJ3Q56WY1RK', '01F9SNHD3H63J5NW9KYK56QZ0Y');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK7S9EYM1H9X5YFMRC8N', '01F9SNHD3H63J5NW9KYK56QZ0Y');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK81YX72K3C0JPW7VE00', '01F9SNHD3HRY9YDTEA9D66WJ7D');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK86G7YV4BHKWAG3SFBM', '01F9SNHD3HRY9YDTEA9D66WJ7D');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK8B3ENMGVA8ME3XY6CP', '01F9SNHD3GY8E0RNHDY1T5PMTV');
INSERT INTO games_platforms (game_id, platform_id) VALUES ('01F9SNDK8EZ8RSM7TEBQKQ9F0Y', '01F9SNHD3LH2QFBZ0DG34G9H0T');
