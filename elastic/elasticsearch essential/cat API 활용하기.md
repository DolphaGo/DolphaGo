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

> 언제 활용하면 좋을까요?

- 노드들의 디스크 사용량 확인
- 노드들이 명확한 역할을 수행하고 있는 지 확인
- 어떤 노드가 마스터 노드인지 확인
- 노드들의 메모리 사용량 확인

> 정리

- cat API는 클러스터의 다양한 정보를 사람이 읽기 쉬운 형태로 보여주기 위한 용도의 api 입니다.
- cat health는 클러스터의 상태에 대한 정보를 보여줍니다.
- cat nodes 는 클러스터 내의 노드들에 대한 상태 정보를 보여줍니다.

## cat indices

- 인덱스의 상태를 확인할 수 있습니다.

```
GET _cat/indices?bytes=b&s=store.size:desc,index:asc&v=true
```

```
health status index            uuid                   pri rep docs.count docs.deleted store.size pri.store.size dataset.size
yellow open   my-index-000001  u8FNjxh8Rfy_awN11oDKYQ   1   1       1200            0      72171         72171         72171
green  open   my-index-000002  nYFWZEO7TUiOjLQXBaYJpA   1   0          0            0        230          230            230
```

- status 는 open/close 2개의 상태가 있는데, close는 색인/검색이 불가능한 인덱스를 의미합니다.
- store.size: 인덱스 전체 데이터 크기, 프라이머리 샤드, 레플리카 샤드 모두 포함하고
- pri.store.size: 프라이머리의 크기를 의미합니다.
- cat health 에서 볼 수 있는 정보와 cat indices에서 볼 수 있는 health에 어떤 관계가 있을까?

> cat health 에서 봤던 상태 정보를 cat indices에서도 볼 수 있습니다. 

- **사실 클러스터의 상태는 인덱스의 상태라고 보면 됩니다.**
- 1개 이상의 인덱스가 yellow -> 클러스터도 yellow
- 1개 이상의 인덱스가 red -> 클러스터도 red

어떤 인덱스가 문제가 있는 지 확인하기 위해서 cat indices가 필요한 것입니다.

> 언제 활용하면 좋을까?

- 인덱스들의 프라이머리 샤드 개수와 레플리카 개수 확인할 때
- 이상 상태인 인덱스를 확인할 때
- cat indices | grep yellow => yellow 상태의 인덱스만 추려낼 수 있겠습니다.

## cat shards

- 샤드의 상태를 확인할 수 있습니다.

![](/images/2024-06-02-15-54-29.png)

위의 상황에서 test2 인덱스의 레플리카 샤드가 unassigned 라면, 이건 yellow 상태라는 것을 알아차릴 수 있을 것이다.

또한 test 인덱스도 unassigned 라서 이 클러스터는 yellow 라는 것을 알 수 있다.


**cat shards 도 cat nodes와 마찬가지로 더 많은 정보를 볼 수 있습니다.**

-> `?help` 이용합니다.

![](/images/2024-06-02-15-56-03.png)

`unassigned.reason`를 확인합니다. (기본이 아니기 때문에 추가를 해주어서 확인해봅니다.)

# cat shards 는 언제 활용하면 좋을까요?

- 이상 상태인 샤드들 확인
- 샤드들의 이상 상태 원인 확인