docker buildx build --platform linux/amd64,linux/arm64 --push -t app_node .



docker run --name container_name \
 -e NODE_DB_HOST=xxx \
 -e NODE_DB_PORT=xxx \
 -e NODE_DB_USER=xxx \
 -e NODE_DB_PASS=xxx \
 -e NODE_DB_SCHEMA=xxx \
-p 3000:3000   -it app_node


aws lightsail push-container-image \
		--region yyyyyy \
		--service-name yyyyyy \
		--label yyyyyy --image app_node:latest



NODE_DB_HOST=ls-ab67b6320b508392576fed640eebddfd690609fb.cneqr094vwzb.ap-northeast-1.rds.amazonaws.com
NODE_DB_PORT=3306
NODE_DB_USER=dbmasteruser
NODE_DB_PASS=uY4QoDjIYVbQhSUN*5ft7kTDi33d
NODE_DB_SCHEMA=sistema