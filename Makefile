export

DOCKER_COMPOSE = cd docker && docker-compose

.PHONY: start
start: erase build up ## clean current environment, recreate dependencies and spin up again

.PHONY: erase
erase: ## stop and delete containers, clean volumes
	$(DOCKER_COMPOSE) down -v --remove-orphans

.PHONY: build
build: ## build environment and initialize project dependencies
	$(DOCKER_COMPOSE) build

.PHONY: up
up: ## spin up environment
	$(DOCKER_COMPOSE) up -d --force-recreate

.PHONY: stop
stop: ## stop environment
	$(DOCKER_COMPOSE) stop