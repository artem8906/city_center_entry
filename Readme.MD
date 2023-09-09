# Aplikácia na kontrolu vstupu do historického centra Bratislavy

---

### Funkcie aplikácie

Aplikácia slúži na:

- podávanie a poloautomatizované schvaľovanie žiadostí o vjazd do hrisotrického centra mesta
- automatizované vytvorenie daní
- vytváranie účtu pre užívateľovov, ktorý často žiadajú o vstup
- poloautomatizovanú platenie daní
- automatizované riadenie vstupu do centra na základe EVČ auta a schválených žiadosti
- meranie a spracovanie dát znečistenia ovzdušia
- zhromažďovanie a reprezentovanie údajov o vstupoch do centra mesta (kedy a ako dlho bolo auto v centre, aké vjazdy/výjazdy sa použili, 
  ako často jazdí auto do centra, ktoré adresy su najčastejšie/najmenej využívane a mnoho ďalších) pre ďalšiu analýzu

---

### Spustenie aplikácie

Na spustenie aplikácie potrebujeme javu 17 a maven.
Aplíkiciu spustíme, tak, že po stiahnutí vôjdeme do hlavného priečinka a v command line spustíme 2 príkazy:

- mvn clean install
- mvn spring-boot:run

Do hlavného okna aplikácie sa dostaneme tak, že otvoríme webový prehliadač a zadáme: localhost:8080.

--- 

### User interface

V aplíkácii sú 2 rôzne User Interface pre správcu a žiadateľa. Každý má vlastné prihlásenia.


### Endpoints
http://localhost:8080/api/entries - všetky vstupy všetkych aut
http://localhost:8080/api/allowedCars - všetky povoleny na vstup auta

### Tech stack
Privátny cloud je ideálnym miestom na spustenie týchto aplikácií. Databáza ako služba (DAAS) znižuje výdavky a zároveň zvyšuje bezpečnosť. 
Pre externé pripojenia používa Gateway, znižuje prevádzku a znižuje nedostupnosť na nulu a môže škálovať in/out podľa počtu požiadaviek používateľov.
Aplikácia využíva externú službu na rozpoznávanie ŠPZ. Stojí to 50-150 USD mesačne.

Java 17
Spring Boot Framework
Build tool - Maven
Recommended Database solution - RDS (any cloud vendor)
Gateway API (any cloud vendor)
