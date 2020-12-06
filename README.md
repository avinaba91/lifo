# LIFO Application

In this app, H2 in-memory & Mariadb database are used for demo purpose

**View**

Append **/swagger-ui.html** in the browser after running the following command

````
> kubectl create -f k8s-deployment.yaml
> minikube service lifo

````

**Delete on Minikube**

````
kubectl delete all -l app=lifo

````

**Informtion**

1. By default it is taking H2 Database.
2. To switch to MariaDB, need to update the environment variable value DATABASE_HOST to mariadb.
3. To switch to H2, need to update the environment variable value DATABASE_HOST to h2.

**To Run with MariaDB**

1. Need to create a MariadB server
2. Need permission for user = 'user'
3. Mariadb should run on 3306 port of the localhost


**To Run with H2**

No need to do anything

**Docker**

````
docker push avinaba91/lifo:1.0

````


Image is already created and pushed to the default docker registry **docker.io**

````
docker.io/avinaba91/lifo:1.0

````

