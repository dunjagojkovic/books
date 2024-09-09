-- Kreiranje tabele za knjige (Book)
CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    number_of_pages INT,
    title VARCHAR(255) UNIQUE NOT NULL,
    publishing_date DATE
);

-- Kreiranje tabele za komentare (Comment)
CREATE TABLE comments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT,
    book_id BIGINT NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(id) ON DELETE CASCADE
);

-- Umetanje početnih podataka u tabelu Book
INSERT INTO books (number_of_pages, title, publishing_date)
VALUES
    (300, 'Prvi Roman', '2024-01-15'),
    (250, 'Drugi Roman', '2023-08-22');

-- Umetanje početnih podataka u tabelu Comment
INSERT INTO comments (content, book_id)
VALUES
    ('Ovo je sjajan roman!', 1),
    ('Vrlo interesantno štivo.', 1),
    ('Preporučujem svima!', 2);
