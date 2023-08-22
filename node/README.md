docker build .



docker run --name xxxxxxx \
 -e NODE_DB_HOST=xxx \
 -e NODE_DB_PORT=xxx \
 -e NODE_DB_USER=xxx \
 -e NODE_DB_PASS=xxx \
 -e NODE_DB_SCHEMA=xxx \
-p 3000:3000   -it node


aws lightsail push-container-image \
		--region yyyyyy \
		--service-name yyyyyy \
		--label yyyyyy --image node:latest
