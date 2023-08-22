# Use the official Nginx base image
FROM nginx:latest

# Copy the custom Nginx configuration file
COPY nginx.conf /etc/nginx/nginx.conf

# Copy the index.html file to the Nginx document root
COPY index.html /usr/share/nginx/html/

# Expose port 80 for HTTP
EXPOSE 80

# Start Nginx
#CMD ["nginx", "-g", "daemon off;"]