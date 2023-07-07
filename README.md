## Run
   1. Execute this command on terminal
   ```bash
   docker compose up -d
   ```
   2. Run application on IntelliJ IDEA

## Usage

You can test the APIs import Postman collection.

If you want see database tables:

```bash
docker exec -it db /bin/sh
```
```
PGPASSWORD=password psql -U root -d my_db
```
```
SELECT * FROM courses;
SELECT * FROM trainings;
```