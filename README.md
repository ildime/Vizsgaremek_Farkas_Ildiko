# Vizsgaremek_Farkas_Ildiko

A felület tesztelés tárgya a   https://skinsmart.hu/   weboldal.

A manuális tesztek dokumentációja a         oldalon található meg.

A generált tesztjelentés a   https://ildime.github.io/Vizsgaremek_Farkas_Ildiko/   oldalon elérhető.


Az alábbi funkciókra fókuszálnak a tesztek:
1. Regisztráció (RegistrationPage+RegistrationPageTest)
Random generált betűk használatával a név, email cím és a jelszó mezők kitöltése. A rendszer nem kér e-mail-es megerősítést, így ezt a Sikeres regisztráció teszt Inaktivált (Disabled-re), hogy ne fusson automatikusan, és az adatbázisba ne kerüljon ilyen "adatszemét". Egyébként lefut a teszt, megvizsgálja, hogy megkapja a Köszönjük, hogy regisztráltál üzenetet, majd kijelentkezik a felhasználó. Sikertelen regisztrációnál az egyik a random betűadatokkal próbál létrehozni egy felhasználót, de a két megadott jelszó nem egyezik. A másik pedig üres adatmezőkkel próbál regisztrálni. Mindkét tesztnél megkapjuk rendszertől elvárt hibaüzeneteket. 

Mivel ez egy production(vagy "éles") webshop, a továbbiakban egy előre meghatározott felhasználót használok azokban a tesztekben, ahol bejelentkezve lehet elérni a funkciókat.

2. Bejelentkezés (LoginPage+LoginPageTest)
Itt egy sikeres teszt, és 4 sikertelen van. Mindkét esetben rávizsgál, a visszakapott rendszerüzenetre. Sikertelen teszt helytelen email cím, jelszó, illetve az egyik vagy másik mező üresen hagyását teszteli.

3. Adatkezelési nyilatkozat használata (PrivacyPolicyPage+PrivacyPolicyPageTest+PrivacyPolicyText.txt)
Az oldalon nincs lehetőség adatkezelési tájékoztató elfogasására, ezért az adatkezelési tájékoztató oldalára való navigálás után lementésre kerül egy txt file-ba az adatkezelési tájékoztató szövegezésének egy része, majd megvizsgáljuk, hogy egy, a tesztben megadott, és az oldalon is szereplő kifejezés valóban szerepel-e a txt file-ban.

4. Keresőszavas szűrés eredményeinek vizsgálata (Adatok listázása) (SearchPage+SearchPageTest)



5. Szakértői tanácsok bejegyzéseinek vizsgálata (Több oldalas lista bejárása) (ExpertAdvicePage+ExpertAdvicePageTest+Blogtitel.txt)
A szakértői tanácsok lapon a teszt végiglapozza a blog listát, és közben kíírja egy Blogtitel.txt fájlba a blogcímeket, majd rávizsgál, hogy a lementett txt blogcímek száma egyezik-e a honlapon szereplő jelenlegi 47 blogszámmal.

6. Kívánságlist elküldése egy üzenet kíséretében (Új adat bevitel) (WishlistPage+WishlistPageTest)
Bejelentkezés és egy szűrés után a kívánságlistába helyezve egy terméket, lehetőség van megjegyzést írni, illetve a kívánságlistát egy üzenet kíséretében maximum 5 email címre elküldeni. Nem érkezik meg a kívánságlista a címzetnek, annak ellenére, hogy sikeres üzenetküldési visszaigazolást küld a rendszer. 

7. Számlázási cím módosítása (Ismételt és sorozatos adatbevitel adatforrásból)(CustomerAccountPage+CustomerAccountPageTest+Address.txt)
Bejelentkezés után az alapértelmezett számlázási címet szerkesztjük. A meglévő címeket töröljük, és az előre létrehozott Address.txt fájlból beolvasva módosítjuk az adatokat. (A mentésről kapott sikeres üzenet angolul jelenik meg.)(A cím szerkesztése oldalon a kitölthető nyomtatvány alján "Alapértelmezett számlázási cím""Alapértelmezett szállítási cím" feliratoknak nincs semmi funkciója)

8. Jelszó módosítása (Meglévő adat módosítása) (CustomerAccountPage+CustomerAccountPageTest)
Ugyan már az elöző 7-es pont (ismételt adatbevitel adatforrásból) is a meglévő adat módosításával történik, de itt a jelszó sikeres megváltoztatását, és egy sikertelen próbálkozás alkalmával kapott hibaüzenetet vizsgál a teszt. A rendszer egy angol nyelvű automatikus email üzenetet küld a jelszó megváltoztatásáról, amelyben kéri, hogy ha nem a fióktulajdonos engedélyezte a műveletet, akkor lépjen kapcsolatba a Skinsmart-al. (Az emailben nincs kontakt megadva, csak a hello@skinsmart.hu-ról érkező levelezési cím elérhető.)

9. Kívánságlistás termékhez fözőtt megjegyzés szerkesztése (Adat vagy adatok törlése) (WishlistPage+WishlistPageTest)



10. Egy termék leírásának vizsgálata (Adatok lementése felületről) (BookPage+BookPageTest+Book.txt)
Miután elnavigálunk a könyv termékhez, annak bemutatását leírását lementjük egy txt file-ba. Eztán ennek a lementett file-nak a tartalmát összehasonlítjuk az oldalon található szöveggel.

11. Kijelentkezés (LogoutPage+LogoutPageTest)
A kijelentkezés funkciónál, bejelentkezik a felhasználó, majd a kijelentkezést követően ráfrissít az oldalra, és rávizsgál, hogy valóban kijelentkezett.
