# Vizsgaremek_Farkas_Ildiko

A felület tesztelés tárgya a   https://skinsmart.hu/   weboldal.

A manuális tesztek dokumentációját a github repo tartlamazza. https://github.com/ildime/Vizsgaremek_Farkas_Ildiko/blob/master/Vizsgaremek_Manuális_teszt_Farkas_Ildiko.xlsx

A bugként felvett hibajegyek nem kapcsolódnak szorosan a tesztelt funkciókhoz, inkább jellemzően esztétikai, mintsem funkcionalitásbeli hibák. Ennek ellenére érdemes lehet a későbbiekben a kijavításukkal foglalkozni. 

A generált tesztjelentés a   https://ildime.github.io/Vizsgaremek_Farkas_Ildiko/   oldalon elérhető.

Mivel Java nyelven, JUnit5 rendszerben íródott a kód, ezért a tesztek futtatásához Java környezet szüséges. Github Action segítségével készül a generált tesztjelentés, amely minden push-olás alkalmával lefuttatja a teszteket.  


Az alábbi funkciókra fókuszálnak a tesztek:
1. Regisztráció (RegistrationPage+RegistrationPageTest)
Random generált betűk használatával a név, az email cím és a jelszó mezők kitöltése. A rendszer nem kér email-es megerősítést, így ezt a "Sikeres regisztráció teszt" inaktivált (Disabled), hogy ne fusson automatikusan, és az adatbázisba ne kerüljön "adatszemét". Egyébként lefut a teszt, megvizsgálja, hogy megkapja a "Köszönjük, hogy regisztráltál" üzenetet, majd kijelentkezik a felhasználó. Sikertelen regisztráció teszteknél az egyik a random betűadatokkal próbál létrehozni egy felhasználót, de a két megadott jelszó nem egyezik. A másik pedig üres adatmezőkkel próbál regisztrálni. Mindkét tesztnél megkapjuk rendszertől elvárt hibaüzeneteket. 

Mivel ez egy production(vagy "éles") webshop, a továbbiakban egy előre meghatározott felhasználót használok azokban a tesztekben, ahol bejelentkezve lehet elérni a funkciót.

2. Bejelentkezés (LoginPage+LoginPageTest)
Itt egy sikeres teszt, és 4 sikertelen szerepel. Minden esetben rávizsgálnak a tesztek, a visszakapott rendszerüzenetre. A sikertelen teszt, helytelen email cím, helytelen jelszó, illetve az egyik vagy másik mező üresen hagyását teszteli.

3. Adatkezelési nyilatkozat használata (PrivacyPolicyPage+PrivacyPolicyPageTest+PrivacyPolicyText.txt)
Az oldalon nincs lehetőség adatkezelési tájékoztató elfogasására, ezért az adatkezelési tájékoztató oldalára való navigálás után lementésre kerül egy txt file-ba az adatkezelési tájékoztató szövegezésének egy része, majd megvizsgáljuk, hogy egy, a tesztben megadott, és az oldalon is szereplő kifejezés valóban szerepel-e a txt file-ban.

4. Keresőszavas szűrés eredményeinek vizsgálata (Adatok listázása) (SearchPage+SearchPageTest+Search_result.txt)
Egy keresőszavas szűrés után elmentjük egy Search_result.txt fájl-ba az eredményt, majd az oldalra frissítve, és még egyszer rákeresve ugyanazon keresőszóra, megvizsgáljuk, hogy a lementett txt fájl tartalma megegyezik-e az újonnan kapott eredménnyel. 

5. Szakértői tanácsok bejegyzéseinek vizsgálata (Több oldalas lista bejárása) (ExpertAdvicePage+ExpertAdvicePageTest+Blogtitel.txt)
A szakértői tanácsok lapon a teszt végiglapozza a blog listát, és közben kíírja egy Blogtitel.txt fájlba a blogcímeket, majd rávizsgál, hogy a lementett txt blogcímek száma egyezik-e a honlapon szereplő jelenlegi 47 blogszámmal.

6. Kívánságlista elküldése egy üzenet kíséretében (Új adat bevitel) (WishlistPage+WishlistPageTest)
Bejelentkezés és egy keresőszavas szűrés után a kívánságlistába helyezve egy terméket, lehetőség van megjegyzést írni hozzá, illetve a kívánságlistát egy üzenet kíséretében maximum 5 email címre elküldeni. Az adatbevitelt és a levél elküldését vizsgálja a teszt.

7. Számlázási cím módosítása (Ismételt és sorozatos adatbevitel adatforrásból)(CustomerAccountPage+CustomerAccountPageTest+Address.txt)
Bejelentkezés után az alapértelmezett számlázási címet szerkesztjük. A meglévő címeket töröljük, és az előre létrehozott Address.txt fájlból beolvasva módosítjuk az adatokat. A sikeres mentésről üzenet érkezik.

8. Jelszó módosítása (Meglévő adat módosítása) (CustomerAccountPage+CustomerAccountPageTest)
Ugyan már az elöző 7-es pont (ismételt adatbevitel adatforrásból) is a meglévő adat módosításával történik, de itt a jelszó sikeres megváltoztatását, és egy sikertelen próbálkozás alkalmával kapott hibaüzenetet vizsgál a teszt.

9. Kívánságlistás termékhez fűzőtt megjegyzés szerkesztése (Adat vagy adatok törlése) (WishlistPage+WishlistPageTest)
Bejelentkezés és szűrés után a terméket a kívánságlistába helyezve megjegyzés írunk a termékhez, majd kitörüljük a megjegyzést, illetve a terméket is a kívánságlistáról. A tesztjelentésben képernyőfotók is dokumentálják a tesztállapotokat.

10. Egy termék bemutató leírásának vizsgálata (Adatok lementése felületről) (BookPage+BookPageTest+Book.txt)
Miután elnavigálunk a könyv termékhez, annak bemutató leírását lementjük egy txt file-ba. Ennek a lementett file-nak a tartalmát összehasonlítjuk az oldalon található szöveggel.

11. Kijelentkezés (LogoutPage+LogoutPageTest)
A kijelentkezés funkciónál, bejelentkezik a felhasználó, majd a kijelentkezést követően ráfrissít az oldalra, és rávizsgál, hogy valóban kijelentkezett. A generált riportban képernyőfotók is elérhetőek a teszthez.
