#!/usr/bin/env bash

kubectl create -f ./serai-feeder-service/k8s-config/namespace.yaml
kubectl create -f ./serai-feeder-service/k8s-config/token-secret.yaml
kubectl create -f ./serai-feeder-service/k8s-config/deployment.yaml
kubectl create -f ./serai-feeder-service/k8s-config/service.yaml
kubectl create -f ./serai-receiver-service/k8s-config/deployment.yaml
kubectl create -f ./serai-receiver-service/k8s-config/service.yaml

