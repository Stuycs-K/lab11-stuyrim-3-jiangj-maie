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
- Special Attack (Sneak Attack and Smoke Bomb): consumes 10 Stealth, deals 10 Damage, and decreases enemy's accuracy by 20%
+ Support: Stealth increases by 10
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

## Bugs/Glitches/To Do List/Features
- :white_check_mark: Align drawParty within the borders
- :x: Accuracy field implementation
- :white_check_mark: TextBox, check comments
- :white_check_mark: ColorByPercent
- :white_check_mark: Move cursor to bottom of terminal
- :white_check_mark: Multiple Enemies
- :x: Invalid inputs
- :white_check_mark: Support method implementation
- :white_check_mark: Support method targeting self uses default support
- :white_check_mark: Enemy's move
- :white_check_mark: Kill Enemy/Player if HP reaches 0
- :white_check_mark: Move History Display
- :white_check_mark: Select slot to target for each move
- :white_check_mark: WereWolf transform
- :x: update enter input message
