## Imersão Java - Alura

Projeto realizado durante o evento da imersão Java na plataforma de cursos da Alura.

![Print](https://www.alura.com.br/assets/img/imersao-java/imersao-logo.1676983691.svg)

Na imersão Alura, foi criada a nossa própria API com o Framework Spring Boot e usando um banco de dados MongoDB.

Foram feito dois softwares:
a API que fornecia os responses e o Software que fazia os Requests via HTTP com GET.

No lado da API, ela incluía os dados no banco de dados quando recebia um POST com as informações e dados corretos. Ao receber um uma request GET do nosso software, ele trazia os dados corretos no banco de dados, processava os dados e enviava no formato JSON.

No lado do Software que realizava as requests, era recebida as responses da API que após ler os dados da JSON, processava-os e os transformava em imagens com legendas sendo possível criar figurinhas para o WhatsApp e o Telegram.
