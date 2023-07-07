## Run
1. Execute this command on terminal
   ```bash
   docker compose up -d
   ```
2. Run application on IntelliJ IDEA

## Usage

##### @Scheduled(fixedDelayString = "PT1M") -> Every minute

```java
@Scheduled(fixedDelayString = "PT1M")
@SchedulerLock(name = "fixed", lockAtLeastFor = "PT1M", lockAtMostFor = "PT5M")
public void fixed() 
  testService.fixed();
}
```

##### @Scheduled(cron = "0 17 21 * * *") -> seconds minutes hours dayOfMonth month dayOfWeek

```java
@Scheduled(cron = "0 17 21 * * *")
@SchedulerLock(name = "cron", lockAtLeastFor = "PT1M", lockAtMostFor = "PT5M")
public void cron() {
  testService.cron();
}
```



If you want see shedlock table:

```bash
docker exec -it db /bin/sh
```
```
PGPASSWORD=password psql -U root -d my_db
```
```
SELECT * FROM shedlock;
```