#!/usr/bin/env bash

image=registry.bst-1.cns.bstjpc.com:5000/mhc/bms:180610

docker build -f Dockerfile2 -t ${image} .

docker push ${image}
