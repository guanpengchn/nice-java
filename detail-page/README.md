## 启动

```shell
$ mvn clean install && mvn spring-boot:run -pl detail-start
```


## 架构

主要分为 3 层结构

- 视图展示层：Component 提供给前端完整的 VO，使用注解 @Contain
- 业务逻辑层：Ability 提供给上层 BO，使用注解 @Have
- 服务调用层：RPC 调用获取远程服务数据结果

Component 与 Component 之间的关系

```java
// 第一屏组件
class FirstScreenComponent {
    @Contain
    private TitleComponent titleComponent;
    
    @Contain
    private PriceComponent priceComponent;
}
```


Component 与 Ability 之间的关系

```java
// 标题组件
class TitleComponent {
    @Have
    private TitleAcility titleAcility;
    
    @Have
    private PriceAbility priceAbility;
    
    private TitleVO titleVO;
    
    private boolean checking(RequestParam param) {
        return true;
    }
    
    private void init(RequestParam param) {
        this.titleVO = titleAcility.getTitleBO();
    }
}
```

Ability 与 Ability 之间的关系

```java
// 标题能力
class TitleAcility {
    @Have
    private PriceAbility priceAbility;
    
    @Have
    private TagAbility tagAbility;
    
    private TitleBO titleBO;
    
    private boolean checking(RequestParam param) {
        return true;
    }
        
    private void init(RequestParam param) {
        RpcResult result = TitleService.getTitleFromRemote();
        this.titleBO = result.getName() + priceAbility.getPriceBO() + tagAbility.getTagBO();
    }
}
```

服务层

```java
class TitleService {
    private RpcResult getTitleFromRemote(){
        try {
            // 这里是远程服务提供的函数，不在本地
            return remoteRpcService.getRpcResult();
        } catch (Exception e) {
            
        }
    }
}
```


- Ability 中无法 @Contain Component
- 禁止在Component中既使用@Contain也使用@Have
- 分析依赖关系之后Ability层进行并发调用，提升效率

## 工作

1. 实现注解和注入，并成功返回组件结构
2. 实现并行化加载Ability
3. 实现RPC用于实验