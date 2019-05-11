点击菜单run -> edit configurations -> maven -> command line  填写 mybatis-generator:generate -e

working directory选项目所在路径




单元测试

@BeforeClass 在所有测试方法前执行一次，一般在其中写上整体初始化的代码

@AfterClass 在所有测试方法后执行一次，一般在其中写上销毁和释放资源的代码

@Before 在每个测试方法前执行，一般用来初始化方法（比如我们在测试别的方法时，类中与其他测试方法共享的值已经被改变，为了保证测试结果的有效性，我们会在@Before注解的方法中重置数据）

@After 在每个测试方法后执行，在方法执行完成后要做的事情

@Test(timeout = 1000) 测试方法执行超过1000毫秒后算超时，测试将失败

@Test(expected = Exception.class) 测试方法期望得到的异常类，如果方法执行没有抛出指定的异常，则测试失败

@Ignore(“not ready yet”) 执行测试时将忽略掉此方法，如果用于修饰类，则忽略整个类

@Test 编写一般测试用例

@RunWith 在JUnit中有很多个Runner，他们负责调用你的测试代码，每一个Runner都有各自的特殊功能，你要根据需要选择不同的Runner来运行你的测试代码。