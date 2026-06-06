本人一介大三学生，因期末大作业与找实习需要项目，只好拿此练手，在百般波折后，终成。
由于校园防火墙的限制我更改了大部分配置同时还在原来的基础上进行完善并添加不少新模块。

## 1. 项目介绍
> Github地址:[https://github.com/CARGOD-hub/taodong-shop/]

本人一介大三学生，因期末大作业与找实习需要项目，只好拿此练手，在百般波折后，终成。
由于校园防火墙的限制我更改了大部分配置同时还在原来的基础上进行完善并添加不少新模块。
(https://blog.csdn.net/qq_20042935/category_9444667_2.html) ，项目采用目前主流的`SpringBoot + SpringCloud`来构建，实现一套完整的微服务解决方案。

![登录界面](<img width="1286" height="650" alt="cd1c34fc00307af282c78701ec0d8720" src="https://github.com/user-attachments/assets/f21f13e0-63e2-4b67-b2da-903400be1cbb" />)

![主页面](<img width="1268" height="712" alt="d7bbe1d730cecd61936607a764107218" src="https://github.com/user-attachments/assets/d11efd93-e453-454e-afd8-0a87cc7d6abd" />）

)
![AI页面](<img width="1875" height="946" alt="微信图片_20260531131854_78_2" src="https://github.com/user-attachments/assets/ed889f9d-c50e-42b1-8125-e18469f08498" />）


## 2. 项目架构图
![项目架构图](https://img-blog.csdnimg.cn/20200614120506781.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzIwMDQyOTM1,size_16,color_FFFFFF,t_70)

## 3. 环境需求
本项目对环境的要求不高

建议电脑配置：
- 在CPU I5
- 内存32GB
- 或者电脑采用集群化部署

开发环境要求：
- JDK统一要求：JDK1.8
- Maven统一管理jar
- 统一采用Docker安装软件
- 编码统一采用UTF-8
- 开发工具IDE或者Eclipse

## 4. 技术选型
### 4.1 SpringBoot2.x+SpringCloud2.x构建微服务电商项目
1. 使用SpringCloud Eureka作为注册中心，实现服务治理
2. 使用Zuul网关框架管理服务请求入口
3. 使用Ribbon实现本地负载均衡器和Feign HTTP客户端调用工具
4. 使用Hystrix服务保护框架（服务降级、隔离、熔断、限流）
5. 使用消息总线Stream RabbitMQ和Kafka
6. 微服务API接口安全控制和单点登录系统CAS+JWT+OAuth2.0

###  4.2 分布式基础设施构建
1. 分布式任务调度平台XXL-JOB
2. 分布式日志采集系统ELK
3. 分布式事务解决方案LCN
4. 分布式锁解决方案Zookeeper、Redis
5. 分布式配置中心（携程Apollo）
6. 高并发分布式全局ID生成（雪花算法）
7. 分布式Session框架Spring-Session
8. 分布式服务追踪与调用链Zipkin
###  4.3 项目运营与部署环境
1. 分布式设施环境，统一采用Docker安装
2. 使用jenkins+docker+k8s实现自动部署
3. 微服务API管理ApiSwagger
4. 使用GitLab代码管理
5. 统一采用第三方云数据库
6. 使用七牛云服务器对静态资源实现加速


## 5. 项目目录结构
taodong-shop-master/
├── taodong-shop-basics/          # 基础服务层
│   ├── eureka                    # 服务注册中心
│   ├── zuul                      # API网关
│   └── xxlsso-server             # 单点登录
├── taodong-shop-service/         # 业务服务层
│   ├── member                    # 会员服务
│   ├── weixin                    # 微信服务
│   ├── auth                      # 认证服务
│   ├── goods                     # 商品服务
│   ├── pay                       # 支付服务
│   ├── integral                  # 积分服务
│   └── spike                     # 秒杀服务
├── taodong-shop-service-api/     # API接口定义
├── taodong-shop-portal/          # 门户层
│   └── portal-web                # 前端门户
├── taodong-shop-common/          # 公共组件
│   ├── core                      # 核心工具类
│   ├── web-core                  # Web工具
│   └── xxlsso-core               # SSO核心
├── taodong-shop-api-dto/         # 数据传输对象
└── taodong-shop-job/             # 定时任务
## 6.功能实现
都啥时代了，环境配置交给AI，不过也可以看看原作者在本节的相关介绍
### 6.1 项目立项&基础设施搭建
- [《淘东电商项目（01） - 需求讨论与技术选型》](https://blog.csdn.net/qq_20042935/article/details/104114076)
- [《淘东电商项目（02） - 项目结构初定》](https://blog.csdn.net/qq_20042935/article/details/104122766)
- [《淘东电商项目（03） - 父类配置》](https://blog.csdn.net/qq_20042935/article/details/104128156)
- [《淘东电商项目（04） - 注册中心及Feign远程调用》](https://blog.csdn.net/qq_20042935/article/details/104132135)
- [《淘东电商项目（05） - Swagger及网关统一管理API》](https://blog.csdn.net/qq_20042935/article/details/104149823)
- [《淘东电商项目（06） - Linux固定IP设置以及安装Docker》](https://blog.csdn.net/qq_20042935/article/details/104246233)
- [《淘东电商项目（07） -GitLab简介以及Docker部署》](https://blog.csdn.net/qq_20042935/article/details/104248677)
- [《淘东电商项目（08） -Docker搭建Maven私服仓库》](https://blog.csdn.net/qq_20042935/article/details/104251876)
- [《淘东电商项目（09） -Maven私服的上传与下载详解》](https://blog.csdn.net/qq_20042935/article/details/104258712)
- [《淘东电商项目（10） -Apollo分布式配置中心管理application.yml》](https://blog.csdn.net/qq_20042935/article/details/104262790)
- [《淘东电商项目（11） -Apollo分布式配置中心管理Swagger》](https://blog.csdn.net/qq_20042935/article/details/104274148)

### 6.2 微信公众号&注册功能
- [《淘东电商项目（12） -搭建企业级微信公众号》](https://blog.csdn.net/qq_20042935/article/details/104278660)
- [《淘东电商项目（13） -项目整合WxJava》](https://blog.csdn.net/qq_20042935/article/details/104314089)
- [《淘东电商项目（14） -公众号获取注册码功能》](https://blog.csdn.net/qq_20042935/article/details/104355051)
- [《淘东电商项目（15） -项目配置信息分类（Apollo Namespace命名空间）》](https://blog.csdn.net/qq_20042935/article/details/104412036)
- [《淘东电商项目（16） -会员注册功能》](https://blog.csdn.net/qq_20042935/article/details/104423787)
- [《淘东电商项目（17） -DTO接口细分》](https://blog.csdn.net/qq_20042935/article/details/104606609)
- [《淘东电商项目（18） -全局异常捕获》](https://blog.csdn.net/qq_20042935/article/details/104627994)
- [《淘东电商项目（19） -日志打印》](https://blog.csdn.net/qq_20042935/article/details/104631478)

### 6.3 会员唯一登录功能
- 《[淘东电商项目（20） -会员唯一登录》](https://blog.csdn.net/qq_20042935/article/details/104634451)
- [《淘东电商项目（21） -Redis如何与数据库状态保持一致？》](https://blog.csdn.net/qq_20042935/article/details/104652464)
- [《淘东电商项目（22） -Canal数据同步框架》](https://blog.csdn.net/qq_20042935/article/details/104657639)
- [《淘东电商项目（23） -门户界面》](https://blog.csdn.net/qq_20042935/article/details/104673329)
- [《淘东电商项目（24） -获取验证码功能》](https://blog.csdn.net/qq_20042935/article/details/104698110)
- [《淘东电商项目（25） -门户注册功能》](https://blog.csdn.net/qq_20042935/article/details/104748222)
- [《淘东电商项目（26） -门户登录功能》](https://blog.csdn.net/qq_20042935/article/details/104777872)
- [《淘东电商项目（27） -门户登出功能》](https://blog.csdn.net/qq_20042935/article/details/104796726)
- [《淘东电商项目（28） -QQ授权登录实现思路》](https://blog.csdn.net/qq_20042935/article/details/104800068)
- [《淘东电商项目（29） -动静分离的实现思路》](https://blog.csdn.net/qq_20042935/article/details/104822219)
- [《淘东电商项目（30） -解决分布式Session共享问题》](https://blog.csdn.net/qq_20042935/article/details/104823374)

### 6.4 会员SSO单点登录功能
- [《淘东电商项目（31） -SSO单点登录（XXL-SSO案例）》](https://blog.csdn.net/qq_20042935/article/details/104899197)
- [《淘东电商项目（32） -SSO单点登录（集成SSO认证服务）》](https://blog.csdn.net/qq_20042935/article/details/104942952)
- [《淘东电商项目（33） -SSO单点登录（改造SSO认证服务登录界面）》](https://blog.csdn.net/qq_20042935/article/details/104945652)
- [《淘东电商项目（34） -SSO单点登录（Client端集成）》](https://blog.csdn.net/qq_20042935/article/details/104960964)
- [《淘东电商项目（35） -SSO单点登录（登录功能完善）》](https://blog.csdn.net/qq_20042935/article/details/104960448)
- [《淘东电商项目（36） -SSO单点登录（退出功能）》](https://blog.csdn.net/qq_20042935/article/details/104969270)
- [《淘东电商项目（37） -SSO单点登录（高可用实现思路）》](https://blog.csdn.net/qq_20042935/article/details/104970234)

### 6.4 分布式日志采集
- [《淘东电商项目（38） -Docker下安装ES&Kibana（一次填完所有的坑）》](https://blog.csdn.net/qq_20042935/article/details/105042719)
- [《淘东电商项目（39） -商品搜索服务数据库设计》](https://blog.csdn.net/qq_20042935/article/details/105121831)
- [《淘东电商项目（40） -Docker下安装Logstash（一次填完所有的坑）》](https://blog.csdn.net/qq_20042935/article/details/105142302)
- [《淘东电商项目（41） -利用Logstash自动同步数据库内容到ES（超详细）》](https://blog.csdn.net/qq_20042935/article/details/105144774)
- [《淘东电商项目（42） -利用Logstash自动同步数据库内容到ES（多文件方式）》](https://blog.csdn.net/qq_20042935/article/details/105244758)
- [《淘东电商项目（43） -MQ与Logstash实现数据库同步到ES的区别》](https://blog.csdn.net/qq_20042935/article/details/105270022)
- [《淘东电商项目（44） -Docker下搭建ElasticSearch集群》](https://blog.csdn.net/qq_20042935/article/details/105271061)
- [《淘东电商项目（45） -Docker下Kibana与Logstash的ES集群配置（一次填完所有的坑）》](https://blog.csdn.net/qq_20042935/article/details/105275268)
- [《淘东电商项目（46） -商品搜索服务功能的实现》](https://blog.csdn.net/qq_20042935/article/details/105291850)
- [《淘东电商项目（47） -商品搜索服务功能的实现(集成拼音分词器)》](https://blog.csdn.net/qq_20042935/article/details/105729469)
- [《淘东电商项目（48） -ELK+Kafka分布式日志收集（原理篇）》](https://blog.csdn.net/qq_20042935/article/details/105732510)
- [《淘东电商项目（49） -ELK+Kafka分布式日志收集（docker下搭建kafka）》](https://blog.csdn.net/qq_20042935/article/details/105838572)
- [《淘东电商项目（50） -ELK+Kafka分布式日志收集（实现篇）》](https://blog.csdn.net/qq_20042935/article/details/105840519)
- [《淘东电商项目（51） -全局异常日志采集（ELK+Kafka）》](https://blog.csdn.net/qq_20042935/article/details/105844382)

### 6.5 聚合支付
- [《淘东电商项目（52） -聚合支付开篇》](https://blog.csdn.net/qq_20042935/article/details/106012692)
- [《淘东电商项目（53） -银联支付案例源码分析》](https://blog.csdn.net/qq_20042935/article/details/106013626)
- [《淘东电商项目（54） -银联支付案例（同步与异步）》](https://blog.csdn.net/qq_20042935/article/details/106074538)
- [《淘东电商项目（55） -支付系统核心表设计》](https://blog.csdn.net/qq_20042935/article/details/106076428)
- [《淘东电商项目（56） -支付系统分布式事务的解决方案》](https://blog.csdn.net/qq_20042935/article/details/106080515)
- [《淘东电商项目（57） -聚合支付（支付令牌接口）》](https://blog.csdn.net/qq_20042935/article/details/106091297)
- [《淘东电商项目（58） -聚合支付（基于设计模式自动跳转支付接口）》](https://blog.csdn.net/qq_20042935/article/details/106100552)
- [《淘东电商项目（59） -聚合支付（集成银联支付）》](https://blog.csdn.net/qq_20042935/article/details/106134636)
- [《淘东电商项目（60） -聚合支付（集成支付宝）》](https://blog.csdn.net/qq_20042935/article/details/106144211)
- [《淘东电商项目（61） -聚合支付（基于模板方法设计模式管理支付回调）》](https://blog.csdn.net/qq_20042935/article/details/106186201)
- [《淘东电商项目（62） -聚合支付（基于模板方法设计模式管理支付回调-支付宝）》](https://blog.csdn.net/qq_20042935/article/details/106188258)
- [《淘东电商项目（63） -聚合支付（多线程日志收集）》](https://blog.csdn.net/qq_20042935/article/details/106192044)
- [《淘东电商项目（64） -聚合支付（XXL-JOB任务调度平台整合）》](https://blog.csdn.net/qq_20042935/article/details/106193791)
- [《淘东电商项目（65） -聚合支付（异步对账）》](https://blog.csdn.net/qq_20042935/article/details/106207027)
- 《[淘东电商项目（66） -聚合支付（基于RabbitMQ解决分布式事务-积分场景）》](https://blog.csdn.net/qq_20042935/article/details/106208027)

### 6.6 互联网安全架构
- [《淘东电商项目（67） -互联网安全架构设计（方法论）》](https://blog.csdn.net/qq_20042935/article/details/106219678)
- [《淘东电商项目（68） -互联网安全架构设计（黑名单拦截及MD5加签）》](https://blog.csdn.net/qq_20042935/article/details/106228936)
- [《淘东电商项目（69） -互联网安全架构设计（XSS攻击防御）》](https://blog.csdn.net/qq_20042935/article/details/106249516)
- [《淘东电商项目（70） -互联网安全架构设计（搭建开放平台-OAuth）》](https://blog.csdn.net/qq_20042935/article/details/106251397)
- [《淘东电商项目（71） -互联网安全架构设计（网关验证AccessToken）》](https://blog.csdn.net/qq_20042935/article/details/106257875)
- [《淘东电商项目（72） -互联网安全架构设计（责任链模式重构网关流程）》](https://blog.csdn.net/qq_20042935/article/details/106260542)

### 6.7 秒杀系统
- [《淘东电商项目（73） -秒杀系统（前端优化)》](https://blog.csdn.net/qq_20042935/article/details/106328547)
- [《淘东电商项目（74） -秒杀系统（库存超卖解决方案）》](https://blog.csdn.net/qq_20042935/article/details/106335883)
- [《淘东电商项目（75） -秒杀系统（用户操作频率限制）》](https://blog.csdn.net/qq_20042935/article/details/106338491)
- [《淘东电商项目（76） -秒杀系统（完整代码实现）》](https://blog.csdn.net/qq_20042935/article/details/106348940)
- [《淘东电商项目（77） -秒杀系统（小结）》](https://blog.csdn.net/qq_20042935/article/details/106354401)
- [《淘东电商项目（78） -秒杀系统（服务保护）》](https://blog.csdn.net/qq_20042935/article/details/106355892)



