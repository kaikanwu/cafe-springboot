# cafe-springboot

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