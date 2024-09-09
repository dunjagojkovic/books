-- Umetanje početnih podataka u tabelu Book
INSERT INTO Book (numberOfPages, title, publishingDate) VALUES
(300, 'The Great Gatsby', '1925-04-10'),
(250, 'To Kill a Mockingbird', '1960-07-11'),
(500, '1984', '1949-06-08');

-- Umetanje početnih podataka u tabelu Comment
-- Prvo moramo da osiguramo da se 'book_id' odnosi na postojeće 'id' u tabeli Book

-- Preuzimanje ID-ova knjiga
SET @book1_id = (SELECT id FROM Book WHERE title = 'The Great Gatsby');
SET @book2_id = (SELECT id FROM Book WHERE title = 'To Kill a Mockingbird');
SET @book3_id = (SELECT id FROM Book WHERE title = '1984');

-- Umetanje komentara
INSERT INTO Comment (content, book_id) VALUES
('A fascinating look into the Jazz Age.', @book1_id),
('A powerful and moving novel about racial injustice.', @book2_id),
('A chilling depiction of a dystopian future.', @book3_id),
('An essential read for understanding 20th-century literature.', @book1_id);

CREATE INDEX idx_book_title ON Book(title);
