# 🚗 RepairSpringAPI ⚒️
API de conserto de carros desenvolvida com Spring Boot para a disciplina de PW3.
### 👥 Integrantes:
- Gustavo Trizotti (SC3044998)
- Arthur Mascaro ()
  
# 📄 Documentação
### 🌐 Rotas HTTP: 
### Buscar Consertos `[GET] /consertos`:
```json
{
  "content": [
    {
      "id": 1,
      "dataEntrada": "20/10/2025",
      "dataSaida": "21/10/2025",
      "nomeMecanico": "Jurisberto",
      "marcaVeiculo": "Volkswagen",
      "modeloVeiculo": "Polo"
    }
  ],
  "page": {
    "size": 10,
    "number": 0,
    "totalElements": 1,
    "totalPages": 1
  }
}
```
### Cadastrar Conserto `[POST] /consertos`:
```json
{
  "dataEntrada": "05/10/2025",
  "dataSaida": "21/10/2025",
  "mecanico": {
    "nome": "Clodoaldo",
    "anosExperiencia": 30
  },
  "veiculo": {
    "marca": "Volkswagen",
    "modelo": "Polo",
    "ano": 2016,
    "cor": "Prata"
  }
}
```
### Buscar Conserto por ID `[GET] /consertos/{id}`
```json
{
  "id": 1,
  "dataEntrada": "20/10/2025",
  "dataSaida": "21/10/2025",
  "mecanico": {
    "nome": "Jurisberto",
    "anosExperiencia": 30
  },
  "veiculo": {
    "marca": "Volkswagen",
    "modelo": "Polo",
    "ano": "2016",
    "cor": "Prata"
  }
}
```
### Atualizar Conserto `[PUT] /consertos`
Dados de Entrada (Incoming):
```json
{
  "id": 1,
  "dataSaida": "23/10/2025",
  "mecanico": {
    "nome": "Zé de Votuporanga",
    "anosExperiencia": 45
  }
}
```
Dados de Saída (Outgoing):
```json
{
  "id": 1,
  "dataSaida": "23/10/2025",
  "mecanico": {
    "nome": "Zé de Votuporanga",
    "anosExperiencia": 45
  }
}
```
### Deletar Conserto `[DELETE] /consertos/{id}`
Status de Retorno (em caso de sucesso):
`204 No Content`
