[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Adventurer Subclasses

### Archer Class
- HP: 20 
+ Special Resource: Ammo
* Normal Attack: 5 Damage, consumes 1 Ammo
- Special Attack (Rapid Fire): consumes all Ammo, does 3 Damage per Ammo
+ Support: Reloads 3 Ammo
* Passive: Normal Attack damage is increased but consumes Ammo

***
### Ninja Class
- HP: 15 
+ Special Resource: Stealth
* Normal Attack: 3 Damage
- Special Attack (Sneak Attack): consumes 10 Stealth, 10 Damage
+ Support (Smoke Bomb): Enemy's accuracy is decreased for 1-3 turns(increased with Stealth)
* Passive: Stealth charges up over time, increases all damage dealt with Stealth

***

### WereWolf (Boss)
- HP: 50
+ Special Resource: Fury
* Normal Attack (Bite): 4 Damage, restore 1 HP, gain 1 Fury; Enhanced: 6 Damage, restores 3 HP, gain 2 Fury 
- Special Attack (Howl): Consumes 15 Fury, Permanently increase damage by 1.25x; Enhanced: Consumes 8 Fury, Permanently increase damage by 1.5x, healing by 1.25x  
+ Support: Spawns a wolf to help; Enhanced: Spawns 2 wolves
* Passive: Moonlight charges up over time, Max moonlight transforms WereWolf, Heals 10 HP and upgrades his abilities 

### Wolf (Minion)
- HP: 3
* Special Resource: None
+ Normal Attack (Chomp): 2 Damage
- Special Attack: calls Normal Attack
- Support: calls Normal Attack 


