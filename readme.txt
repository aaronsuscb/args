第一部分：内容
(一)、实战项目一|命令行参数解析
一、TDD演示（1）
1、Create Annotation Option
(1)Alt+Shift+Enter
(2)鼠标放到需要创建的Annotation上面，会出现提示：Create Annotation Option
2、创建类
(1)Alt+Enter+Insert
(2)Alt+Enter,在选中Create class
3、在 IntelliJ IDEA 中跳转到当前行的行尾可以使用快捷键 End。具体操作步骤如下：
首先需要选中你想要跳转到行尾的行。
按下 End 快捷键即可跳转到该行的行尾处。
此外，还可以使用以下快捷键实现在行内快速跳转：
Home 键：跳转到当前行的行首。
Ctrl + 左箭头：跳转到当前单词的开头。
Ctrl + 右箭头：跳转到当前单词的结尾。
Shift + End：选中当前光标到行尾的所有内容。
Shift + Home：选中当前光标到行首的所有内容。
3、抽取方法、类等
Ctrl+Alt+M：抽取方法
Ctrl+Alt+V：抽取变量
Ctrl+Alt+F：抽取字段
Ctrl+Alt+C：抽取常量
Ctrl+Alt+P：抽取参数
4、inline
这个叫 inline 的东西快捷键是 Ctrl+Alt+n。 这个东西的作用是把当前光标上的东西，在代码级别内联掉。
按下这个快捷键后，会看到一个弹窗（这个是 inline 一个 Kotlin 方法的弹窗，对于 Java 还多几个选项。 不过这都不是重点啦）:
我们都默认选第一个，就是在 inline 之后删除被 inline 的东西，第二个是 inline 后保留。 如果你是在调用处而不是定义处这么搞，第三个选项就可以选，是只 inline 这一处。我们一般不管，使用第一个。

5、“：：”代表一种执行方法的方法
Integer::parseInt，代表是引用静态方法，类名：：静态方法名
(1) person -> person.getName();
   可以替换成：
   Person::getName
(2)()-> new HashMap<>();
   可以替换成：
   HashMap::new
 6、构造函数快捷键
 （1）无参
  alt+/,再回车
 （2）有参
  shift+alt+s
 7、在鼠标位置插入构造函数、get\set等方法的快捷键
  alt+insert

 8、注释
  添加单行注释：选中代码后，使用快捷键`Ctrl + /`。
  添加多行注释：使用快捷键`/* 注释内容 */`。
  取消单行注释：再次选中代码后，使用快捷键`Ctrl + /`。
  方法或类说明注释：输入`/ 注释内容 /`，然后按`Enter`键，会自动根据参数和返回值生成注释模板。
  以上快捷键操作可以在代码编辑时快速添加、修改和删除注释，提高编程效率

9、在 IntelliJ IDEA 里两步替换构造函数成工厂方法：
 （1）将光标放在构造函数的名称上
 （2）在 Refactor 菜单里选择「Replace Constructor with Factory Method」
 10、安全删除
  alt +delete
第二部分：Debug

第三部分：重构
