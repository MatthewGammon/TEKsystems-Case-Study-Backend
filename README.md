# Tidal Regears Backend
Spring Boot backend for the Tidal Regears Management System full-stack web application. 

## Project Goals
The number one goal with this project was to eliminate the manual entry of code and management of documents that go into managing a guild's regear system.
I set out to create a smooth and seamless application that works in conjuction with the Albion Player Info application ([repo here](https://github.com/MatthewGammon/Albion-Player-Info), [Live application](https://albion-player-info.vercel.app/home))
to create and manage builds and regear requests. 

## Important Note
The Albion Player Info application linked above is deployed and working with an Express backend. Any regear request made from that web app will point to the /regears endpoint which runs validation (that is hardcoded) on the request and if successful, persists that request to a hosted PostgreSQL database. 
The Express application was modified to included a new endpoint, /generateRegearRequest, which takes the request body, performs look ups to get the plain English name of every item, parses the item name to get appropriate item level information, and generates a new, more detailed, and easier to read request body.
This request body gets sent to the Spring Boot backend which then performs additional validation and saves to a local db.
The above deployed application is unable to have it's requests redirected to these new endpoints because the Spring Boot app and the DB are not hosted and only currently running locally. 
This will be remedied in the coming days.

## Key Functionality
An guild officer with sufficient admin perms will be able to:
* Create a new build from a form that contains all of the weapons and armor in the game
* Edit and Delete created builds
* View all currently pending regear requests that have been submitted by guild members
* Approve or Reject regear requests

A regular user will be able to:
* Register an account and log in
* View information about the guild (useful for new and potential members)
* View requirements for joining the guild as well as requirements for getting an approved regear request
* View all builds that have been approved and created by the guild officers/admin


## Tech and Tools
* Java
* Spring Boot
* Spring Security
* Spring Data
* MariaDB
* MySQL

## Challenges Encountered During Development
The number one challenge that I faced in the development of this project was ensuring that I could retrieve necessary information to display to the end user.
When a request is sent from the Albion Player Info web app, each piece of gear the player is wearing is sent on the request body like this:

```json
character_name	"CynicalEntity"
chest_armor	"T6_ARMOR_CLOTH_SET2@2"
event_id	"492985911"
guild_name	"Tidal"
head_piece	"T6_HEAD_LEATHER_SET1@2"
item_power	1507
main_hand	"T6_2H_HOLYSTAFF_HELL@2"
shoes	"T7_SHOES_CLOTH_SET1@1"
time_of_death	"Fri, 17 Jun 2022 05:07 UTC"
```

Each name of an item contains three key pieces of information. The name of the item, the tier of the item, and the quality of the item. 
A look up of each item's Unique Name(T6_HEAD_LEATHER_SET1@2 for example) has to be performed in order to retrieve the object containing all information about that item. This includes the following information:
* Localized Name
* Unique Name
* Item Description
* LocalizationNameVariable
* LocalizationDescriptionVariable
* LocalizedNames
* LocalizedDescriptions
* Index
* UniqueName

The Unique Name is manipulated and used to generate Item Level and Tier Equivalent values.
The Localized English Name is retrieved and inserted into the new body.

The end result of these lookups and manipulations is a new request body that looks like this...

```json
  "characterName": 'CynicalEntity',
  "guildName": 'Tidal',
  "eventId": '492985911',
  "itemPower": 1507,
  "mainHand": 'Fallen Staff',
  "mainTier": '6.2',
  "mainEquivalent": 8,
  "headGear": 'Mercenary Hood',
  "headTier": '6.2',
  "headEquivalent": 8,
  "chestGear": 'Cleric Robe',
  "chestTier": '6.2',
  "chestEquivalent": 8,
  "shoes": 'Scholar Sandals',
  "shoesTier": '7.1',
  "shoesEquivalent": 8,
  "timeOfDeath": 'Fri, 17 Jun 2022 05:07 UTC'
  ```
  
This information provides much more value to the end user who will be managing this request and resupplying the gear.

Altogether I had to work on 4 projects including two projects that I built earlier this year in order to get a fully functioning final product. 



## Project Frontend
[Tidal Regears Frontend](https://github.com/MatthewGammon/Tidal-Regears-Frontend)
