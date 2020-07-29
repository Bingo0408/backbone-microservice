# Backbone for microservice - MyBatisPlus

### 创建数据库及表

- 执行 `data.sql`
- 启动应用

## 测试

- 订单信息(throwException字段为true会抛出异常, 插入数据回滚)
    ,"throwException": true
```bash
curl -X POST \
  http://localhost:8081/order/place-order \
  -H 'Content-Type: application/json' \
  -d '{
    "userId": "bingo",
    "productId": "100000",
    "amount": 1
}'
```
确认：order表中订单信息被正常插入

- 库存服务(throwException字段为true会抛出异常, 扣减库存数据回滚)
    ,"throwException": true
```bash
curl -X POST \
  http://localhost:8082/warehouse/reduce-stock \
  -H 'Content-Type: application/json' \
  -d '{
    "productId": "10000",
    "amount": 1
}'
```
确认：warehouse库中product表中库存被正常减扣

- 扣减金额服务(throwException字段为true会抛出异常, 扣减金额数据回滚)
    ,"throwException": true
```bash
curl -X POST \
  http://localhost:8083/payment/reduce-balance \
  -H 'Content-Type: application/json' \
  -d '{
    "userId": "bingo",
    "price": 10
}'
```