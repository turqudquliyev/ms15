## Run
   Execute this command on terminal
   ```bash
   docker compose up --build -d
   ```

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
SELECT * FROM students;
SELECT * FROM student_details;
```