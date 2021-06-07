# Spring Web
> Web MVC功能测试台
[更详细的文档 雷丰阳](https://www.yuque.com/atguigu/springboot/vgzmgh)
> 
## 初始化工程
```shell
Quick setup — if you’ve done this kind of thing before
or	
git@github.com:xconfigurator/test-web.git
Get started by creating a new file or uploading an existing file. We recommend every repository include a README, LICENSE, and .gitignore.

…or create a new repository on the command line
echo "# test-web" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin git@github.com:xconfigurator/test-web.git
git push -u origin main
…or push an existing repository from the command line
git remote add origin git@github.com:xconfigurator/test-web.git
git branch -M main
git push -u origin main
…or import code from another repository
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.

```


## 笔记
1. 静态资源位置测试
http://localhost:8080/ps.jpg    /static                 ok  
http://localhost:8080/pp.jpg    /public                 ok  
http://localhost:8080/pmr.jpg   /META-INF/resources     ok  
http://localhost:8080/prc.jpg   /resources              ok  

>存放在静态资源子文件夹下   
http://localhost:8080/bugsub.jpg                /static/subfolder    fail
http://localhost:8080/subfolder/bugsub.jpg      /static/subfolder    fail  

http://localhost:8080/prp.jpg   /                       fail  
http://localhost:8080/px.jpg    不在以上路径的情况         fail  


配置上之后
```yml
spring:
  mvc:
    static-path-pattern: /res/**
```
http://localhost:8080/ps.jpg
变为
http://localhost:8080/res/ps.jpg  
但资源在工程中存放的路径不变。如果想要指定工程中存放路径的位置使用
```yml
spring:
  mvc:
    static-path-pattern: /res/**

  resources:
    static-locations: [classpath:/haha/]
```

2. Welcome与favicon  
Welcome
   - 默认 写个index.html放在静态资源路径下
   - 订制 registry.addViewController("/").setViewName("liuyang_welcome.html"); 优先级高于默认的欢迎页。
favicon放置在静态资源内目录下即可
   - 注意把浏览器缓存彻底清掉（或者F12后选择禁用缓存）然后重新打开（只要浏览器不关就是同一次会话，只要第一次没出来，那么后面都不会出来。）
   - FaviconConfig.java还没调试通(所以目前(2021/5/22)如果指定了静态文件的统一访问路径，则favicon则失效。)
3. 


### Web原生组件注入
[文档](https://www.yuque.com/atguigu/springboot/vgzmgh#xnb02)
```Java
@Configuration
public class MyRegistConfig {

    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet = new MyServlet();

        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }


    @Bean
    public FilterRegistrationBean myFilter(){

        MyFilter myFilter = new MyFilter();
//        return new FilterRegistrationBean(myFilter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        MySwervletContextListener mySwervletContextListener = new MySwervletContextListener();
        return new ServletListenerRegistrationBean(mySwervletContextListener);
    }
}
```