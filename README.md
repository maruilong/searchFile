# searchFile

根据关键字和路径查找文件

入口:com.shinian.searchfile.Application



```java
 Pattern pattern = Pattern.compile("条件");// 这里面是条件   
 Matcher matcher = pattern.matcher("");// 这里不填在里面进行替换
 // 你要搜索的路径
 searchFile("d://blog", matcher);
```


我的个人博客: [马睿隆](http://www.itmasir.com)