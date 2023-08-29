# Guia Passo a Passo para Gerar um Certificado SSL Wildcard usando o Certbot e o Route 53 na AWS

Este guia detalha os passos necessários para gerar um certificado SSL Wildcard usando o Certbot em conjunto com o serviço de DNS Route 53 na AWS. O certificado SSL é usado para fornecer uma comunicação segura entre o servidor e os usuários do site.


## Passo 1: Atualização do Sistema

Antes de prosseguir, é uma boa prática garantir que o sistema esteja atualizado:

```bash
sudo apt-get update
```

## Passo 2: Instalação do Certbot e do Python Plugin Route 53

Através do Certbot será gerado os certificados SSL automaticamente. Por isso necessário instalar o plugin 'certbot-dns-route53' o qual permitirá a autenticação DNS com o Route 53 da AWS. Assim digite o seguinte comando no terminal:

```bash
sudo apt-get install certbot python3-certbot-dns-route53
```

## Passo 3: Gerando os Certificados SSL

Após a instalação do plugin utilize o comando abaixo para gerar a certificação SSL de forma manual, usando WILDCARD.

```bash
sudo certbot certonly --manual -d "*.seudominio.com.br"
```
Siga as instruções que o Certbot fornecerá. Você será solicitado a criar um registro DNS TXT no Route 53 para verificar a propriedade do domínio.

## Passo 4: Configurando o Registro DNS no Route 53

```bash
1- Acesse o Console de Gerenciamento da AWS: https://aws.amazon.com/console/
2- Navegue até o serviço "Route 53".
3- Selecione a zona DNS correspondente ao seu domínio.
4- Crie um novo registro de tipo "TXT".
5- No campo "Nome", insira _acme-challenge.seudominio.com.br. (substitua seudominio.com.br pelo seu domínio).
6- No campo "Valor", insira o valor fornecido pelo Certbot durante o processo de autenticação.
7- Salve o registro.
```

## Passo 5: Conclusão do Processo

Volte ao terminal onde você executou o comando do Passo 3 e aguarde a confirmação de que o processo de autenticação foi concluído com sucesso. Se tudo estiver correto, o Certbot informará que o certificado foi gerado com êxito.

## Passo 6: Localização dos Certificados

Os certificados gerados pelo Certbot estarão localizados em um diretório específico. Você pode encontrar os certificados em /etc/letsencrypt/live/seudominio.com.br/

## Passo 7: Configuração do SSL no Nginx

Na pasta Nginx, abra o arquivo nginx.conf utilizando o seguinte comando:

```bash
sudo vi /etc/nginx/nginx.conf
```

Após tecle i para inserir o mapeamento dos certificados no bloco do servidor relevante:

```bash
server {
    listen 443 ssl;
    server_name seudominio.com.br;

    ssl_certificate /etc/letsencrypt/live/seudominio.com.br/fullchain.pem;
    ssl_certificate_key /etc/letsencrypt/live/seudominio.com.br/privkey.pem;

    # Configurações adicionais do servidor...
    }
```

## Passo 8: Execução do Docker Compose

Agora que os certificados estão configurados, só executar o docker-compose.yml para iniciar os serviços.

