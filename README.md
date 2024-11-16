# Metric Monitoring

## 프로젝트 설명
Metric Monitoring은 시스템 메트릭을 실시간으로 모니터링하고 알림을 제공하는 Java 기반 애플리케이션입니다. 

Prometheus와 Grafana를 통해 효율적인 시각화와 분석이 가능하며, 이메일 알림 기능을 포함하고 있습니다.


## 주요기능

✅ 스케줄 기반 메트릭 모니터링

- CPU 사용량 등 시스템 메트릭을 주기적으로 모니터링.
- 임계값을 초과할 경우 경고 알림 전송.

✅ 이메일 알림 기능

- 임계값 초과 시 자동으로 이메일 알림 전송.
- JavaMailSender를 사용하여 손쉽게 이메일 설정 가능.

✅ Docker 통합 지원
- Docker 및 Docker Compose를 활용하여 간편하게 애플리케이션 배포.

✅ Prometheus 및 Grafana 연동
- Prometheus를 활용한 메트릭 수집.
- Grafana를 통해 실시간 대시보드로 시스템 상태 시각화.

## 기술 스택
- Java 21
- Gradle
- Docker and Docker Compose
- Prometheus
- Grafana

## 실행 방법

- application.yml 파일에서 ${EMAIL_USERNAME}, ${EMAIL_PASSWORD}, ${NOTIFIER_RECIPIENT_EMAIL} 정보 업데이트 후 실행

```yaml
spring:
  mail:
    host: smtp.gmail.com
    port: 587
    username: ${EMAIL_USERNAME}
    password: ${EMAIL_PASSWORD}
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
notifier:
  recipient-email: ${NOTIFIER_RECIPIENT_EMAIL}
  title: Threshold Exceeded Warning. CPU usage is high!
  content: Current CPU usage has exceeded the threshold.
```
