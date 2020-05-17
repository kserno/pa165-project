package cz.muni.fi.pa165.sampledata;


import cz.muni.fi.pa165.entity.*;
import cz.muni.fi.pa165.enums.AmmunitionType;
import cz.muni.fi.pa165.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
@Transactional
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

    @Autowired
    private AreaService areaService;

    @Autowired
    private CreatureService creatureService;

    @Autowired
    private UserService userService;

    @Autowired
    private EffectivenessService effectivenessService;

    @Autowired
    private WeaponService weaponService;

    public static final String JPEG = "image/jpeg";


    @Override
    public void loadData() throws IOException {

        Weapon w1 = weapon("Assault rifle", 100, AmmunitionType.MEDIUM, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/3/36/Assault_Rifle_%28SCAR%29_%28NEW%29.png/160px-Assault_Rifle_%28SCAR%29_%28NEW%29.png?version=90d0c349fd205ec75d53c2bdaaef0c80");
        Weapon w2 = weapon("Minigun", 70, AmmunitionType.LARGE, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/0/02/Minigun_icon.png/160px-Minigun_icon.png?version=09f32c4e111a98c42b0201ef98cbcce7");
        Weapon w3 = weapon("Drum gun", 80, AmmunitionType.MEDIUM, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/6/6c/Drum_gun_icon.png/160px-Drum_gun_icon.png?version=a87e89e93ddf06fcd115cd014569183c");
        Weapon w4 = weapon("Pistol", 40, AmmunitionType.SMALL, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/a/a2/Pistol.png/160px-Pistol.png?version=6e51db10bf94feb79a82e911b3407fa7");
        Weapon w5 = weapon("Pump shotgun", 20, AmmunitionType.MEDIUM, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/3/32/Pump_shotgun.png/160px-Pump_shotgun.png?version=4972b2b216d7c9dbfa165477e5559196");
        Weapon w6 = weapon("Tactical shotgun", 15, AmmunitionType.MEDIUM, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/7/78/Tac_shot_icon.png/160px-Tac_shot_icon.png?version=2a29409993b515bcdbb89be4349ddd5f");
        Weapon w7 = weapon("Heavy sniper", 500, AmmunitionType.LARGE, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/4/4e/Obliterator_icon.png/160px-Obliterator_icon.png?version=665ad16dd6db032446e9ef726885b746");
        Weapon w8 = weapon("Rocket launcher", 250, AmmunitionType.LARGE, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/8/85/Purple_gold_rpg.png/160px-Purple_gold_rpg.png?version=cbf416161ceefb3fc446001446b10083");
        Weapon w9 = weapon("Pickaxe", 1, AmmunitionType.NONE, "https://gamepedia.cursecdn.com/fortnite_gamepedia/thumb/0/0f/DefaultPickaxeChapter2.png/160px-DefaultPickaxeChapter2.png?version=d0bbac99549b61bdfc7d67261928ad3f");


        User user1 = user("Jenny Sims", "jenny.sims@example.com",
                "desichemist", false, "goldie", "54.jpg");
        User user2 = user("Darryl Pierce", "darryl.pierce@example.com",
                "listeningivory", false, "union123", "4.jpg");
        User user3 = user("Jacob Duncan", "jacob.duncan@example.com",
                "copyrapid", false, "eeeeee", "9.jpg");
        User user4 = user("Jeremiah Cruz", "jeremiah.cruz@example.com",
                "choppingnew", false, "eric123", "14.jpg");
        User user5 = user("Anthony Pena", "anthony.pena@example.com",
                "admin", true, "admin123", "51.jpg");

        Creature c1 = creature("Feral ghoul", 180, 70, 30, "https://vignette.wikia.nocookie.net/fallout/images/e/e3/Ghoul.png/revision/latest/scale-to-width-down/598?cb=20160106102356");
        Creature c2 = creature("Mongrel", 40, 20, 70, "https://vignette.wikia.nocookie.net/fallout/images/2/29/FO4_Mongrel_dog.png/revision/latest/scale-to-width-down/700?cb=20180120000123");
        Creature c3 = creature("Deathclaw", 240, 150, 50, "https://vignette.wikia.nocookie.net/fallout/images/b/bb/Deathclaw_fo4.png/revision/latest/scale-to-width-down/700?cb=20160101191326");
        Creature c4 = creature("Alien", 200, 90, 40, "https://vignette.wikia.nocookie.net/fallout/images/a/ae/Fo4_alien.png/revision/latest?cb=20190804174445");

        Area a1 = area("Finch farm", "Finch farm consists of a concrete cooking station, a water pump, a small cottage containing four beds where the Finch family members sleep, and a semi-fenced in farm plot that mainly consists of mutfruit, along with a few rows of corn and razorgrain. There is also a ruined overpass overhead on which additional housing may be constructed.", "https://vignette.wikia.nocookie.net/fallout/images/8/87/FO4_Finch_Farm.jpg/revision/latest/scale-to-width-down/242?cb=20151206030700");
        Area a2 = area("Rocky Narrows Park", "The Rocky Narrows Park is a location in the Commonwealth in 2287.", "https://vignette.wikia.nocookie.net/fallout/images/5/51/FO4_Rocky_Narrows_Park.jpg/revision/latest/scale-to-width-down/242?cb=20151116021111");
        Area a3 = area("Lake Cochituate", "This is a relatively large lake with a few locations on its shoreline, such as the Poseidon reservoir to the northwest, Natick Banks including its police department to the west, an unmarked pre-War military checkpoint to the southwest and the Mass Fusion disposal site to the southeast.", "https://vignette.wikia.nocookie.net/fallout/images/5/5c/Lake_Cochituate.jpg/revision/latest/scale-to-width-down/242?cb=20151116033940");
        Area a4 = area("Easy City Downs", "It is a small city built from a pre-War horse track and is inhabited by raiders and Triggermen. There are also a number of non-hostile robots racing around the track, which include models such as the Mister Gutsy, Mister Handy, assaultron and eyebot. Throughout the area, there are several terminals that can be used to shut the bots down, turn them on the raiders and Triggermen or cause them to self-destruct.", "https://vignette.wikia.nocookie.net/fallout/images/c/c6/EasyCityDowns-Fallout4.jpg/revision/latest/scale-to-width-down/242?cb=20161111221554");

        c1.getAreas().add(a1);
        c1.getAreas().add(a2);
        c1.getAreas().add(a3);
        c1.getAreas().add(a4);

        c2.getAreas().add(a2);
        c2.getAreas().add(a3);

        c3.getAreas().add(a3);

        c4.getAreas().add(a2);
        c4.getAreas().add(a3);
        c4.getAreas().add(a4);


        Effectiveness e1 = effectiveness(user1, c1, w1, 60);
        Effectiveness e2 = effectiveness(user2, c3, w1, 40);
        Effectiveness e3 = effectiveness(user3, c2, w1, 10);
        Effectiveness e4 = effectiveness(user4, c4, w1, 70);
        Effectiveness e5 = effectiveness(user5, c1, w1, 54);

        Effectiveness e6 = effectiveness(user1, c4, w2, 55);
        Effectiveness e7 = effectiveness(user2, c3, w2, 30);
        Effectiveness e8 = effectiveness(user3, c3, w2, 12);
        Effectiveness e9 = effectiveness(user4, c3, w2, 60);
        Effectiveness e10 = effectiveness(user5, c2, w2, 53);

        Effectiveness e11 = effectiveness(user1, c3, w3, 62);
        Effectiveness e12 = effectiveness(user2, c2, w3, 39);
        Effectiveness e13 = effectiveness(user3, c2, w3, 9);
        Effectiveness e14 = effectiveness(user4, c4, w3, 72);
        Effectiveness e15 = effectiveness(user5, c1, w3, 61);

        Effectiveness e16 = effectiveness(user1, c2, w4, 30);
        Effectiveness e17 = effectiveness(user2, c3, w4, 20);
        Effectiveness e18 = effectiveness(user3, c4, w4, 2);
        Effectiveness e19 = effectiveness(user4, c1, w4, 70);
        Effectiveness e20 = effectiveness(user5, c1, w4, 29);

        Effectiveness e21 = effectiveness(user1, c1, w5, 80);
        Effectiveness e22 = effectiveness(user2, c4, w5, 82);
        Effectiveness e23 = effectiveness(user3, c2, w5, 65);
        Effectiveness e24 = effectiveness(user4, c4, w5, 59);
        Effectiveness e25 = effectiveness(user5, c1, w5, 79);

        Effectiveness e26 = effectiveness(user1, c1, w6, 70);
        Effectiveness e27 = effectiveness(user2, c3, w6, 60);
        Effectiveness e28 = effectiveness(user3, c2, w6, 50);
        Effectiveness e29 = effectiveness(user4, c4, w6, 40);
        Effectiveness e30 = effectiveness(user5, c1, w6, 69);

        Effectiveness e31 = effectiveness(user1, c2, w7, 55);
        Effectiveness e32 = effectiveness(user2, c1, w7, 30);
        Effectiveness e33 = effectiveness(user3, c4, w7, 20);
        Effectiveness e34 = effectiveness(user4, c2, w7, 100);
        Effectiveness e35 = effectiveness(user5, c1, w7, 74);

        Effectiveness e36 = effectiveness(user1, c2, w8, 51);
        Effectiveness e37 = effectiveness(user2, c1, w8, 28);
        Effectiveness e38 = effectiveness(user3, c4, w8, 30);
        Effectiveness e39 = effectiveness(user4, c3, w8, 54);
        Effectiveness e40 = effectiveness(user5, c1, w8, 34);

        Effectiveness e41 = effectiveness(user1, c4, w9, 40);
        Effectiveness e42 = effectiveness(user2, c3, w9, 80);
        Effectiveness e43 = effectiveness(user3, c1, w9, 91);
        Effectiveness e44 = effectiveness(user4, c4, w9, 77);
        Effectiveness e45 = effectiveness(user5, c2, w9, 14);




    }

    private Weapon weapon(String name, int gunReach, AmmunitionType ammunitionType, String image) {
        Weapon weapon = new Weapon();

        weapon.setName(name);
        weapon.setGunReach(gunReach);
        weapon.setAmmunitionType(ammunitionType);
        weapon.setImage(image);

        weaponService.createWeapon(weapon);
        return weapon;
    }

    private Creature creature(String name, double height, double weight, double agility, String image) {
        Creature creature = new Creature();

        creature.setName(name);
        creature.setHeight(height);
        creature.setWeight(weight);
        creature.setAgility(agility);

        creature.setImage(image);

        creatureService.createCreature(creature);
        return creature;
    }

    private Area area(String name, String description, String image) {
        Area area = new Area();

        area.setName(name);
        area.setDescription(description);
        area.setImage(image);

        areaService.createArea(area);
        return area;
    }

    private Effectiveness effectiveness(User author, Creature creature, Weapon weapon, double rating) {
        Effectiveness effectiveness = new Effectiveness();

        effectiveness.setAuthor(author);
        effectiveness.setCreature(creature);
        effectiveness.setWeapon(weapon);

        effectiveness.setRating(rating);

        effectivenessService.createEffectiveness(effectiveness);
        return effectiveness;
    }

    private User user(String name, String email, String username, boolean isAdmin, String password, String imageFilename) {
        User user = new User();

        user.setName(name);
        user.setUsername(username);
        user.setEmail(email);
        user.setAdmin(isAdmin);
        try {
            user.setImage(readImage(imageFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setImageMimeType(JPEG);

        userService.registerUser(user, password);
        return user;
    }


    private byte[] readImage(String file) throws IOException {
        try (InputStream is = this.getClass().getResourceAsStream("/" + file)) {
            int nRead;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            byte[] data = new byte[1024];
            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            return buffer.toByteArray();
        }
    }
}
