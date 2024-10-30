# 🎮 GameVerse API

*Unified Gaming Knowledge Hub & Interactive Platform*

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15%2B-blue.svg)](https://www.postgresql.org/)
[![Redis](https://img.shields.io/badge/Redis-7.2-red.svg)](https://redis.io/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## 📖 Overview

GameVerse API is a comprehensive gaming content management and distribution platform designed to be the definitive reference point for developers, content creators, and gaming enthusiasts. This modular and scalable API provides structured access to an extensive knowledge base about video games, characters, consoles, developers, and industry companies.

## 🚀 Features

- **Complete & Structured Data**: Detailed relational information about all aspects of the gaming world
- **Dual API Support**: REST (HATEOAS) and GraphQL support for maximum flexibility
- **Modular Architecture**: Expandable design allowing for new domain additions
- **Interactive Community**: Integrated rating, comment, and discussion system
- **Optimized Performance**: Multi-level caching and advanced search capabilities
- **Multilingual Support**: English/Spanish content management

## 🛠 Tech Stack

- **Java 21**: Latest LTS version with modern features
- **Spring Boot 3.3.5**: Core framework
- **PostgreSQL**: Primary database
- **Redis**: Caching layer
- **Meilisearch**: Search engine
- **JWT**: Authentication
- **OpenAPI/Swagger**: API documentation
- **Spring HATEOAS**: REST compliance
- **GraphQL**: Flexible data querying

## 🏗 Project Structure

```
GameVerseAPI/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/gameverse/api/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── model/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       ├── security/
│   │   │       └── util/
│   │   └── resources/
│   │       ├── db/migration/
│   │       ├── graphql/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## 🚦 Getting Started

### Prerequisites

- JDK 21
- Maven 3.8+
- PostgreSQL 15+
- Redis 7.2+
- Docker (optional)

### Local Development Setup

1. **Clone the repository**
```bash
git clone https://github.com/lgzarturo/GameVerseAPI.git
cd GameVerseAPI
```

2. **Configure environment variables**
```bash
cp .env.example .env
# Edit .env with your configuration
```

3. **Setup Database**
```bash
# Using Docker
docker-compose up -d postgres redis

# Or connect to existing services by configuring application.properties
```

4. **Build and Run**
```bash
mvn clean install
mvn spring-boot:run
```

5. **Verify Installation**
- Swagger UI: http://localhost:8080/swagger-ui.html
- GraphQL Playground: http://localhost:8080/graphiql
- Health Check: http://localhost:8080/actuator/health

## 📚 Documentation

- [API Documentation](http://localhost:8080/swagger-ui.html)
- [Development Guide](docs/development-guide.md)
- [Deployment Guide](docs/deployment-guide.md)
- [Contributing Guide](CONTRIBUTING.md)

## 🔒 Security

### Authentication

The API uses JWT (JSON Web Tokens) for authentication. Include the token in the Authorization header:

```
Authorization: Bearer <your-token>
```

### Rate Limiting

- Anonymous: 30 requests/minute
- Authenticated: 100 requests/minute
- Premium: 300 requests/minute

## 🧪 Testing

```bash
# Run unit tests
mvn test

# Run integration tests
mvn verify

# Generate test coverage report
mvn jacoco:report
```

## 🚀 Deployment

### Using Docker

```bash
# Build image
docker build -t GameVerseAPI .

# Run container
docker run -p 8080:8080 GameVerseAPI
```

### Manual Deployment

See [Deployment Guide](docs/deployment-guide.md) for detailed instructions.

## 📈 Monitoring

- Health: `/actuator/health`
- Metrics: `/actuator/metrics`
- Info: `/actuator/info`

## 🗺 Roadmap

- [x] Core Module Implementation
- [x] Basic Games Module
- [ ] Characters Module
- [ ] Companies Module
- [ ] Community Features
- [ ] Analytics Integration

## 🤝 Contributing

Contributions are welcome! Please read our [Contributing Guide](CONTRIBUTING.md) for details on our code of conduct and the process for submitting pull requests.

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE.md) file for details.

## 🙋‍♂️ Support

- Create an issue
- Email: lgzarturo@gmail.com
- Documentation: [Wiki](https://github.com/lgzarturo/GameVerseAPI/wiki)

## 🌟 Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [Redis](https://redis.io/)
- All our contributors and community members

---
Made with ❤️ by Arturo López
