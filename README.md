# TicketGuru

Tiimi: KKVVR Solutions eli Salla Komppa, Katariina Kuismin, Perttu Virkki, Joona Virolainen & Jenna Räihä

## Johdanto

Projektin asiakas on lipunmyyntitoimisto, jolle tehtävänämme on luoda lipunmyyntijärjestelmä nimeltään TicketGuru, jonka kautta toimisto voi myydä lippuja myyntipisteessään ja määritellä lipunmyyntiin sisältyvät tapahtumat. Lipunmyyntipisteen tehtävänä on myydä ja tulostaa asiakkaan liput sekä ennakkomyynnin päätyttyä tulostaa loput vapaat liput ovella myytäviksi. Kaikki liput sisältävät selkeän koodin, jonka avulla lippu merkitään käytetyksi. 

Asiakas haluaa lippujen myynnistä vaivatonta ja järjestelmän, josta lippujen saldot (myydyt/jäljellä olevat) ovat helposti seurattavissa olevia. Back end -ohjelmiston toteutamme Spring Boot -projektina, jonne lisäämme toiminnallisuutta (CRUD) muun muassa tukeutuen asiakkaan toimittamiin rautalankamalleihin. Tietokantajärjestelmänä toimii SQL. Tarkoituksena on kehittää kokonaisuus, joka toimii kaikilla päätelaitteilla myyntipisteessä. Verkkokaupan laajentaminen asiakaskäyttöön on mainittu vain jatkokehityksenä, joten käyttöliittymään liittyvä ohjelmistokehitys eli front end osuus ei meidän projektiimme kuulu.

## Järjestelmän määrittely

### Käyttäjäryhmät

* Tapahtumavastaava = Liiketoiminnan pyörittäjä
* Myyjä = Lipputoimiston myyntipisteen työntekijä
* Lipuntarkastaja = Tapahtumissa työskentelevä lipuntarkastaja
* Asiakas = Lipputoimistolta lippuja ostava kuluttaja

### Käyttäjätarinat

* Tapahtumavastaavana haluan luoda uusia tapahtumia järjestelmään, jotta niiden liput saadaan myyntiin.

* Tapahtumavastaavana haluan pystyä määrittämään eri ikäluokkien lipuille omat hintansa, jotta voimme tarjota reilut hinnat eri elmänätilanteissa oleville asiakkaillemme.

* Tapahtumavastaavana haluan muokata tapahtuman tietoja ja lippujen hintoja, jotta muutosten tai alennusten tekeminen on mahdollista.

* Tapahtumavastaavana haluan tarkastella yksittäisen tapahtuman myyntiraporttia, jotta voin tarkastella tapahtuman kannattavuutta.

* Tapahtumavastaavana haluan listata kaikki myyntitapahtumat tietoineen, jotta voin kirjata tiedot kirjanpitoa varten.

* Myyjänä haluan nähdä kaikki myynnissä olevat tapahtumat, jotta voin myydä liput asiakkaan haluamaan tapahtumaan.

* Myyjänä haluan myydä useamman lipun kerrallaan eri asiakasryhmistä, jotta asiakaspalvelu on sujuvampaa.

* Myyjänä haluan nähdä myymättä jääneet ennakkoliput, jotta voin tulostaa ne ovella myytäväksi.

* Myyjänä haluan, että myyntitapahtumille muodostuu oma tunnisteensa, jotta virhetilanteiden selvitys helpottuuu.

* Lipuntarkastajana haluan, että lipuilla on omat tunnistekoodinsa, jotta niiden tarkistaminen ovella on helpompaa.

## Käyttöliittymä

Esitetään käyttöliittymän tärkeimmät (vain ne!) näkymät sekä niiden väliset siirtymät käyttöliittymäkaaviona. 

Jos näkymän tarkoitus ei ole itsestään selvä, se pitää kuvata lyhyesti.

