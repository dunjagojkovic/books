// Prebacivanje na bazu podataka
db = db.getSiblingDB("book");

// Kreiranje korisnika
db.createUser({
    user: "book",
    pwd: "book",
    roles: [
      {
        role: 'readWrite',
        db: 'book'
      },
    ],
  });

// Kreiranje kolekcije
db.createCollection("books");
db.createCollection("comments");

db.books.createIndex({ "title": 1 }, { unique: true });


