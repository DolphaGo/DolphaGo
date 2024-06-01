# cat API 란?

- Compact and Aligned Text (CAT) APIs 의 약자이며, 클러스터의 정보를 사람이 읽기 편한 형태로 출력하기 위한 용도로 만들어진 API 입니다!

- UI 기반 모니터링 시스템이 원인 파악에 더 편하지만, cat API는 상황을 빠르게 판단하는데 도움이 됩니다.
- cat API는 20개 이상의 API를 제공하고 있습니다. (8.x 기준)

- https://www.elastic.co/guide/en/elasticsearch/reference/current/cat.html

![](/images/2024-06-01-21-29-46.png)

앞으로는 가장 많이 사용되는 4개의 api를 살펴보겠습니다.

## cat health

- ElasticSearch 클러스터의 전반적인 상태를 확인할 수 있습니다.
- 가장 기본이 되면서 중요한 api

```
GET /_cat/health?v=true
```

- 여기서 v 는 verbose 의 약자입니다. 더 자세한 응답을 볼수 있습니다.

```
epoch      timestamp cluster       status node.total node.data shards pri relo init unassign pending_tasks max_task_wait_time active_shards_percent
1475871424 16:17:04  elasticsearch green           1         1      1   1    0    0        0             0                  -                100.0%
```

- relo 는 재배치가 일어나고 있는 샤드를 의미합니다.
- init 은 초기화를 의미합니다.
- unassign: 샤드들 중에 노드에 배치가 되지 않은 샤드의 수를 의미합니다.
![](/images/2024-06-01-21-33-34.png)


> cat api는 언제 활용하면 좋을까요?

- 클러스터의 상태 확인할 때 활용하면 됩니다.
- 클러스터가 이상해요 ㅠㅠ 하면 cat api health 를 체크하면 됩니다.

## cat nodes

- 노드들의 전반적인 상태를 확인할 수 있습니다.

```
GET /_cat/nodes?v=true
```

```
ip        heap.percent ram.percent cpu load_1m load_5m load_15m node.role master name
127.0.0.1           65          99  42    3.07                  dim       *      mJw06l1
```


- ram.percent: 사용된 총 메모리 양


그런데 기본적인 정보로 확인 가능한 정보는 제한적입니다.

사실 cat nodes는 더 자세하게 볼 수 있기도 합니다.

```
GET /_cat/nodes?help
```

사용법은 다음과 같다.
```
GET /_cat/nodes?v=true&h=id,ip,port,v,m
```

```
id   ip        port  v         m
veJR 127.0.0.1 59938 8.13.4 *
```

