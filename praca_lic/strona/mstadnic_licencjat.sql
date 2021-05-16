-- phpMyAdmin SQL Dump
-- version 4.6.6deb4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Czas generowania: 05 Lip 2019, 16:44
-- Wersja serwera: 10.1.37-MariaDB-0+deb9u1
-- Wersja PHP: 5.6.30-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `mstadnic_licencjat`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `ambony`
--

CREATE TABLE `ambony` (
  `id_ambony` int(11) NOT NULL,
  `ambona` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `id_rewiru` int(11) NOT NULL,
  `opis` varchar(500) COLLATE utf8_polish_ci DEFAULT NULL,
  `typ` varchar(255) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `ambony`
--

INSERT INTO `ambony` (`id_ambony`, `ambona`, `id_rewiru`, `opis`, `typ`) VALUES
(1, 'Drabina1', 1, '', ''),
(2, 'Ambona1', 1, '', ''),
(3, 'Ambona2', 1, '', ''),
(4, 'Ambona3', 1, '', ''),
(5, 'Ambona4', 1, '', ''),
(6, 'Ambona5', 2, '', ''),
(7, 'Ambona6', 2, '', ''),
(8, 'Drabina2', 2, '', ''),
(9, 'Ambona7', 2, '', ''),
(10, 'Drabina3', 2, '', ''),
(11, 'Drabina4', 2, '', ''),
(12, 'Drabina5', 2, '', ''),
(13, 'Drabina6', 2, '', ''),
(14, 'Drabina7', 3, '', ''),
(15, 'Ambona8', 3, '', ''),
(16, 'Ambona9', 3, '', ''),
(17, 'Drabina8', 4, '', ''),
(18, 'Drabina9', 3, '', ''),
(19, 'Drabina10', 3, '', ''),
(20, 'Ambona10', 3, '', ''),
(21, 'Ambona11', 3, '', ''),
(22, 'Drabina11', 3, '', ''),
(23, 'Drabina12', 5, '', ''),
(24, 'Drabina13', 5, '', ''),
(25, 'Drabina14', 5, '', ''),
(26, 'Ambona12', 5, '', ''),
(27, 'Drabina15', 5, '', ''),
(28, 'Drabina16', 5, '', '');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `rewiry`
--

CREATE TABLE `rewiry` (
  `id_rewiru` int(11) NOT NULL,
  `rewir` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `granice` varchar(1500) COLLATE utf8_polish_ci DEFAULT NULL,
  `opis` varchar(500) COLLATE utf8_polish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `rewiry`
--

INSERT INTO `rewiry` (`id_rewiru`, `rewir`, `granice`, `opis`) VALUES
(1, 'Pola Wóleckie', '', ''),
(2, 'Wnęka Duża', '', ''),
(3, 'Wnęka Mała', '', ''),
(4, 'Pola Ćmiłów', '', ''),
(5, 'Przerwa', '', ''),
(6, 'Pola Mętów', '', ''),
(7, 'Łąki', '', ''),
(8, 'Polanówka', '', '');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `usterki`
--

CREATE TABLE `usterki` (
  `id_usterki` int(11) NOT NULL,
  `imie` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `nazwisko` varchar(50) COLLATE utf8_polish_ci NOT NULL,
  `id_ambony` int(11) NOT NULL,
  `opis_usterki` text COLLATE utf8_polish_ci NOT NULL,
  `id_uzytk` int(11) NOT NULL,
  `data_zgloszenia` date NOT NULL,
  `naprawiona` char(1) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `usterki`
--

INSERT INTO `usterki` (`id_usterki`, `imie`, `nazwisko`, `id_ambony`, `opis_usterki`, `id_uzytk`, `data_zgloszenia`, `naprawiona`) VALUES
(1, 'Mateusz', 'Stadnicki', 2, 'Drabina wymaga naprawy.', 1, '2019-06-07', 'T'),
(2, 'Adam ', 'Nowak', 11, 'Pęknięta drabina, stare deski', 1, '2019-06-07', 'N'),
(3, 'Norbert', 'Baś', 18, 'Zarośnięty dojazd, trzeba wykosić', 1, '2019-06-07', 'T'),
(6, 'xcv', 'vcx', 10, 'xcv', 1, '2019-06-30', 'N');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `id_uzytk` int(11) NOT NULL,
  `user` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `pass` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`id_uzytk`, `user`, `pass`, `email`) VALUES
(1, 'Barti', '$2y$10$r9Be/TTlTABWRQ9pLVmctOc', 'm.stadnick97@gmail.com'),
(3, 'aaa', '$2y$10$VloMhpfBI9Rxc83jeaahu.J', 'aa@aa.aa');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `ambony`
--
ALTER TABLE `ambony`
  ADD PRIMARY KEY (`id_ambony`),
  ADD KEY `fk_ambony_rewiry` (`id_rewiru`);

--
-- Indexes for table `rewiry`
--
ALTER TABLE `rewiry`
  ADD PRIMARY KEY (`id_rewiru`),
  ADD KEY `rewir` (`rewir`);

--
-- Indexes for table `usterki`
--
ALTER TABLE `usterki`
  ADD PRIMARY KEY (`id_usterki`),
  ADD KEY `id_uzytk` (`id_uzytk`),
  ADD KEY `id_ambony` (`id_ambony`);

--
-- Indexes for table `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  ADD PRIMARY KEY (`id_uzytk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `ambony`
--
ALTER TABLE `ambony`
  MODIFY `id_ambony` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT dla tabeli `usterki`
--
ALTER TABLE `usterki`
  MODIFY `id_usterki` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT dla tabeli `uzytkownicy`
--
ALTER TABLE `uzytkownicy`
  MODIFY `id_uzytk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `ambony`
--
ALTER TABLE `ambony`
  ADD CONSTRAINT `fk_ambony_rewiry` FOREIGN KEY (`id_rewiru`) REFERENCES `rewiry` (`id_rewiru`);

--
-- Ograniczenia dla tabeli `usterki`
--
ALTER TABLE `usterki`
  ADD CONSTRAINT `ft_usterki_ambony` FOREIGN KEY (`id_ambony`) REFERENCES `ambony` (`id_ambony`),
  ADD CONSTRAINT `ft_usterki_uzytkownicy` FOREIGN KEY (`id_uzytk`) REFERENCES `uzytkownicy` (`id_uzytk`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
