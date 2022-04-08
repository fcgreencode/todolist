docker_up:
	@echo "~~~ Up Redis and Postgres via Docker"
	@docker compose --project-name todolist-infra -f docker-compose.yml up

docker_down:
	@echo "~~~ Removing all infra docker containers"
	@docker compose --project-name todolist-infra -f docker-compose.yml down

docker_stop:
	@echo "~~~ Stopping docker"
	@docker compose --project-name todolist-infra -f docker-compose.yml stop

docker_start:
	@echo "~~~ Starting docker"
	@docker compose --project-name todolist-infra -f docker-compose.yml start

test:
	@echo "~~~ Testing the application"
	@mvn test

build:
	@echo "~~~ Building the application"
	@mvn clean install --no-transfer-progress --quiet

run:
	@echo "~~~ Running the application"
	@java \
		-Dfile.encoding=UTF-8 \
		-jar target/todolist-*.jar