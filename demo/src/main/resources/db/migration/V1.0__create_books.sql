-- Kreiranje tabele za knjige (Book)
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number_of_pages INT,
    title VARCHAR(255) UNIQUE NOT NULL,
    publishing_date DATE
);
