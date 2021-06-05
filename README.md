# Feeder and Receiver Service

## Pre-requisite
- Kubernetes Cluster is ready
- Installed `kubectl` command line tools


## Installation and Deployment

#### Checkout to project root
```bash
cd serai-feeder-receiver-service
```
#### Run installation
```bash
kubectl create -f ./serai-feeder-service/k8s-config/namespace.yaml
kubectl create -f ./serai-feeder-service/k8s-config/token-secret.yaml
kubectl create -f ./serai-feeder-service/k8s-config/deployment.yaml
kubectl create -f ./serai-feeder-service/k8s-config/service.yaml
kubectl create -f ./serai-receiver-service/k8s-config/deployment.yaml
kubectl create -f ./serai-receiver-service/k8s-config/service.yaml
```

#### Test with feeder endpoint (Port-Forwarding)
To expose feeder service and test on feeder-service locally, run the following command to have port-forward:  

Firstly, find the pod name of feeder service:
```bash
kubectl get pods --namespace=serai-dev
```

Output example:
```bash
NAME                                READY   STATUS    RESTARTS   AGE
feeder-service-6c7f6c6d48-66mwq     1/1     Running   0          54m
receiver-service-7fb4c7ffb5-tlw7p   1/1     Running   0          54m
```

Run port-forwarding command:
```bash
kubectl port-forward pods/feeder-service-6c7f6c6d48-66mwq 8080:8081 --namespace=serai-dev
```

Test the endpoint using curl:
```bash
curl --location --request POST 'http://127.0.0.1:8080/feeder/feed' \
--header 'Content-Type: application/json' \
--data-raw '{
	"message": 2000
}'
```

Expected result:
```bash
{
    "id": "82ec56bb-dd18-45b9-91b9-dd7cab41e3a6",
    "message": 2000,
    "createDateTime": "2021-06-05T16:46:46.390+00:00",
    "updatedDateTime": null
}
```


#### Test with feeder endpoint (Minikube)
Alternatively, the service can be exposed via minikube with command:
```bash
minikube -- service feeder-service --url --namespace=serai-dev
```

You will get an endpoint like this:  
```bash
🏃  Starting tunnel for service feeder-service.
|-----------|----------------|-------------|------------------------|
| NAMESPACE |      NAME      | TARGET PORT |          URL           |
|-----------|----------------|-------------|------------------------|
| serai-dev | feeder-service |             | http://127.0.0.1:60753 |
|-----------|----------------|-------------|------------------------|
http://127.0.0.1:60753
❗  Because you are using a Do
```

Test the endpoint using curl:  
```bash
curl --location --request POST 'http://127.0.0.1:60753/feeder/feed' \
--header 'Content-Type: application/json' \
--data-raw '{
	"message": 2000
}'
```

Expected result:  
```bash
{
    "id": "82ec56bb-dd18-45b9-91b9-dd7cab41e3a6",
    "message": 2000,
    "createDateTime": "2021-06-05T16:46:46.390+00:00",
    "updatedDateTime": null
}
```

#### Test with feeder endpoint (Ingress)
