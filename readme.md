# Jerry's test toolbox

## how to use

http://localhost:5030/commerce/product

certmgr.msc

docker build -t jerry/springbootexample:v1 .

docker run -it jerry/springbootexample:v1

docker run -p 8000:9000 --name jerrydockerdemo -d jerry/springbootexample:v1

进入运行状态中的容器内部：

sudo docker exec -it 53d87f882119 /bin/sh

# SAP Cloud Platform

cf push jerryjavadocker --docker-image jerry/springbootexample:v2

cf push jerryjavadocker --docker-image i042416/ui5-nginx:v2.0

docker tag 54df1648db82 i042416/springbootexample:v2 - 改名字

docker push i042416/springbootexample:v2 