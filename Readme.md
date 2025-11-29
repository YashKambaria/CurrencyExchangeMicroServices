# Docker

## Images

- https://hub.docker.com/repositories/yashkambaria
- Currency Exchange Service
    - yashkambaria/yash-mmv2-currency-exchange-service:0.0.1-SNAPSHOT
- Currency Conversion Service
    - yashkambaria/yash-mmv2-currency-conversion-service:0.0.1-SNAPSHOT
- Eureka
    - yashkambaria/yash-mmv2-naming-server:0.0.1-SNAPSHOT
- API GATEWAY
    - yashkambaria/yash-mmv2-api-gateway:0.0.1-SNAPSHOT

## URLS

#### Currency Exchange Service
- http://localhost:8000/currency-exchange/from/USD/to/INR

#### Currency Conversion Service
- http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

#### Eureka
- http://localhost:8761/

#### Zipkin
- http://localhost:9411/

#### API GATEWAY
- http://localhost:8765/currency-exchange/from/USD/to/INR
- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10

#### Commands
```
docker-compose --version
docker-compose up
```