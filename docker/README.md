# Passo a passo para entrar em uma instância, clonar este repositório e executar os serviços através do Docker Compose

## Passo 1
Criar instancia ec2

### 1.1
Entrar na maquina com ssh ou pelo console da aws - Note que para isso geramos uma chave chamada grupo 404.pem

#### 1.1.2 Excutar os seguintes comandos

```bash
sudo apt update
sudo apt install docker
sudo apt install docker-compose
```

### 1.2 
Abrir as portas de entrada 80 e 443 na instância EC2 para que possamos acessar a máquina.

### 1.3
Trocar no route53 os values com ipv4 público da maquina da EC2.

## Passo 2
Clonar nosso repositório do git

```bash
git clone https://github.com/patrickbnu/404.git
```

## Passo 3
Seguir o README.md da pasta ssl, esse doc explica como gerar os certificados ssl. Após isso, vale a lembrança que eles serão gerados em uma pasta que apenas o user root pode acessar, sendo assim, precisamos copiar a chave (documentos fullchain e privkey) para a pasta projeto/404/docker/data/certbot/conf/live/404.sol.app.br.

É preciso mandar para essa pasta pois o mapeamento que fizemos indica que o conteúdo dessa pasta será mandado para as pastas corretas no docker gerado no dockercompose. Isso foi feito em volumes no docker-compose na parte do nginx.

## Passo 4
Adicionar as variáveis de sistema em docker/.env - Estas variáveis de sistema são necessárias para termos as senhas para acessar banco de dados e outras informações necessárias para rodar liso o wordpress e nossas aplicações.

## Passo 5
Ir na pasta docker e rodar o seguinte comando

```bash
sudo docker-compose up 
```

Com isto, pode-se acessar o link https://www.404.sol.app.br.