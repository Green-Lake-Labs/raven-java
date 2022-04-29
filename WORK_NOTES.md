## Left-Off: Thursday 4/27

 Built out the entire framework & API architecture.

 
### Next Steps:

[x] Configure `ExchangeClient` to retrieve symbols & details from the API.  
[x] Create the database `up.sql` & provision the symbol & firm data tables.   
[] Deploy the Docker network (`docker-compose`) - except the Rust CLI.  
[x] Configure JPA Repositories & PostgreSQL POJOs.  
[x] Link `ExchangeClient` methods with the database & test.

This will leave us with the remaining work (generally speaking):   
- Valuation algorithms.
- Post-valuation analysis algorithms.
- Config & other POJO models.
- Error handling & Response Entities
- Testing
- etc.