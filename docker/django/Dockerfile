# Use a imagem base do Python adequada
FROM python:3.8

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo requirements.txt para o contêiner
COPY requirements.txt /app/

# Instala o virtualenv
RUN pip install virtualenv

# Cria e ativa o virtualenv
RUN virtualenv venv 
RUN . venv/bin/activate

# Instala as dependências
RUN pip install -r requirements.txt

# Copia o restante do código-fonte da aplicação
COPY . /app/

# Expor a porta da aplicação
EXPOSE 8000

# Define a variável de ambiente para o Django
ENV PYTHONDONTWRITEBYTECODE 1
ENV PYTHONUNBUFFERED 1

# Inicia o servidor web do Django
CMD ["python", "manage.py", "runserver", "0.0.0.0:8000"]
