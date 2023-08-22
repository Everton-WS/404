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
