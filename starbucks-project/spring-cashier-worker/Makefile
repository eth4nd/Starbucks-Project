all: clean

clean:
	mvn clean

compile:
	mvn compile

build: compile
	mvn package

# Docker

docker-build: build
	docker build -t spring-cashier-worker .
	docker images

