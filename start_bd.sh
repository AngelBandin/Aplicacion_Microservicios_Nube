#!/bin/bash

docker pull mongo
docker container run --name=mongo_precios -p 27017:27017 -d mongo && docker cp ./prices.csv mongo_precios:/tmp/prices.csv && docker exec mongo_precios mongoimport --type csv -d bd_precios -c precios --headerline --drop /tmp/prices.csv

