#关于maven的使用规则

##多环境配置

        <profiles>
            <!-- 指定第一个环境：id为 dev，执行  mvn  -P dev 时会激活该配置-->
            <profile>
              <id>dev</id>
              <properties>
                <!--   定义一个env=dev的变量-->
                <env>dev</env>
              </properties>
              <activation>
                <activeByDefault>true</activeByDefault>
              </activation>
            </profile>
            <profile>
              <id>daily</id>
              <properties>
                <env>daily</env>
              </properties>
            </profile>
          </profiles>
          
          
## build讲解


      <build>
        <finalName>example</finalName>
         <!-- 变量来源   此文件中配置的变量 将替换资源文件中的变量值 -->  
          <filter>${basedir}/src/main/resources/conf/${env}_config.properties</filter>
        </filters>
        <!--指定资源目录 配置是否启用资源过滤（就是是否启用占位符替换）-->
        <resources>
          <resource>
            <directory>src/main/resources</directory>
            <filtering>true</filtering>
          </resource>
        </resources>
      </build>
      
## 总结
      
 1.   -P 参数 配合资源过滤Filter，最终使用了 src/main/resources/log-profile-product.properties 文件
 2.  这个配置文件就是为可以使用占位符的logback.xml文件提供对应 的值
 3. 激活profile和spring的profile有点志同道合，maven的这个配置激活还可以用到很多方面，例如开发环境用快照仓库（版本），生产用发布仓库
 
 
 ## resources 标签中include 和 exclude
 
     <resources>  
         <!-- Filter jdbc.properties & mail.properties. NOTE: We don't filter applicationContext-infrastructure.xml,   
             let it go with spring's resource process mechanism. -->  
         <resource>  
             <directory>src/main/resources</directory>  
             <filtering>true</filtering>  
             <includes>  
                 <include>jdbc.properties</include>  
                 <include>mail.properties</include>  
             </includes>  
         </resource>  
         <!-- Include other files as resources files. -->  
         <resource>  
             <directory>src/main/resources</directory>  
             <filtering>false</filtering>  
             <excludes>  
                 <exclude>jdbc.properties</exclude>  
                 <exclude>mail.properties</exclude>  
             </excludes>  
         </resource>  
     </resources>  
     
     
 其中第一段<resource>配置声明：在src/main/resources目录下，
 仅jdbc.properties和mail.properties两个文件是资源文件，
 然后，这两个文件需要被过滤。而第二段<resource>配置声明：
 同样在src/main/resources目录下，除jdbc.properties和mail.properties两个文件外的其他文件也是资源文件，
 但是它们不会被过滤。
 
 总结：
        include ：指出哪些文件是资源文件
        exclude：排除某些资源文件
        filtering：true：指定的文件中变量被替换。false：不替换       
 