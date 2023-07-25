# Supporting code for Apache Flink debugging article

## Usage

```sh
# start services in background
docker compose up -d

# tail logs from jobmanager
docker compose logs jobmanager -f

# tail logs from taskmanager
docker compose logs taskmanager -f
```
