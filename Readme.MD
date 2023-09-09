# Aplikácia na kontrolu vstupu do historického centra Bratislavy

---

### Funkcie aplikácie

Aplikácia slúži na:

- podávanie a poloautomatizované schvaľovanie žiadostí o vjazd do hrisotrického centra mesta
- automatizované vymáhanie daní 
- vytváranie účtu pre užívateľovov, ktorý často žiadajú o vstup
- poloautomatizovanú platenie daní
- automatizované riadenie vstupu do centra na základe EVČ auta a schválených žiadosti
- meranie a spracovanie dát znečistenia ovzdušia

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