# Title
Hotel Search Test
# Wprowadzenie
Celem tego projektu jest przeprowadzenie testu wyszukiwania hoteli w danym mieście na stronie internetowej: [http://www.kurs-selenium.pl/demo/ ](http://www.kurs-selenium.pl/demo/) 
Test znajduję i uzupełnia dane wyszukiwania, a następnie pobiera otrzymane wyniki i porównuje je z oczekiwanymi. 
Projekt powstał w ramach utrwalenie zakresu materiału z kursu online.
# Technologies
Project is created with:
1. Java version 13.0.1
2. Apache Maven version 3.6.2
3. Selenium version 3.141.59
# Features
1. Wait for webelements
2. Use asserts
3. Takes screenshot after the test 
# State of project
Projekt spełnia podstawowe założenia. 
Możliwości rozwoju:
W przypadku nie wprowadzenia wymaganych danych do wyszukiwarki, sprawdzenie czy została wywolana informacji na stronie o koniecznosci uzupełnienia pola. 
czytanie danych z pliku zewnętrznego
robienie zrzutów ekranu w momencie gdy test failures
# Sources
This project is inspired by Udemy: "Kurs Selenium Java od podstaw"
[https://www.udemy.com/course/kurs-selenium-java](https://www.udemy.com/course/kurs-selenium-java)
# Classes
### BaseClassTest
Zawiera adnotacje @BeforeClass i @AfterClass, oraz inicjuje driver.
1. @BeforeClass zawiera metodę setUp, która ustawia sterownik Chromedriver w projekcie oraz otwiera i maksymalizuje okno przeglądarki Chrome.
2. @AfterClass zawiera metode tearDown, która po ukończonym teście zamyka okno
### HomePage
Wykorzystuje adnotacje @FindBy do znalezienia elementów na stronie i mapuje je do zmiennych w programie. Np. pole do wprowadzenia nazwy miasta.
Zawiera metody dzięki którym test znajduję i uzupełnia pola. Np. znalezienie i uzupełnienie nazwy miasta w polu na stronie.
### ResultPage
Zawiera metody zwracające nazwy wyszukanych hoteli oraz ich ceny. 
### HotelSearchTest
Klasa dziedziczy po klasie BaseClassTest i jest klasą wywołującą test. 
Tworzy ona obiekty klas HomePage i ResultPage. 
Wykorzystuje obiekt driver zainicjowany w klasie BaseClassTest do wprowadzenia adresu URL
Wywołuje metody na obiekcie homePage klasy HomePage do uzupełnienia wymaganych pól.
Za pomocą asercji sprawdza:
1. Tytuł wyszukanej strony
2. Nazwy hoteli z ich cenami, oraz porównuje je do oczekiwanych danych.
