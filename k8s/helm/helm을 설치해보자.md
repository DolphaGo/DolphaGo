- 헬름 설치 : https://helm.sh/ko/docs/intro/install/


> Homebrew로 (맥OS)
헬름 커뮤니티 멤버들은 Homebrew용 헬름 포뮬러 빌드에 기여해왔다. 이 포뮬러는 보통 최신이다.

```
brew install helm
```

다음을 참고하여, VirtualBox, Vagrant, k8s 설치 스크립트를 실행한다.

https://kubetm.github.io/k8s/02-beginner/cluster-install-case6/#6-%EB%8C%80%EC%8B%9C%EB%B3%B4%EB%93%9C-%EC%A0%91%EA%B7%BC

그리고 마지막으로 Cluster 연결을 위해 Worker node도 같이 연결을 해준다.

master node 에서 가져온 정보를 가지고, 자식 노드에 붙여넣기를 해준다.

```
kubeadm join 192.168.56.30:6443 --token b0hlcy.9xktxt2v8uezofwz --discovery-token-ca-cert-hash sha256:a5624c0f4bcc728d557766174039173db85889159a0866144e62d00c3eaeeb01
```

그러면 다음과 같이 kubernetes 클러스터가 완성되었다.

![](/images/2024-07-31-14-04-37.png)