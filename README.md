# 单元测试

[教程地址](http://chriszou.com/2016/06/07/android-unit-testing-everything-you-need-to-know.html)

[Mockito 中文文档](https://github.com/hehonghui/mockito-doc-zh)

## 执行单元测试

windows:

```
./gradlew testDebugUnitTest 运行debug的单元测试
./gradlew testReleaseUnitTest 运行release的单元测试
```

测试结果：

```
project_root/app/build/reports/tests/testDebugUnitTest/index.html
project_root/app/build/reports/tests/testReleaseUnitTest/index.html
```

## 开始
一个测试方法主要包括三个部分：

1. setup
2. 执行操作
3. 验证结果

## [JUnit教程笔记](https://github.com/YoungBear/LearningNotesYsx/blob/master/junit/README.md)

## mock
mock就是创建一个类的虚假的对象，在测试环境中，用来替换掉真实的对象，以达到两大目的：

1. **验证这个对象的某些方法的调用情况，调用了多少次，参数是什么等等。**
2. **指定这个对象的某些方法的行为，返回特定的值，或者是执行特定的动作。**

例子：

```
public class LoginPresenter {
    private static final String TAG = "LoginPresenter";

    private final UserManager mUserManager;

    public LoginPresenter(UserManager userManager) {
        mUserManager = userManager;
    }

    public void login(String username, String password) {
        if (username == null || username.length() == 0) {
            return;
        }
        if (password == null || password.length() == 0) {
            return;
        }

        mUserManager.performLogin(username, password);
    }
}
```

要测试LoginPresenter的login方法，当对应的UserManager的performLogin方法被调用，并且参数一致，则表明该login方法测试通过。所以我们需要模拟一个UserManager方法：`UserManager mockUserManager = Mockito.mock(UserManager.class)`，将其作为参数传递给LoginPresenter，然后调用LoginPresenter的login方法，并传递用户名和密码：`loginPresenter.login("youngbear", "123456");`。最后，我们只需要验证该UserManager的performLogin()是否调用并且参数正确就好了: `Mockito.verify(mockUserManager).performLogin("youngbear", "123456");`

详细代码为：

```
public class LoginPresenterTest {

    @Test
    public void testLogin() throws Exception {

        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter(mockUserManager);
        loginPresenter.login("youngbear", "123456");


        Mockito.verify(mockUserManager).performLogin("youngbear", "123456");
    }
}
```

使用Mockito，**验证一个对象的方法调用情况**的姿势是：

```
Mockito.verify(objectToVerify).methodToVerify(arguments);
```

其中，objectToVerify和methodToVerify分别是你想要验证的对象和方法。对应上面的例子，那就是：

```
Mockito.verify(userManager).performLogin("xiaochuang", "xiaochuang password");
```

如果不关心参数，只关心方法调用了，则参数可以传递`anyString()`，表示参数是任意字符串:

```
verify(mockUserManager).performLogin(anyString(), anyString());
```

### mock的两个误解

#### 第一个误解：
Mockito.mock()并不是mock一整个类，而是根据传进去的一个类，mock出属于这个类的一个**对象**，并且返回这个mock对象；而传进去的这个类本身并没有改变，用这个类new出来的对象也没有受到任何改变！

#### 第二个误解：
mock出来的对象并不会自动替换掉正式代码里面的对象，你必须要有某种方式把mock对象应用到正式代码里面。


## API列表

### Mockito

1. `T mock(classToMock)` 模拟一个类的对象并返回。
2. `verify(object).method(arguments)` 验证对象object是否调用了方法method并且传递参数arguments，而且，仅调用了1次，具体可以参考源码。
3. `verify(object, times(count)).method(arguments)` 验证对象是否调用，并且是调用了count次。

#### 关于调用次数：
1. `times(count)` 调用了count次，用于verify函数。
2. `atMost(count)` 最多调用了count次。
3. `atLeast(count)` 最少调用了count次。
4. `atLeastOnce()` 最少调用了1次，相当于`atLeast(1)`。
5. `never()` 从来没有调用过。

#### 关于参数
1. `any()` 参数可以为任意对象。
2.  `T any(Class<T> type)` 任意类型为T的对象。
3. `anyString()` 参数可以为任意字符串。用于verify函数。
4. `anyInt()` 任意整型。
5. `anyList()` 任意列表。
...

## 名词解释

- TDD Test-Driven Development 测试驱动开发
- SRP Single Responsibility Principle 单一职责原则
