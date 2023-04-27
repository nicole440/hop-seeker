SELECT * FROM breweries;
SELECT brewery_id, brewery_name, street_address, city, zip_code, website FROM breweries;
SELECT brewery_name, street_address, city, zip_code, website FROM breweries WHERE brewery_name = 'Mad Chef Craft Brewery';
SELECT brewery_name, street_address, city, zip_code, website FROM breweries WHERE city = 'Lancaster';
SELECT brewery_name, street_address, city, zip_code, website FROM breweries WHERE zip_code = '17602';
INSERT INTO breweries (brewery_name, street_address, city, zip_code, website) VALUES ('Test', '100 Main St', 'Ephrata', '17522', 'https://www.example.com/');

SELECT * FROM users;
INSERT INTO users (date_of_birth, username, password_hash, role) VALUES ('1990/01/01', 'admin', 'password', 'ADMIN');
INSERT INTO users (date_of_birth, username, password_hash, role) VALUES ('1990/01/01', 'nicole', 'password', 'USER');
SELECT user_id FROM users WHERE username = 'admin';

SELECT * FROM user_favorites;
INSERT INTO user_favorites (user_id, brewery_id) VALUES (2, 2);
INSERT INTO user_favorites (user_id, brewery_id) VALUES (1, 1);