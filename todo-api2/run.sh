#!/usr/bin/env bash

image=registry.bst-1.cns.bstjpc.com:5000/todo-api2:20180704

docker run -d --name=todo-api2 -p9090:9090 -eMYSQL_ADDRESS=services.gcloud.srcb.com:30306 ${image}