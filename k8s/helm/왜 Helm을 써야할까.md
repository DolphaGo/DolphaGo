> Helm?

Helm 은 Kubernetes 패키지 매니저입니다.

> 왜 Helm 을 써야할까요?

- yaml은 정적파일이기 때문에 리소스 별로 yaml 파일을 만들어야 합니다.
- 많은 리소스를 관리하게 될 때 yaml 파일에 대한 유지보수가 힘들어지게 됩니다.
- 하나의 Template을 통해 yaml 파일을 동적으로 생성하게 해주는 Tool이 필요합니다.

**이것을 가능하게 해주는 것이 Helm 입니다.**

Helm 을 사용하면, 중복으로 사용하는 yaml 을 쉽게 사용할 수 있게 된다.

묶음으로 사용하는 yaml 들을 하나의 패키지로 설정하여 간단하게 배포가 가능하다.

ex)

- AS-IS
```
kubectl create dev-app1-service.yaml
kubectl create dev-app1-pod.yaml
kubectl create dev-app1-configmap.yaml
```

- TO-BE

```
helm install -app='app1' -env='dev'
```


또 하나의 장점으로, 헬름을 잘 알면 오픈소스들을 쉽게 쿠버네티스에 배포할 수가 있게 됩니다.

각 회사에서는 누구나 자신의 솔루션을 쉽게 커스터마이징해서 사용할 수 있도록 하는 것이 목표일 것입니다.
(ex, hadoop, vault, jenkins, kibana, mongodb 등등)


> 정리

헬름을 사용하면 좋은 이유.

1. 내 업무 환경별로 배포를 쉽게하기 위해서 -> 배우는 것 : 나만의 헬름 차트 만들기
2. 오픈소스를 쉽게 설치하기 위해서 -> 배우는 것 : 오픈 소스 헬름 차트 분석 및 헬름으로 오픈 소스 설치해보기
