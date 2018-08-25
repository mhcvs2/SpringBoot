<pre><code>
1. 查询加密状态
curl http://ceres:cloudpi123@localhost:9999/encrypt/status  
{"status":"OK"}  

2. 加密
# curl http://ceres:cloudpi123@localhost:9999/encrypt -d srcb@2018
993161331fb97266c8f88a488ff12198405215abbbc02ec958e96571224dc133

3. 解密
# curl http://ceres:cloudpi123@localhost:9999/decrypt -d 993161331fb97266c8f88a488ff12198405215abbbc02ec958e96571224dc133
srcb@2018

4. 配置里这样写
foo = {cipher}993161331fb97266c8f88a488ff12198405215abbbc02ec958e96571224dc133
client读取时会自动解密
<code></pre>