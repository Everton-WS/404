docker run --name <container_name> \
 -e NODE_DB_HOST=<host>\
 -e NODE_DB_PORT=<port> \
 -e NODE_DB_USER=<user> \
 -e NODE_DB_PASS=<pass> \
 -e NODE_DB_SCHEMA=<schema> \
-p 3000:3000   -it node


aws lightsail push-container-image \
		--region <zone> \
		--service-name <service_name> \
		--label <label> --image node:latest
