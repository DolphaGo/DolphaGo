# 쿼리 스트링과 쿼리 DSL

- 엘라스틱 서치에서 쿼리를 사용하는 방법
  - 쿼리 스트링 : 한 줄 정도의 간단한 쿼리에 사용
  - 쿼리 DSL : 복잡한 쿼리에 사용


## 쿼리 스트링
- 쿼리 스트링은 REST API의 URI 주소에 쿼리문을 작성하는 방식 -> 실행 쉽다
- 복잡한 논리 조건의 경우 괄호를 이용해야 해서 가독성이나 오류/실수 범하기 쉽다

> 실행

```
GET kibana_sample_data_ecommerce/_search?q=customer_full_name:Mary
```
- kibana_sample_data_ecommerce 인덱스 중에 `customer_full_name` 필드에 `Mary`라는 용어가 포함된 도큐먼트를 검색한다.

![](/images/2022-04-04-01-29-09.png)

- 간단한 검색을 할 대 사용하기 편리하고, curl 툴에서 한줄에 작성할 수 있어서 타이핑하기 편하다. 
- 대신 한 줄에 모든 쿼리를 작성해야 한다는게 복잡할 수록 사용성은 떨어진다.

## 쿼리 DSL

- 쿼리 DSL은 REST API의 요청 본문안에 JSON 형태로 쿼리를 작성한다.
- 쿼리 DSL은 엘라스틱 서치의 모든 쿼리 스펙을 지원하기에 강력하고, 복잡한 쿼리를 구현할 수 있음.
- 하지만 단순하면 굳이 이거를 쓸 필요는 없을 것(쿼리스트링이 간단한 것에 좋으니)

> 쿼리 DSL 예시

```json
GET kibana_sample_data_ecommerce/_search
{
  "query": {
    "match": {
      "customer_full_name": "Mary"
    }
  }
}
```
- 전문 검색을 할 수 있는 Match 쿼리다.
- customer_full_name에 `Mary`가 포함된 모든 도큐먼트를 검색한다.
- 결과는 쿼리 스트링의 결과와 같다.

![](/images/2022-04-04-02-00-13.png)





