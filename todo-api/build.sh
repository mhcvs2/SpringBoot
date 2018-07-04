#!/usr/bin/env bash

image=registry.bst-1.cns.bstjpc.com:5000/todo-api
tag=$(date +'%Y%m%d')

docker build -t ${image}:${tag} .

docker push ${image}:${tag}