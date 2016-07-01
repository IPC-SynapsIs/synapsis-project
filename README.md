## Resource name : Project
***
### Description : 
"Project" represent the main resource of the app: 
*Every project is identified by an UUID and described by a name and a description
*Every project has a list of participants, and every participant has a role
*Every project use a list of technologies, each one has a description ( why it used, how .. )
*Every project has a chronology list, each step has a description( start/end dates, description, notes ..) 

### Bound context attributes : 
* $id : UUID
* $name : String
* $description : String

### Extended context attributes : 
* $participantMap : HashMap<UUID, String> //(idParticipant, roleParticipant)
* $technologyMap : HashMap<UUID, String>  //(idTechnology, descriptionTechnology)
* $chronologyMap : HashMap<UUID, String>  //(idChronology, descriptionChronology)

### Resource providing microservice

### Resource consuming microservices
* Participant : Operate CRUD operations
* Technology : Operate CRUD operations
* Chronology : Operate CRUD operations
