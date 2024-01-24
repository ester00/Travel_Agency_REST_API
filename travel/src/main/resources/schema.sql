CREATE TABLE IF NOT EXISTS location (id SERIAL PRIMARY KEY,
    street VARCHAR(255),
    number VARCHAR(255),
    city VARCHAR(255),
    country VARCHAR(255));

CREATE TABLE IF NOT EXISTS holiday (
    id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    startDate DATE NOT NULL,
    duration INTEGER NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    freeSlots INTEGER NOT NULL,
    location_id INTEGER,
    FOREIGN KEY (location_id) REFERENCES location(id)
);

CREATE TABLE IF NOT EXISTS reservation (
    id SERIAL PRIMARY KEY,
    contactName VARCHAR(255) NOT NULL,
    phoneNumber VARCHAR(255) NOT NULL,
    holiday_id INTEGER,
    FOREIGN KEY (holiday_id) REFERENCES holiday(id)
);
