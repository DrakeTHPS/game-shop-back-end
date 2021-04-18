INSERT INTO `games` VALUES (1,'Horizon Zero Dawn',1999,'Guerrilla Games',40,1500000,'2020-08-07','https://graph.digiseller.ru/img.ashx?id_d=2925136'),(2,'Red Dead Redemption 2',2499,'Rockstar Games',NULL,2000000,'2019-11-05','https://shop.buka.ru/data/img_files/6385/additional750x580/W86ojpNNJr.jpeg'),(3,'It Takes Two',2499,'Hazelight Studios',NULL,500000,'2021-03-26','https://pbs.twimg.com/media/Ea1RD6iX0AgHcjL.jpg'),(4,'Disco Elysium',725,'ZA/UM',20,800000,'2020-04-27','https://pbs.twimg.com/media/EMKIDygXYAEmZuA.jpg'),(5,'Mortal Kombat 11',1035,'NetherRealm Studios',NULL,2000000,'2019-04-23','https://i0.wp.com/ramenswag.com/wp-content/uploads/2019/03/Scorpion-character_-_Mortal-Kombat_-_Mortal-Kombat-11_-_Mortal-....jpg?zoom=3&resize=370%2C297&ssl=1'),(6,'Dark Souls III',1999,'FromSoftware',75,3500000,'2016-04-12','https://vgtimes.ru/uploads/gallery/main/147714/1580468286_4135.jpg'),(8,'Crash Bandicoot 4: It’s About Time',2499,'Toys For Bob',NULL,500000,'2021-03-26','https://upload.wikimedia.org/wikipedia/ru/3/3e/Crash_Bandicoot_4_It%E2%80%99s_About_Time_%28game%29.png'),(9,'Halo: The Master Chief Collection',725,'343 Industries',50,1000000,'2019-12-03','https://i.playground.ru/p/yvYBkCq_RbnydJXy8GVt2g.jpeg'),(10,'Sekiro: Shadows Die Twice',1999,'FromSoftware',NULL,2500000,'2019-03-21','https://avatars.mds.yandex.net/get-zen_doc/1658056/pub_5ca76c960a732d00b39ff8f0_5ca76eb86e54f000b2b3c2dc/scale_1200'),(12,'Hades',465,'Supergiant Games',NULL,1000000,'2020-09-17','https://pbs.twimg.com/media/D0_h2NVX0AUEblI.jpg'),(13,'Little Nightmares 2',999,'Tarsier Studios',10,800000,'2021-02-11','https://greatgamer.ru/resize/w700/images/games_cover/cover_34348.jpg');

INSERT INTO `genres` VALUES (1,'Action/RPG'),(2,'Action-adventure'),(3,'Third-person shooter'),(4,'RPG'),(5,'Fighting game'),(6,'Survival game'),(7,'Platform games'),(8,'First-person Shooter'),(9,'Stealth game'),(10,'Roguelike'),(11,'Survival horror');

INSERT INTO `game_genre` VALUES (1,1),(2,2),(2,3),(2,8),(3,2),(4,4),(5,5),(6,1),(8,7),(9,8),(10,2),(12,1),(12,10),(13,7),(13,11),(18,2),(18,3);

INSERT INTO `users` VALUES (1,'DrakeTHPS','$2y$12$Tev4RVlNWkHnc9f9aUKrT.TsLiIe3NH0xtV14aMGs1wzSm67AYjGm','ROLE_ADMIN'),(2,'Dasem','$2a$10$/CCKW4NXsE3ypMMRFNuxZ.IYWfveFskwol7vxvNDUoXJcVz6T64xq','ROLE_USER');
