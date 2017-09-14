
**下一步**
- 全面实现自动装配
- 表格展示
- 不用Bootstrap 换成Jquery UI
- notes 可以用Axaj并且用静态数据,quartz定时生成静态json数据
- 写入文件中
- 做后台管理，接口化

<br/>

----------------------------------------------------
##### 1、spring 控制反转和依赖注入的含义
#### 2、spring 都有那些注解,注解的含义以及区别
###### 2.1 用`@Autowired` 它的存在将告知Spring容器需要为当前对象注入哪些依赖对象。
###### 2.2 `@Component` 对相关类进行标记 则是配合Spring 2.5中新的classpath-scanning功能使用的`<context:component-scan>`默认扫描的注解类型是 @Component
###### 2.3 使用 `@Qualifier` 对依赖注入的条件做进一步限定
###### 2.4 `@Resource` IoC容器将根据 @Resource 所指定的名称，到容器中查找 beanName 与之对应的实例，然后将查找到的对象实例注入给 @Resource 所标注的对象
###### 2.5  `@PostConstruct` 和 `@PreDestroy` 不是服务于依赖注入的，它们主要用于标注对象生命周期管理相关方法
##### 3、MVC分层含义
##### 4、常用的集合类   ArrayList和LinkedList的区别
##### 5、servlet线程安全吗？
##### 6、quartz的框架理解以及异常处理
##### 7、web services框架
##### 8、泛型


---------------------------------
# 一些要掌握的知识
- 学习数据结构，主攻**HashMap**，**ArrayList**，**LinkedList**。
- 学习排序算法，主攻快速排序，归并排序。
- 学习计算机网络，主攻http协议，TCP/IP协议，熟记三次握手，四次挥手的过程。
- 学习多线程编程，了解线程安全的概念。
- 学习设计模式，主攻工厂模式，单例模式。