## Left-Off: Thursday 4/27

 Built out the entire framework & API architecture.

 
### Next Steps:

1. Configure `ExchangeClient` to retreive symbols & details from the API.
2. Create the database `up.sql` & provision the symbol & firm data tables.
3. Deploy the Docker network (`docker-compose`) - except the Rust CLI.
4. Configure Spring Data JPA & PostgreSQL POJOs.
5. Link `ExchangeClient` methods with the database & test.

This will leave us with the remaining work (generally speaking):   
- Valuation algorithms.
- Post-valuation analysis algorithms.
- Config & other POJO models.
- Error handlings & Response Entities
- Testing
- etc.