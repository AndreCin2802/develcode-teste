# develcode-teste

Substituir os campos  username e password em application.properties
Documentação da api em http://localhost:8080/swagger-ui.html (necessário rodar a aplicação)

# Criar Usuário

Requisição Post na rota /user

recebe 3 campos

{
  "birth_date": "yyyy-mm-dd",
  "code": "string",
  "name": "string"
}

# Salvar Foto

Requisição Post na rota /photo/upload/id (id do usuario)
recebe um Multipart Form com o nome photo e um arquivo
