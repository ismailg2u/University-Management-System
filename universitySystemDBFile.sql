-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost:3307
-- Üretim Zamanı: 04 Eki 2024, 14:51:19
-- Sunucu sürümü: 10.4.25-MariaDB
-- PHP Sürümü: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `universitysystem`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `course`
--

CREATE TABLE `course` (
  `ID` int(11) NOT NULL,
  `Name` varchar(200) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `Quota` int(11) DEFAULT NULL,
  `Teacher` int(11) DEFAULT NULL,
  `Department` int(11) DEFAULT NULL,
  `Faculty` int(11) DEFAULT NULL,
  `Term` int(11) DEFAULT NULL,
  `Credit` int(11) DEFAULT NULL,
  `Coursestatus` int(11) DEFAULT NULL,
  `Situation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `course`
--

INSERT INTO `course` (`ID`, `Name`, `Description`, `Quota`, `Teacher`, `Department`, `Faculty`, `Term`, `Credit`, `Coursestatus`, `Situation`) VALUES
(1, 'MAT1', 'Mathematics', 60, 1, 7, 1, 4, 18, 11, 0),
(2, 'MECH101', 'Mechanical Fundamentals', 80, 2, 8, 1, 6, 17, 12, 0),
(3, 'Structere 101', 'Fundamentals of Construction', 30, 3, 9, 3, 5, 16, 10, 0),
(4, 'PHY1', 'Physic', 100, 1, 7, 1, 4, 18, 11, 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `courseselection`
--

CREATE TABLE `courseselection` (
  `ID` int(11) NOT NULL,
  `StudentID` int(11) DEFAULT NULL,
  `CourseID` int(11) DEFAULT NULL,
  `Situation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `courseselection`
--

INSERT INTO `courseselection` (`ID`, `StudentID`, `CourseID`, `Situation`) VALUES
(1, 1, 1, 0),
(2, 2, 2, 0),
(3, 3, 3, 0),
(4, 3, 2, 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `define`
--

CREATE TABLE `define` (
  `ID` int(11) NOT NULL,
  `definetypeID` int(11) DEFAULT NULL,
  `Name` varchar(200) DEFAULT NULL,
  `Situation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `define`
--

INSERT INTO `define` (`ID`, `definetypeID`, `Name`, `Situation`) VALUES
(1, 1, 'Engineering', 0),
(2, 1, 'Tourism', 0),
(3, 1, 'Architecture', 0),
(4, 2, '2.', 0),
(5, 2, '7.', 0),
(6, 2, '4.', 0),
(7, 3, 'Computer Engineering', 0),
(8, 3, 'Mechanical Engineering', 0),
(9, 3, 'Architecture', 0),
(10, 4, 'Elective', 0),
(11, 4, 'Compulsory', 0),
(12, 4, 'Department Elective', 0),
(13, 5, 'Professor', 0),
(14, 5, 'Lecturer', 0),
(15, 5, 'Associate Professor', 0),
(16, 6, '2', 0),
(17, 6, '4', 0),
(18, 6, '5', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `definetype`
--

CREATE TABLE `definetype` (
  `ID` int(11) NOT NULL,
  `Name` varchar(200) DEFAULT NULL,
  `Situation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `definetype`
--

INSERT INTO `definetype` (`ID`, `Name`, `Situation`) VALUES
(1, 'faculty', 0),
(2, 'term', 0),
(3, 'department', 0),
(4, 'coursestatus', 0),
(5, 'title', 0),
(6, 'credit', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `student`
--

CREATE TABLE `student` (
  `ID` int(11) NOT NULL,
  `Name` varchar(200) DEFAULT NULL,
  `Surname` varchar(200) DEFAULT NULL,
  `Mail` varchar(200) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `PhoneNumber` varchar(200) DEFAULT NULL,
  `Faculty` int(11) DEFAULT NULL,
  `Department` int(11) DEFAULT NULL,
  `Situation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `student`
--

INSERT INTO `student` (`ID`, `Name`, `Surname`, `Mail`, `Address`, `PhoneNumber`, `Faculty`, `Department`, `Situation`) VALUES
(1, 'John', 'Adam', 'john@gmail.com', 'New York', '(248) 762-0356', 1, 7, 0),
(2, 'Hannah', 'Rest', 'hannah@gmail.com', 'Florida', '(262) 162-1585', 1, 8, 0),
(3, 'Fred', 'Carol', 'fred@gmail.com', 'Detroid', '(253) 644-2182', 3, 9, 0),
(4, 'Jess', 'Fringer', 'jess@gmail.com', 'Los Angeles', '(252) 258-3799', 1, 7, 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `teacher`
--

CREATE TABLE `teacher` (
  `ID` int(11) NOT NULL,
  `Name` varchar(200) DEFAULT NULL,
  `Surname` varchar(200) DEFAULT NULL,
  `Mail` varchar(200) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `PhoneNumber` varchar(200) DEFAULT NULL,
  `Faculty` int(11) DEFAULT NULL,
  `Department` int(11) DEFAULT NULL,
  `Title` int(11) DEFAULT NULL,
  `Situation` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `teacher`
--

INSERT INTO `teacher` (`ID`, `Name`, `Surname`, `Mail`, `Address`, `PhoneNumber`, `Faculty`, `Department`, `Title`, `Situation`) VALUES
(1, 'Murry', 'Denver', 'murry@gmail.com', 'Washington', '(206) 342-8631', 1, 7, 13, 0),
(2, 'Suzanne', 'Detc', 'suzanne@gmail.com', 'Florida', '(212) 658-3916', 1, 8, 14, 0),
(3, 'Ellis', 'Fury', 'ellis@gmail.com', 'Georgia', '(717) 550-1675', 3, 9, 15, 0),
(4, 'Dan', 'Seize', 'dan@gmail.com', 'Texas', '(209) 300-2557', 1, 7, 13, 1);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Department` (`Department`),
  ADD KEY `Faculty` (`Faculty`),
  ADD KEY `Term` (`Term`),
  ADD KEY `Credit` (`Credit`),
  ADD KEY `Coursestatus` (`Coursestatus`),
  ADD KEY `Teacher` (`Teacher`);

--
-- Tablo için indeksler `courseselection`
--
ALTER TABLE `courseselection`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `StudentID` (`StudentID`),
  ADD KEY `CourseID` (`CourseID`);

--
-- Tablo için indeksler `define`
--
ALTER TABLE `define`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `definetypeID` (`definetypeID`);

--
-- Tablo için indeksler `definetype`
--
ALTER TABLE `definetype`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Faculty` (`Faculty`),
  ADD KEY `Department` (`Department`);

--
-- Tablo için indeksler `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `Faculty` (`Faculty`),
  ADD KEY `Department` (`Department`),
  ADD KEY `Title` (`Title`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `course`
--
ALTER TABLE `course`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `courseselection`
--
ALTER TABLE `courseselection`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `student`
--
ALTER TABLE `student`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Tablo için AUTO_INCREMENT değeri `teacher`
--
ALTER TABLE `teacher`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `course_ibfk_3` FOREIGN KEY (`Faculty`) REFERENCES `define` (`ID`),
  ADD CONSTRAINT `course_ibfk_4` FOREIGN KEY (`Term`) REFERENCES `define` (`ID`),
  ADD CONSTRAINT `course_ibfk_5` FOREIGN KEY (`Credit`) REFERENCES `define` (`ID`),
  ADD CONSTRAINT `course_ibfk_6` FOREIGN KEY (`Coursestatus`) REFERENCES `define` (`ID`),
  ADD CONSTRAINT `course_ibfk_7` FOREIGN KEY (`Teacher`) REFERENCES `teacher` (`ID`);

--
-- Tablo kısıtlamaları `courseselection`
--
ALTER TABLE `courseselection`
  ADD CONSTRAINT `courseselection_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `student` (`ID`),
  ADD CONSTRAINT `courseselection_ibfk_2` FOREIGN KEY (`CourseID`) REFERENCES `course` (`ID`);

--
-- Tablo kısıtlamaları `define`
--
ALTER TABLE `define`
  ADD CONSTRAINT `define_ibfk_1` FOREIGN KEY (`definetypeID`) REFERENCES `definetype` (`ID`);

--
-- Tablo kısıtlamaları `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`Faculty`) REFERENCES `define` (`ID`),
  ADD CONSTRAINT `student_ibfk_2` FOREIGN KEY (`Department`) REFERENCES `define` (`ID`);

--
-- Tablo kısıtlamaları `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`Faculty`) REFERENCES `define` (`ID`),
  ADD CONSTRAINT `teacher_ibfk_2` FOREIGN KEY (`Department`) REFERENCES `define` (`ID`),
  ADD CONSTRAINT `teacher_ibfk_3` FOREIGN KEY (`Title`) REFERENCES `define` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
