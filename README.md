# cafe-springboot
主要业务逻辑：
用户调用 Settlement 服务接口来生成结算单，然后调用 Payment 支付接口来支付订单，或者取消订单。

数据表
- account   账户表
- product   产品表
- wallet    用户钱包
- stock     商品库存
- payment   支付

包结构
- interfaces     对外接口
- application
- infrastructure 配置类

业务调用：
- Account 账号服务，关联 account 表
- Payment 支付服务，关联 payment, wallet 表
- Product 商品服务，关联 product, stock 表

接口信息：
- Account
  - Create
  - Get
  - Update
- Payment
- Product
  - CreateProduct
  - UpdateProduct
  - DeleteProduct
  - FindAllProducts
  - FindById
  - FindStackByProductId
  - UpdateStock
- Settlement
  - settlement

组件： 
- Web 框架：Spring Boot
- Web 服务器：Tomcat
- ORM 框架：hibernate
- 关系型数据库：MySQL
- 本地缓存：Caffeine