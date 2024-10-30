# GameVerse API Deployment Guide

This comprehensive guide details the development and deployment processes for the GameVerse API project.

## Table of Contents
- [Development Environment Setup](#development-environment-setup)
- [Local Development](#local-development)
- [Development Workflow](#development-workflow)
- [Environment Configuration](#environment-configuration)
- [Deployment Process](#deployment-process)
- [Infrastructure Setup](#infrastructure-setup)
- [Monitoring and Maintenance](#monitoring-and-maintenance)

## Development Environment Setup

### Required Software
- JDK 21
- Maven 3.8+
- Docker Desktop
- Git
- IDE (recommended: IntelliJ IDEA)
- Redis CLI (optional)
- PostgreSQL Client (optional)

### Initial Setup

1. **Clone the Repository**
```bash
git clone https://github.com/lgzarturo/GameVerseAPI.git
cd GameVerseAPI
```

2. **Install Dependencies**
```bash
mvn clean install
```

3. **Setup Development Database**
```bash
# Using Docker Compose
docker-compose up -d postgres redis
```

4. **IDE Configuration**
- Install Lombok plugin
- Enable annotation processing
- Configure Google Java Format
- Set JDK 21 as project SDK

## Local Development

### Running the Application

1. **Development Mode**
```bash
# Run with development profile
mvn spring-boot:run -Dspring.profiles.active=dev
```

2. **Using Docker**
```bash
# Build and run with Docker
docker-compose up --build
```

### Development URLs
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- GraphQL Playground: http://localhost:8080/graphiql
- Health Check: http://localhost:8080/actuator/health

## Development Workflow

### Branch Strategy
```
main
├── develop
│   ├── feature/new-feature
│   ├── bugfix/bug-description
│   └── enhancement/enhancement-description
└── release/v1.x.x
    └── hotfix/urgent-fix
```

### Workflow Steps
1. Create feature branch from `develop`
2. Develop and test locally
3. Run all checks:
```bash
# Run all checks
mvn clean verify

# Run specific checks
mvn checkstyle:check
mvn spotbugs:check
mvn pmd:check
```
4. Create Pull Request
5. Code Review
6. Merge to `develop`

## Environment Configuration

### Configuration Files
```
src/main/resources/
├── application.yml
├── application-dev.yml
├── application-staging.yml
└── application-prod.yml
```

### Environment Variables
```properties
# Required Environment Variables
GAMEVERSE_DB_URL=jdbc:postgresql://localhost:5432/gameverse
GAMEVERSE_DB_USERNAME=dbuser
GAMEVERSE_DB_PASSWORD=dbpass
GAMEVERSE_REDIS_HOST=localhost
GAMEVERSE_REDIS_PORT=6379
GAMEVERSE_JWT_SECRET=your-secret-key

# Optional Environment Variables
GAMEVERSE_API_RATE_LIMIT=100
GAMEVERSE_CACHE_TTL=3600
```

## Deployment Process

### Building for Production

1. **Create Production Build**
```bash
# Build JAR
mvn clean package -Pprod -DskipTests

# Build Docker image
docker build -t GameVerseAPI:latest .
```

2. **Testing Production Build**
```bash
# Run production build locally
java -jar target/GameVerseAPI.jar --spring.profiles.active=prod
```

### Deployment Steps

1. **Pre-deployment Checklist**
- [ ] All tests passing
- [ ] Security scan completed
- [ ] Database migrations ready
- [ ] Environment variables configured
- [ ] Backup strategy in place
- [ ] Rollback plan prepared

2. **Database Migration**
```bash
# Run Flyway migrations
mvn flyway:migrate -Dflyway.configFiles=flyway.conf
```

3. **Deployment Commands**
```bash
# Deploy to Digital Ocean
doctl apps create --spec .do/app.yaml

# Update existing deployment
doctl apps update APP_ID --spec .do/app.yaml
```

## Infrastructure Setup

### Digital Ocean Configuration

1. **Droplet Setup**
```bash
# App Droplet
doctl compute droplet create GameVerseAPI \
    --size s-2vcpu-4gb \
    --image ubuntu-22-04-x64 \
    --region nyc1

# Database Droplet
doctl compute droplet create gameverse-db \
    --size s-2vcpu-4gb \
    --image ubuntu-22-04-x64 \
    --region nyc1
```

2. **Networking**
```bash
# Create network
doctl networking vpc create gameverse-network

# Configure firewall
doctl compute firewall create \
    --name gameverse-firewall \
    --inbound-rules "protocol:tcp,ports:80,443,8080"
```

### Infrastructure Diagram
```
[Load Balancer] --> [App Droplets]
                        ├── [Redis Cache]
                        └── [PostgreSQL]
```

## Monitoring and Maintenance

### Health Checks

1. **Application Health**
```bash
# Check application health
curl http://your-domain/actuator/health

# Check specific component
curl http://your-domain/actuator/health/db
```

2. **Performance Monitoring**
```bash
# Memory usage
curl http://your-domain/actuator/metrics/jvm.memory.used

# HTTP request metrics
curl http://your-domain/actuator/metrics/http.server.requests
```

### Backup Strategy

1. **Database Backups**
```bash
# Automated daily backup
0 0 * * * pg_dump -Fc gameverse > /backups/gameverse-$(date +%Y%m%d).dump

# Restore from backup
pg_restore -d gameverse backup_file.dump
```

2. **Application Logs**
```bash
# Collect logs
journalctl -u GameVerseAPI.service > gameverse-$(date +%Y%m%d).log

# Analyze logs
grep ERROR gameverse-*.log | sort | uniq -c
```

### Maintenance Tasks

1. **Regular Maintenance**
- Daily log rotation
- Weekly dependency updates
- Monthly security patches
- Quarterly performance review

2. **Emergency Procedures**
```bash
# Quick rollback
doctl apps rollback APP_ID --deployment-id DEPLOYMENT_ID

# Emergency shutdown
doctl apps stop APP_ID
```

## Troubleshooting

### Common Issues

1. **Database Connectivity**
```bash
# Check database connection
psql -h $DB_HOST -U $DB_USER -d gameverse -c "\dt"

# Reset database connection pool
curl -X POST http://your-domain/actuator/restart
```

2. **Memory Issues**
```bash
# Check memory usage
free -m
docker stats

# Clear Redis cache
redis-cli FLUSHALL
```

### Support Contacts

- Technical Issues
- Infrastructure
- Emergency

Please email me at lgzaturo@gmail.com

---

For additional support or questions, please contact the development team or create an issue in the GitHub repository.

