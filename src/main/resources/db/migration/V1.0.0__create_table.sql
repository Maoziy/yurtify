CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

-- Il
CREATE TABLE City
(
    id   UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(255) NOT NULL,
    code INT          NOT NULL
);

-- iletisim
CREATE TABLE Communication
(
    id          UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    city_id     UUID NOT NULL,
    email       VARCHAR(255),
    phone       VARCHAR(255),
    FOREIGN KEY (city_id) REFERENCES City (id) ON DELETE CASCADE
);

-- yurt
CREATE TABLE Dormitory
(
    id                UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    com_id            UUID NOT NULL,
    room_capacity     INT  NOT NULL,
    total_capacity    INT  NOT NULL,
    number_registered INT  NOT NULL,
    floor             VARCHAR(255),
    dorm_type         INT CHECK (dorm_type IN (0, 1)), --0: kız / 1: erkek
    FOREIGN KEY (com_id) REFERENCES Communication (id) ON DELETE CASCADE
);

-- yurt-photo
CREATE TABLE Dorm_photo
(
    id      UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dorm_id UUID NOT NULL,
    photo   BYTEA,
    FOREIGN KEY (dorm_id) REFERENCES Dormitory (id) ON DELETE CASCADE
);

-- yurt-detay.sql
CREATE TABLE Dorm_detail
(
    id            UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dorm_id       UUID NOT NULL,
    detail_text   TEXT NOT NULL,
    facility_text JSONB,
    FOREIGN KEY (dorm_id) REFERENCES Dormitory (id) ON DELETE CASCADE
);

-- kat.sql
CREATE TABLE Floor
(
    id              UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dorm_id         UUID NOT NULL,
    floor_number    TEXT NOT NULL,
    number_of_rooms INT  NOT NULL,
    FOREIGN KEY (dorm_id) REFERENCES Dormitory (id) ON DELETE CASCADE
);

-- Oda.sql
CREATE TABLE Room
(
    id                UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    dorm_id           UUID NOT NULL,
    floor_id          UUID NOT NULL,
    room_name         TEXT NOT NULL,
    capacity          INT  NOT NULL,
    number_of_student INT  NOT NULL,
    FOREIGN KEY (dorm_id) REFERENCES Dormitory (id) ON DELETE CASCADE,
    FOREIGN KEY (floor_id) REFERENCES Floor (id) ON DELETE CASCADE
);

-- student.sql
CREATE TABLE Student
(
    id      UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    room_id UUID NOT NULL,
    name    TEXT NOT NULL,
    phone   INT  NOT NULL,
    gender  INT CHECK (gender IN (0, 1)), --0: kız / 1: erkek,
    FOREIGN KEY (room_id) REFERENCES Room (id) ON DELETE CASCADE
);

-- yurt-photo
CREATE TABLE Student_photo
(
    id         UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    student_id UUID NOT NULL,
    photo      BYTEA,
    FOREIGN KEY (student_id) REFERENCES Student (id) ON DELETE CASCADE
);

-- City Tablosu: Türkiye'deki bazı iller
INSERT INTO City (name, code)
VALUES ('İstanbul', 34);
INSERT INTO City (name, code)
VALUES ('Ankara', 6);
INSERT INTO City (name, code)
VALUES ('İzmir', 35);
INSERT INTO City (name, code)
VALUES ('Antalya', 7);
INSERT INTO City (name, code)
VALUES ('Bursa', 16);
INSERT INTO City (name, code)
VALUES ('Adana', 1);
INSERT INTO City (name, code)
VALUES ('Gaziantep', 27);
INSERT INTO City (name, code)
VALUES ('Konya', 42);
INSERT INTO City (name, code)
VALUES ('Mersin', 33);
INSERT INTO City (name, code)
VALUES ('Samsun', 55);

-- District Tablosu: Türkiye'deki bazı illere ait ilçeler
/*INSERT INTO District (name, city_id) VALUES ('Kadıköy', 1);  -- İstanbul
INSERT INTO District (name, city_id) VALUES ('Beşiktaş', 1);  -- İstanbul
INSERT INTO District (name, city_id) VALUES ('Çankaya', 2);    -- Ankara
INSERT INTO District (name, city_id) VALUES ('Kocatepe', 2);   -- Ankara
INSERT INTO District (name, city_id) VALUES ('Konak', 3);     -- İzmir
INSERT INTO District (name, city_id) VALUES ('Karşıyaka', 3); -- İzmir
INSERT INTO District (name, city_id) VALUES ('Muratpaşa', 4);  -- Antalya
INSERT INTO District (name, city_id) VALUES ('Kepez', 4);      -- Antalya
INSERT INTO District (name, city_id) VALUES ('Osmangazi', 5); -- Bursa
INSERT INTO District (name, city_id) VALUES ('Nilüfer', 5);   -- Bursa
INSERT INTO District (name, city_id) VALUES ('Seyhan', 6);     -- Adana
INSERT INTO District (name, city_id) VALUES ('Yüreğir', 6);    -- Adana
INSERT INTO District (name, city_id) VALUES ('Şahinbey', 7);  -- Gaziantep
INSERT INTO District (name, city_id) VALUES ('Oğuzeli', 7);   -- Gaziantep
INSERT INTO District (name, city_id) VALUES ('Meram', 8);     -- Konya
INSERT INTO District (name, city_id) VALUES ('Selçuklu', 8);  -- Konya
INSERT INTO District (name, city_id) VALUES ('Akdeniz', 9);   -- Mersin
INSERT INTO District (name, city_id) VALUES ('Tarsus', 9);    -- Mersin
INSERT INTO District (name, city_id) VALUES ('Atakum', 10);    -- Samsun
INSERT INTO District (name, city_id) VALUES ('Canik', 10);*/