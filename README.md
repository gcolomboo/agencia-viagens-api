cat > README.md << 'EOF'
# 🌍 Agência de Viagens API

API REST para gerenciamento de destinos de viagem e avaliações, desenvolvida com **Java 25** e **Spring Boot 3.5**.

---

## 🚀 Funcionalidades

- ✅ Criar, listar, buscar, atualizar e excluir destinos
- ✅ Buscar destinos por nome ou localização
- ✅ Adicionar avaliações (nota + comentário) aos destinos
- ✅ Cálculo automático da média de avaliações

---

## 🛠️ Tecnologias

- Java 25
- Spring Boot 3.5
- Maven
- Spring Web

---

## 📋 Endpoints

### Destinos

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/destinos` | Criar um novo destino |
| GET | `/api/destinos` | Listar todos os destinos |
| GET | `/api/destinos/{id}` | Buscar destino por ID |
| GET | `/api/destinos/buscar?nome={nome}` | Buscar por nome |
| GET | `/api/destinos/buscar?localizacao={localizacao}` | Buscar por localização |
| PUT | `/api/destinos/{id}` | Atualizar destino |
| DELETE | `/api/destinos/{id}` | Excluir destino |

### Avaliações

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| POST | `/api/destinos/{id}/avaliacoes` | Adicionar avaliação |

---

## ▶️ Como rodar

```bash
mvn spring-boot:run
